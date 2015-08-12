package org.atlasapi.deer.client.http;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.gson.Gson;

public class AtlasHttpClientTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private AtlasHttpClient successClient;
    private AtlasHttpClient failureClient;

    private GenericUrl url;
    private String expectedResponse;

    @Before
    public void setUp() throws Exception {
        url = new GenericUrl("http://fake.metabroadcast.com");
        expectedResponse = "content";

        successClient = getSuccessClient();
        failureClient = getFailureClient();
    }

    @Test
    public void testSuccessfulGet() throws Exception {
        String response = successClient.get(url, String.class);

        assertThat(response, is(expectedResponse));
    }

    @Test
    public void testFailedGetThrowsException() throws Exception {
        exception.expectCause(matches(400));
        failureClient.get(url, String.class);
    }

    private AtlasHttpClient getSuccessClient() throws IOException {
        MockLowLevelHttpResponse successfulResponse = new MockLowLevelHttpResponse()
                .setStatusCode(200)
                .setContentType("application/json")
                .setContent(new Gson().toJson(expectedResponse));

        MockHttpTransport successTransport = new MockHttpTransport.Builder()
                .setLowLevelHttpResponse(successfulResponse)
                .build();

        return new AtlasHttpClient(successTransport);
    }

    private AtlasHttpClient getFailureClient() {
        MockLowLevelHttpResponse failedResponse = new MockLowLevelHttpResponse()
                .setStatusCode(400)
                .setZeroContent();

        MockHttpTransport failureTransport = new MockHttpTransport.Builder()
                .setLowLevelHttpResponse(failedResponse)
                .build();

        return new AtlasHttpClient(failureTransport);
    }

    private Matcher<HttpResponseException> matches(int expectedStatusCode) {
        return new TypeSafeMatcher<HttpResponseException>() {

            @Override
            protected boolean matchesSafely(HttpResponseException item) {
                return expectedStatusCode == item.getStatusCode();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("status code should be ")
                        .appendValue(expectedStatusCode);
            }

            @Override
            protected void describeMismatchSafely(HttpResponseException item,
                    Description mismatchDescription) {
                mismatchDescription.appendValue("expected status code")
                        .appendValue(expectedStatusCode)
                        .appendText(", but was ")
                        .appendValue(item.getStatusCode());
            }
        };
    }
}
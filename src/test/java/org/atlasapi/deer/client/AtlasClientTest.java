package org.atlasapi.deer.client;

import org.atlasapi.deer.client.http.AtlasHttpClient;
import org.atlasapi.deer.client.model.ContentResponse;
import org.atlasapi.deer.client.model.types.Content;
import org.atlasapi.deer.client.query.ContentQuery;
import org.atlasapi.deer.client.uri.AtlasUrlCreator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HostAndPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.atlasapi.deer.client.uri.Annotation.ALL_MERGED_BROADCASTS;
import static org.atlasapi.deer.client.uri.Annotation.BROADCASTS;
import static org.atlasapi.deer.client.uri.Annotation.CUSTOM_FIELDS;
import static org.atlasapi.deer.client.uri.Annotation.EXTENDED_DESCRIPTION;
import static org.atlasapi.deer.client.uri.Annotation.ID;
import static org.atlasapi.deer.client.uri.Annotation.IS_PUBLISHED;
import static org.atlasapi.deer.client.uri.Annotation.LOCATIONS;
import static org.atlasapi.deer.client.uri.Annotation.MODIFIED_DATES;
import static org.atlasapi.deer.client.uri.Annotation.NON_MERGED;
import static org.atlasapi.deer.client.uri.Annotation.PEOPLE;
import static org.atlasapi.deer.client.uri.Annotation.REP_ID;
import static org.atlasapi.deer.client.uri.Annotation.TAGS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtlasClientTest {

    @Captor
    private ArgumentCaptor<GenericUrl> genericUrlCaptor;

    private AtlasClient atlasClient;

    @Mock
    private AtlasHttpClient atlasHttpClient;

    private AtlasUrlCreator urlCreator;

    @Before
    public void setUp() throws Exception {
        String host = "stage.atlas.metabroadcast.com";
        String apikey = "apikey";
        urlCreator = new AtlasUrlCreator("https", HostAndPort.fromString(host), apikey);

        atlasClient = new AtlasClient(atlasHttpClient, urlCreator);
    }

    @Test
    public void testGetContentWithSingleId() throws Exception {
        ContentQuery query = ContentQuery.get("id")
                .addType("item");

        ContentResponse expectedResponse = ContentResponse.builder().build();
        when(atlasHttpClient.get(any(GenericUrl.class), eq(ContentResponse.class)))
                .thenReturn(expectedResponse);

        ContentResponse actualResponse = atlasClient.getContent(query);

        assertSame(expectedResponse, actualResponse);

        verify(atlasHttpClient).get(genericUrlCaptor.capture(), eq(ContentResponse.class));

        assertThat(
                genericUrlCaptor.getValue(),
                is(urlCreator.getBuilder()
                        .content("id")
                        .addParams(ImmutableMap.of("type", "item"))
                        .build())
        );
    }

    @Test
    public void testGetContentWithMultipleIds() throws Exception {
        ContentQuery query = ContentQuery.get("idA", "idB")
                .addType("item");

        ContentResponse expectedResponse = ContentResponse.builder().build();
        when(atlasHttpClient.get(any(GenericUrl.class), eq(ContentResponse.class)))
                .thenReturn(expectedResponse);

        ContentResponse actualResponse = atlasClient.getContent(query);

        assertSame(expectedResponse, actualResponse);

        verify(atlasHttpClient).get(genericUrlCaptor.capture(), eq(ContentResponse.class));

        assertThat(
                genericUrlCaptor.getValue(),
                is(urlCreator.getBuilder()
                        .content()
                        .addParams(ImmutableMap.of("id", "idA,idB", "type", "item"))
                        .build())
        );
    }
}
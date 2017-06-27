package org.atlasapi.deer.client.uri;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.google.common.net.HostAndPort;
import org.junit.Before;
import org.junit.Test;

import com.google.api.client.http.GenericUrl;
import com.google.common.collect.ImmutableMap;

public class AtlasUrlCreatorTest {

    private AtlasUrlCreator urlCreator;

    private String schema;
    private String host;
    private String apiKey;

    @Before
    public void setUp() throws Exception {
        schema = "http";
        host = "stage.atlas.metabroadcast.com";
        apiKey = "key";
        urlCreator = new AtlasUrlCreator(
                schema, HostAndPort.fromString(host), apiKey
        );
    }

    @Test
    public void testBuildContentWithId() throws Exception {
        GenericUrl url = urlCreator.getBuilder()
                .content("contentId")
                .build();

        assertThat(
                url.build(),
                is(schema + "://" + host + "/4/content.json?key=" + apiKey + "&id=contentId")
        );
    }

    @Test
    public void testBuildContentWithoutId() throws Exception {
        GenericUrl url = urlCreator.getBuilder()
                .content()
                .build();

        assertThat(
                url.build(),
                is(schema + "://" + host + "/4/content.json?key=" + apiKey)
        );
    }

    @Test
    public void testBuildWithParams() throws Exception {
        GenericUrl url = urlCreator.getBuilder()
                .content()
                .addParams(ImmutableMap.of("keyA", "valueA", "keyB", "valueB"))
                .build();

        assertThat(
                url.build(),
                is(schema + "://" + host + "/4/content.json?key=" + apiKey +
                        "&keyA=valueA&keyB=valueB")
        );

    }
}
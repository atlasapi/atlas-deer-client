package org.atlasapi.deer.client.uri;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.api.client.http.GenericUrl;
import com.google.common.net.HostSpecifier;

public class AtlasUrlCreatorTest {

    private AtlasUrlCreator uriCreator;

    private String host;
    private String apiKey;

    @Before
    public void setUp() throws Exception {
        host = "stage.atlas.metabroadcast.com";
        apiKey = "key";
        uriCreator = new AtlasUrlCreator(
                HostSpecifier.fromValid(host), apiKey
        );
    }

    @Test
    public void testBuildWithAnnotations() throws Exception {
        GenericUrl url = uriCreator.getBuilder()
                .content("contentId")
                .addAnnotations(Annotation.DESCRIPTION, Annotation.AUDIT)
                .build();

        assertThat(
                url.build(),
                is("https://" + host + "/4/content/contentId.json?key=" + apiKey +
                        "&annotations=description,audit")
        );
    }

    @Test
    public void testBuildContent() throws Exception {
        GenericUrl url = uriCreator.getBuilder()
                .content()
                .addIds("idA", "idB")
                .build();

        assertThat(
                url.build(),
                is("https://" + host + "/4/content.json?key=" + apiKey + "&id=idA,idB")
        );
    }

    @Test
    public void testBuildContentWithId() throws Exception {
        GenericUrl url = uriCreator.getBuilder()
                .content("contentId")
                .build();

        assertThat(
                url.build(),
                is("https://" + host + "/4/content/contentId.json?key=" + apiKey)
        );
    }

    @Test
    public void testBuildWithAlias() throws Exception {
        GenericUrl url = uriCreator.getBuilder()
                .content()
                .addAlias("uri", "https://www.google.com")
                .build();

        assertThat(
                url.build(),
                is("https://" + host + "/4/content.json?key=" + apiKey +
                        "&aliases.namespace=uri&aliases.value=https://www.google.com")
        );
    }
}
package org.atlasapi.deer.client.query;

import org.atlasapi.deer.client.uri.Annotation;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ContentQueryTest {

    private ContentQuery query;

    @Before
    public void setUp() throws Exception {
        query = ContentQuery.get("id");
    }

    @Test
    public void testQueryOnSingleId() throws Exception {
        ContentQuery query = ContentQuery.get("id");

        assertTrue(query.getId().isPresent());
        assertThat(
                query.getId().get(),
                is("id")
        );
    }

    @Test
    public void testQueryOnMultipleIds() throws Exception {
        ContentQuery query = ContentQuery.get("idA", "idB");

        assertFalse(query.getId().isPresent());
        assertThat(
                query.getParams().get("id"),
                is("idA,idB")
        );
    }

    @Test
    public void testQueryOnListIds() throws Exception {
        ContentQuery query = ContentQuery.get(ImmutableList.of("idA", "idB"));

        assertFalse(query.getId().isPresent());
        assertThat(
                query.getParams().get("id"),
                is("idA,idB")
        );
    }

    @Test
    public void testAddAnnotations() throws Exception {
        query.addAnnotations(Annotation.AUDIT, Annotation.DESCRIPTION);

        assertThat(
                query.getParams().get("annotations"),
                is("audit,description")
        );
    }

    @Test
    public void testAddAlias() throws Exception {
        query.addAlias("ns", "value");

        assertThat(
                query.getParams().get("aliases.namespace"),
                is("ns")
        );

        assertThat(
                query.getParams().get("aliases.value"),
                is("value")
        );
    }

    @Test
    public void testAddPagination() throws Exception {
        query.addLimit(2).addOffset(6);

        assertThat(
                query.getParams().get("limit"),
                is("2")
        );

        assertThat(
                query.getParams().get("offset"),
                is("6")
        );
    }

    @Test
    public void testAddSource() throws Exception {
        query.addSource("source");

        assertThat(
                query.getParams().get("source"),
                is("source")
        );
    }

    @Test
    public void testAddType() throws Exception {
        query.addType("type");

        assertThat(
                query.getParams().get("type"),
                is("type")
        );
    }

    @Test
    public void testAddSearchQuery() throws Exception {
        query.addSearchQuery("alien");

        assertThat(
                query.getParams().get("q"),
                is("alien")
        );
    }
}
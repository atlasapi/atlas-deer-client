package org.atlasapi.deer.client.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.ObjectParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/** A parser implementation that uses jackson 2, as google-http-client-jackson2 doesn't work. */
public class JacksonParser implements ObjectParser {

    private final ObjectMapper mapper;

    public JacksonParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    // TODO use object reader

    @Override public <T> T parseAndClose(
            InputStream inputStream,
            Charset charset,
            Class<T> aClass
    ) throws IOException {
        return parseAndClose(new InputStreamReader(inputStream, charset), aClass);
    }

    @Override public Object parseAndClose(
            InputStream inputStream,
            Charset charset,
            Type type
    ) throws IOException {
        return parseAndClose(new InputStreamReader(inputStream, charset), type);
    }

    @Override public <T> T parseAndClose(
            Reader reader,
            Class<T> aClass
    ) throws IOException {
        return mapper.readValue(reader, aClass);
    }

    @Override public Object parseAndClose(
            Reader reader,
            Type type
    ) throws IOException {
        return mapper.readValue(
                reader,
                mapper.getTypeFactory().constructType(type)
        );
    }
}

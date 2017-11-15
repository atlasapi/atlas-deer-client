package org.atlasapi.deer.client.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.ObjectParser;

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
        try {
            return mapper.readValue(reader, aClass);
        } finally {
            reader.close();
        }
    }

    @Override public Object parseAndClose(
            Reader reader,
            Type type
    ) throws IOException {
        try {
            return mapper.readValue(
                    reader,
                    mapper.getTypeFactory().constructType(type)
            );
        } finally {
            reader.close();
        }
    }
}

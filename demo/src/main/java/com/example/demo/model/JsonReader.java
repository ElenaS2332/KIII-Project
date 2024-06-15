package com.example.demo.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JsonReader {
    public List<Wineries> readWineryData(Reader reader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(reader, new TypeReference<List<Wineries>>() {});
    }
}

package com.schoolmanagement.server.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class ServerResponse {
    public static ResponseEntity<List<Object>> responseListEntity(List<Object> object) {
        return new ResponseEntity<>(
                object,
                HttpStatus.OK);
    }

    public static ResponseEntity<Object> responseEntity(Object object) {
        return new ResponseEntity<>(
                object,
                HttpStatus.OK);
    }
    public static ResponseEntity<Object> responseMessage(String message) {
        return new ResponseEntity<>(Map.of("message", message), HttpStatus.OK);
    }

    public static ResponseEntity<Object> responseNotFound(String message) {
        return new ResponseEntity<>(Map.of("message", message), HttpStatus.NOT_FOUND);
    }
    public static ResponseEntity<Object> internalServerErrorMessage(String message) {
        return new ResponseEntity<>(
                Map.of("message", message),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

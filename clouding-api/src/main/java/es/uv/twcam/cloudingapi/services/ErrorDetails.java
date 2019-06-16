package es.uv.twcam.cloudingapi.services;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * ErrorDetails
 */

@Data
public class ErrorDetails {

    private String errorCode;
    private String errorMessage;
    private String devErrorMessage;
    private Map<String, Object> additionalData = new HashMap<>();
}
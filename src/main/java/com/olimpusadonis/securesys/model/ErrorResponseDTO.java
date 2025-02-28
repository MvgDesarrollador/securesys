package com.olimpusadonis.securesys.model;

import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public class ErrorResponseDTO {
    private Optional<String> errorDescription;
    private List<ErrorDetail> errorDetail;
}

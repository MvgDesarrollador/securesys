package com.olimpusadonis.securesys.model;

import lombok.Builder;

@Builder
public class ResponseDTO<T> {

    private T data;
    private ErrorResponseDTO errors;

}

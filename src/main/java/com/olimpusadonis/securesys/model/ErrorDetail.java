package com.olimpusadonis.securesys.model;

import lombok.Builder;

public enum ErrorDetail {
    GENERIC_ERROR(00001,"generic_error"),
    NOT_FOUND(00002, "not_found"),
    INVALID_INPUT(00003, "invalid_input");

    private int codeError;
    private String descriptionError;

    ErrorDetail(int codeError, String descriptionError) {
        this.codeError = codeError;
        this.descriptionError = descriptionError;
    }

    // Método para obtener el código de error
    public int getCodeError() {
        return codeError;
    }

    // Método para obtener la descripción del error
    public String getDescriptionError() {
        return descriptionError;
    }
}

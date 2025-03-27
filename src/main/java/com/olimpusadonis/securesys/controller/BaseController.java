package com.olimpusadonis.securesys.controller;

import com.olimpusadonis.securesys.config.annotations.ApiVersion;

public abstract class BaseController {

    protected String getBasePath() {
        // Obtiene la versión a partir de la anotación ApiVersion
        ApiVersion apiVersion = this.getClass().getAnnotation(ApiVersion.class);
        return "/api/" + (apiVersion != null ? apiVersion.value() : "v1");
    }
}

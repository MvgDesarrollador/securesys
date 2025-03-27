package com.olimpusadonis.securesys.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contact {
    private String name;
    private String site;
    private String email;
}

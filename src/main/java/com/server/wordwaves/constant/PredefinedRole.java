package com.server.wordwaves.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum PredefinedRole {
    USER_ROLE("USER"),
    ADMIN_ROLE("ADMIN"),
    EMPLOYER_ROLE("EMPLOYER"),
    ;
    String name;

    PredefinedRole(String name) {
        this.name = name;
    }
}
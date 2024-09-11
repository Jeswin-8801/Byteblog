package com.jeswin8801.byteBlog.util.exceptions.enums;

import lombok.Getter;

@Getter
public enum UserExceptions {

    USER_RECORD_NOT_FOUND("User not found"),
    USER_EMAIL_NOT_AVAILABLE("An account with the given email already exists"),
    USER_USERNAME_NOT_AVAILABLE("An account with the given username already exists"),
    PASSWORD_MISMATCH("Current password is incorrect"),
    MATCHING_VERIFICATION_RECORD_NOT_FOUND("Provided verification request is incorrect"),
    INVALID_PASSWORD_RESET_REQUEST("Provided Password reset request is incorrect");

    private final String message;

    UserExceptions(String message) {
        this.message = message;
    }
}

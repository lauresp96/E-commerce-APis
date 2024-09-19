package org.mihailivadaru.ecommerce.APIControllers;

import java.time.LocalDateTime;

public class ApiResponse {
    private final boolean SUCCESS;
    private final String MESSAGE;

    public ApiResponse(boolean success, String message) {
        SUCCESS = success;
        MESSAGE = message;
    }

    public boolean isSUCCESS() {
        return SUCCESS;
    }
    public String getMessage() {
        return MESSAGE;
    }

    public String getTimestamp(){
        return LocalDateTime.now().toString();
    }
}

package com.softplan.valuewithtaxes.entrypoint.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResponseExceptionTest {

    @Test
    public void shouldBeReturnMessage() {
        String message = "test message";
        Assertions.assertEquals(message, new ResponseException(message).getMessage());
    }
}
package com.rafamilo.usecases.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class FileGreaterThanDiskExceptionTest {

    @Test
    public void messageNeedToBeEqual() {
        Assert.assertEquals("File size cannot be greater than disk size", new FileGreaterThanDiskException().getMessage());
    }
}
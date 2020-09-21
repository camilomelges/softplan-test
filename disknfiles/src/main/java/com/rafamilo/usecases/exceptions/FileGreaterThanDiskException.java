package com.rafamilo.usecases.exceptions;

public class FileGreaterThanDiskException extends RuntimeException {

    public FileGreaterThanDiskException() {
        super("File size cannot be greater than disk size");
    }
}

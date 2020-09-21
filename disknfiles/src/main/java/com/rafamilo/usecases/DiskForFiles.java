package com.rafamilo.usecases;

public class DiskForFiles implements IDiskForFiles {

    public String run(String args[]) {
        return args[0];
    }
}

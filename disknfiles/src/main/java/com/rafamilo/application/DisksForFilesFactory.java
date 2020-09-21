package com.rafamilo.application;

import com.rafamilo.usecases.DiskForFiles;
import com.rafamilo.usecases.IDiskForFiles;

public abstract class DisksForFilesFactory {
    public static IDiskForFiles diskForFiles() {
        return new DiskForFiles();
    }
}

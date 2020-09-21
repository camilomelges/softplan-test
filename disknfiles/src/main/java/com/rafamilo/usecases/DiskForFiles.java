package com.rafamilo.usecases;

import com.rafamilo.usecases.exceptions.FileGreaterThanDiskException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiskForFiles implements IDiskForFiles {

    public String run(final String args[]) {
        if (args == null || args.length == 0) {
            return printNReturnString("Args need to be passed");
        }

        if (args[0].isEmpty() || args[0] == "null") {
            return printNReturnString("Disk size need to be passed");
        }

        if (Integer.valueOf(args[0]) <= 0) {
            return printNReturnString("Disk size need to greater than zero");
        }

        try {
            if (args[1].isEmpty() || args[1] == "null") {
                return printNReturnString("Need at least one file");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return printNReturnString("Need at least one file");
        }

        Integer diskSize = Integer.valueOf(args[0]);

        List<Integer> files = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            files.add(Integer.valueOf(args[i]));
        }

        Integer qtDisks = 0;

        try {
            qtDisks = getQtOfDisks(diskSize, files, 0);
        } catch (FileGreaterThanDiskException e) {
            return new FileGreaterThanDiskException().getMessage();
        }

        return qtDisks.toString();
    }

    private Integer getQtOfDisks(final Integer diskSize, final List<Integer> files, Integer count) throws FileGreaterThanDiskException {
        List<Integer> newFiles = new ArrayList<>();
        final Integer[] sum = {0};

        files.stream().forEach(fileSize -> {
            if (fileSize > diskSize) {
                throw new FileGreaterThanDiskException();
            }

            if ((sum[0] + fileSize) <= diskSize) {
                sum[0] += fileSize;
            } else {
                newFiles.add(fileSize);
            }
        });

        count++;

        if (!newFiles.isEmpty()) {
            return getQtOfDisks(diskSize, newFiles, count);
        } else {
            return count;
        }
    }

    private String printNReturnString(final String str) {
        System.out.println(str);
        return str;
    }
}

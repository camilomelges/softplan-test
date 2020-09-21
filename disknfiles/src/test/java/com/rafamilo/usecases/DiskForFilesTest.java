package com.rafamilo.usecases;

import org.junit.Assert;
import org.junit.Test;

public class DiskForFilesTest {

    private DiskForFiles diskForFiles = new DiskForFiles();

    @Test
    public void shouldBeReturnErrorIfArgsIsNullOrLenghEqualsZero() {
        Assert.assertEquals("Args need to be passed", diskForFiles.run(null));
    }

    @Test
    public void shouldBeReturnErrorIfDiskIsEmpty() {
        String[] args = {""};
        Assert.assertEquals("Disk size need to be passed", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnErrorIfDiskIsNull() {
        String[] args = {"null"};
        Assert.assertEquals("Disk size need to be passed", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnErrorIfDiskIsLowerOrEqualZero() {
        String[] args = {"0"};
        Assert.assertEquals("Disk size need to greater than zero", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnErrorIfNotPassAtLeastOneFile() {
        String[] args = {"1"};
        Assert.assertEquals("Need at least one file", diskForFiles.run(args));

        String[] args2 = {"1", ""};
        Assert.assertEquals("Need at least one file", diskForFiles.run(args2));

        String[] args3 = {"1", "null"};
        Assert.assertEquals("Need at least one file", diskForFiles.run(args3));
    }

    @Test
    public void shouldBeReturnTwo() {
        String[] args = {"100", "20", "30", "50", "10", "15"};
        Assert.assertEquals("++++++++++++++++++++++++++++++++++++++++++++++++++++++ 2 DISKS ++++++++++++++++++++++++++++++++++++++++++++++++++++++", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnThree() {
        String[] args = {"100", "90", "20", "30", "50", "10", "15"};
        Assert.assertEquals("++++++++++++++++++++++++++++++++++++++++++++++++++++++ 3 DISKS ++++++++++++++++++++++++++++++++++++++++++++++++++++++", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnThree2() {
        String[] args = {"90", "90", "20", "30", "50", "10", "15"};
        Assert.assertEquals("++++++++++++++++++++++++++++++++++++++++++++++++++++++ 3 DISKS ++++++++++++++++++++++++++++++++++++++++++++++++++++++", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnErrorIfFileSizesIsGreaterThanDiskSize() {
        String[] args = {"80", "20", "30", "50", "10", "15", "90"};
        Assert.assertEquals("File size cannot be greater than disk size", diskForFiles.run(args));
    }

    @Test
    public void shouldBeReturnSix() {
        String[] args = {"80", "80", "80", "80", "80", "79", "1", "11", "12", "23", "34"};
        Assert.assertEquals("++++++++++++++++++++++++++++++++++++++++++++++++++++++ 6 DISKS ++++++++++++++++++++++++++++++++++++++++++++++++++++++", diskForFiles.run(args));
    }
}
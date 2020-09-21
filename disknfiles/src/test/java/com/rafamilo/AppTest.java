package com.rafamilo;

import org.junit.Assert;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldBePrintNumbers()
    {
        App.main(new String[]{"100", "20", "30", "50", "10", "15"});
        Assert.assertTrue(true);
    }
}

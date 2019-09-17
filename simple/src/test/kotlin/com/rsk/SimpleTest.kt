package com.rsk

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleTest{
    @Test
    fun firstTest(){
        //doWork()
        Assert.assertEquals(2, 1+ 1)
    }

    @Test
    fun secondTest() = runBlocking{
        doWork()
        Assert.assertEquals(2, 1+ 1)
    }
}
package org.example.Asserts;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertContainer {
    private static SoftAssert assertContainer = new SoftAssert();

    public static void addAssert(String message){
        assertContainer.fail(message);
    }
    public static void assertAll(){
        assertContainer.assertAll();
    }



}

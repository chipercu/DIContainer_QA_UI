package org.example.Pages;

import org.example.Annotations.Inpact;
import org.example.Elements.ExtWebElement;
import org.example.Elements.ExtWebElementImpl;

import java.util.Optional;

public class MainPage extends BasePage{


    @Inpact(xpath = "dfasdfasdf")
    private ExtWebElement element;
    @Inpact(xpath = "//div[@Class='asdasd']")
    private ExtWebElement element2;


    public MainPage open(){

        final String s = ifNotNullElse(driver.findElement("asd"), "asdasfd", "asdfas");

        final Optional<ExtWebElement> sadfasdf = driver.findElement("sadfasdf");


        return this;
    }



}

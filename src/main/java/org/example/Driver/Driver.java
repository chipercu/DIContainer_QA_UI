package org.example.Driver;

import org.example.Elements.ExtWebElement;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public interface Driver {

    WebDriver getDriver();

    Optional<ExtWebElement> findElement(String xPath);



}

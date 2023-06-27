package org.example.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public interface ExtWebElement {

    WebElement getWebElement();
    ExtWebElement click();
    String getXPath();
    String getTag();
    Optional<String> getText();
    ExtWebElement inputText(String text);
    ExtWebElement dblClick();
    ExtWebElement rightClick();
    Optional<ExtWebElement> getParent();
    List<ExtWebElement> getChildren(By by);



}

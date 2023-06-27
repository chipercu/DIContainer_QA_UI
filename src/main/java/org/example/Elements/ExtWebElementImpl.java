package org.example.Elements;

import org.example.Asserts.AssertContainer;
import org.example.Driver.ChromeDriverImpl;
import org.example.Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExtWebElementImpl implements ExtWebElement{

    private String xPath;
    private WebElement element;

    private Driver driver = ChromeDriverImpl.getInstance();

    public ExtWebElementImpl(){
    }
    public ExtWebElementImpl(WebElement element, String xPath){
        this.element = element;
        this.xPath = xPath;
    }

    public ExtWebElementImpl(String xpath){
        this.xPath = xpath;
        this.element = driver.getDriver().findElement(By.xpath(xpath));
    }
    public WebElement getWebElement() {
        return null;
    }

    public ExtWebElement click() {
        element.click();
        return this;
    }

    public String getXPath() {
        return xPath;
    }

    public String getTag() {
        return element.getTagName();
    }

    public Optional<String> getText() {
        if (element.getText() != null){
            return Optional.of(element.getText());
        }else {
            return Optional.empty();
        }
    }

    public ExtWebElement inputText(String text) {
        try {
            element.sendKeys(text);
        }catch (Exception e){
            AssertContainer.addAssert(String.format("В данный элемент нельзя вставить текст: tag-%s | xPath- %s", element.getTagName(), getXPath()));
        }
        return this;
    }

    public ExtWebElement dblClick() {
        return this;
    }

    public ExtWebElement rightClick() {
        return this;
    }

    public Optional<ExtWebElement> getParent() {
        try {
            final String xpath = xPath + "/..";
            final WebElement parent = element.findElement(By.xpath(xpath));
            return Optional.of(new ExtWebElementImpl(parent, xpath));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public List<ExtWebElement> getChildren(By by) {
        final List<WebElement> elements = element.findElements(by);
        if (elements == null || elements.isEmpty()){
            AssertContainer.addAssert(String.format("У данного элемента нет внутренних элементов: tag-%s | xPath- %s", element.getTagName(), getXPath()));
            return new ArrayList<>();
        }else {
            return elements.stream().map(e -> new ExtWebElementImpl(e, "")).collect(Collectors.toList());
        }
    }
}

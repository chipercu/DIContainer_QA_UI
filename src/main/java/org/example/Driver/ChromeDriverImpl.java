package org.example.Driver;

import lombok.Getter;
import lombok.Setter;
import org.example.Elements.ExtWebElement;
import org.example.Elements.ExtWebElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class ChromeDriverImpl implements Driver {

    private WebDriver driver;

    public static class Holder {
        public static final ChromeDriverImpl HOLDER_INSTANCE = new ChromeDriverImpl();
    }

    public static ChromeDriverImpl getInstance() {
        return Holder.HOLDER_INSTANCE;
    }

    private ChromeDriverImpl() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public Optional<ExtWebElement> findElement(String xPath) {
        try {
            return Optional.of(new ExtWebElementImpl(xPath));
        }catch (Exception e){
            return Optional.empty();
        }
    }

}

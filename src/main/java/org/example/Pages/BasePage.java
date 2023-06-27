package org.example.Pages;

import org.example.Driver.ChromeDriverImpl;
import org.example.Driver.Driver;
import org.example.Elements.ExtWebElementImpl;
import org.example.Util.PageUtils;

public class BasePage extends PageUtils {

    protected Driver driver = ChromeDriverImpl.getInstance();

    protected ExtWebElementImpl findElement(String xPath){
        return (ExtWebElementImpl) driver.findElement(xPath).orElse(null);
    }



}

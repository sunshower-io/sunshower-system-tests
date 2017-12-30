package io.sunshower.webtests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebTest {

    public void waitForInitialization(WebDriver driver) {
        new WebDriverWait(driver,
                TimeUnit.SECONDS.toSeconds(10)
        ).until(webDriver -> {
                    Object value = ((JavascriptExecutor) webDriver)
                            .executeScript("return window.Application && !window.Application.isLoading()");
                    return value;
                }
        );
    }

}

package io.sunshower.webtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;


import static org.junit.Assert.assertEquals;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebTestConfiguration.class)
public class IndexTest extends WebTest {

    @Inject
    private WebDriver driver;

    @Inject
    private Location location;


    @Test
    public void ensureUserCanAccessLandingPage() {
        driver.get(location.html("index"));
        waitForInitialization(driver);
        assertEquals("login | Sunshower", driver.getTitle());
    }


}

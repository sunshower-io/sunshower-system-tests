package io.sunshower.webtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class WebTestConfiguration {


    static final Logger log = Logger.getLogger(WebTestConfiguration.class.getName());
    
    @Bean
    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        return new ChromeDriver(options);
    }


    @Bean
    public Location webLocation() {
        String url;

        if (System.getenv("SUNSHOWER_URL") != null) {
            url = System.getenv("SUNSHOWER_URL");
            log.log(Level.INFO, "Located sunshower URL from env: {0}", url);
        } else if (System.getProperty("sunshower.url") != null) {
            url = System.getProperty("sunshower.url");
            log.log(Level.INFO, "Located sunshower URL from properties: {0}", url);
        } else {
            url = "http://localhost:9001/dev";
            log.log(Level.INFO, "No sunshower location specified. Defaulting to: {0}", url);
        }
        return new Location(url);
    }
}

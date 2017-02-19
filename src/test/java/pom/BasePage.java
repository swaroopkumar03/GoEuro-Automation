package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by skumar on 2/16/17.
 */
abstract public class BasePage {

public BasePage(WebDriver driver){
    PageFactory.initElements(driver,this);
}
}

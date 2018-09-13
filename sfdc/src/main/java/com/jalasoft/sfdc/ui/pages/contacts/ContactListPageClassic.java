package com.jalasoft.sfdc.ui.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Contact list Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactListPageClassic extends ContactListPage {

    private static final String TITLE_NEW = "//input[@title='New']";
    private static final String EXIT_BUTTON = "//*[@class='dialogClose']";

    @FindBy(xpath = TITLE_NEW)
    private WebElement newButton;

    @FindBy(xpath = EXIT_BUTTON)
    private WebElement exitBtn;

    /**
     * new class contact form type classic.
     *
     * @return contact form classic.
     */
    @Override
    public ContactForm goToContactNewForm() {
        wait.until(ExpectedConditions.visibilityOf(newButton));
        if (driverTools.isElementDisplayed(exitBtn)){
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(newButton);
        return new ContactFormClassic();
    }
}

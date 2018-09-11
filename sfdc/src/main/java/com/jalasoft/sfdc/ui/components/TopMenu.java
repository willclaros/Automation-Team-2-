package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.profiles.ProfilePage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;

/**
 * Top bar that contains the user name information, settings and logout options.
 * {@link BasePage} class
 *
 * @author Silvia Valencia
 * @since 7/3/2018.
 */
public abstract class TopMenu extends BasePage {

    public abstract void swithSkin();

    public LoginPage logout(){
        return new LoginPage();
    }

    public abstract HomePage goToHomePage ();

    public abstract ProfilePage goToProfilePage();

    public  abstract AllAppsPage goToAllPages();
}

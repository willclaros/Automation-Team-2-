package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums.Skin;
import com.jalasoft.sfdc.ui.components.TopMenu;
import com.jalasoft.sfdc.ui.components.TopMenuClassic;
import com.jalasoft.sfdc.ui.components.TopMenuLight;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;


public class PageFactory {
    private static Skin skin = ServersConfigReader.getInstance().getSkin();

    //****************************************************************
    // Pages
    //****************************************************************

    /**
     * Returns an Instance of HomePage for the respective Skin
     *
     * @return
     */
    public static HomePage getHomePage() {
        switch (skin) {
            case CLASSIC:
                return new HomePageClassic();
            default:
                return new HomePageLight();
        }
    }

    public static TopMenu getTopMenu() {
        switch (skin) {
            case CLASSIC:
                return new TopMenuClassic();
            default:
                return new TopMenuLight();
        }
    }

}

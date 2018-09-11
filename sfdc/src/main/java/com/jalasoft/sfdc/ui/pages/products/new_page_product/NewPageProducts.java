package com.jalasoft.sfdc.ui.pages.products.new_page_product;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.products.product_detail_page.ProductsDetailPage;

public abstract class NewPageProducts extends BasePage {

    public abstract ProductsDetailPage setFormular(String name);
    public abstract ProductsDetailPage clickSaveBtn();

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}

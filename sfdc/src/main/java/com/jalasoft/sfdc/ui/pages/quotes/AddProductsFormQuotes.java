package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.entities.QuoteLineItems;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class AddProductsFormQuotes extends BasePage {

    public abstract QuotesDetailPage fillDataProducts(Product product, QuoteLineItems quoteLineItems);
}

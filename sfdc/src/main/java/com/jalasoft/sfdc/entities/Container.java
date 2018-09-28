package com.jalasoft.sfdc.entities;

public class Container {
    private Product product;
    private Account account;
    private Opportunity opportunity;
    private Contact contact;
    private PriceBook priceBook;
    private QuoteLineItems quoteLineItems;
    private Quote quote;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public PriceBook getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(PriceBook priceBook) {
        this.priceBook = priceBook;
    }

    public QuoteLineItems getQuoteLineItems() {
        return quoteLineItems;
    }

    public void setQuoteLineItems(QuoteLineItems quoteLineItems) {
        this.quoteLineItems = quoteLineItems;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}

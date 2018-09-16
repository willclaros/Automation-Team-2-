package com.jalasoft.sfdc.entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User class contains the account information.
 *
 * @author Cesar Calvi Lujan
 * @since 9/12/2018
 */
public class Account {
    private String accountName = "";
    private String phone = "";
    private String fax = "";
    private String accountNumber = "";
    private String webSite = "";
    private String accountSite = "";
    private String ticker = "";
    private String employees = "";
    private String annualRevenue = "";
    private String sicCode = "";
    private String sector = "";
    private String billingStreet = "";
    private String billingCity = "";
    private String billingState = "";
    private String billingZip = "";
    private String billingCountry = "";
    private String shippingStreet = "";
    private String shippingCity = "";
    private String shippingState = "";
    private String shippingZip = "";
    private String shippingCountry = "";
    private String slaExpirationDate = "";
    private String slaSerialNumber = "";
    private String numberOfLocations = "";
    private String description = "";
    private String rating ="";
    private String id = "";

    /**
     * Gets the account name.
     * @return the current account name.
     */
    public String getAccountName() {
        return  accountName;
    }

    /**
     * Sets the account name.
     * @param accountName user name to set.
     */
    public void setAccountName(final String accountName) {
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.accountName = accountName;
    }

    /**
     * Gets the account phone.
     * @return the value of the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the account phone.
     * @param phone account phone to set.
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Gets the account fax.
     * @return the value of the fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the account fax.
     * @param fax account fax to set.
     */
    public void setFax(final String fax) {
        this.fax = fax;
    }

    /**
     * Gets the account number.
     * @return the value of the number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     * @param accountNumber account number to set.
     */
    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the account Web site.
     * @return the value of the Web site.
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * Sets the account Web site.
     * @param webSite account Web site to set.
     */
    public void setWebSite(final String webSite) {
        this.webSite = webSite;
    }

    /**
     * Gets the account site.
     * @return the value of the account site.
     */
    public String getAccountSite() {
        return accountSite;
    }

    /**
     * Sets the account site.
     * @param accountSite account site to set.
     */
    public void setAccountSite(final String accountSite) {
        this.accountSite = accountSite;
    }

    /**
     * Gets the account ticker.
     * @return the value of the account ticker.
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Sets the account ticker.
     * @param ticker account ticker to set.
     */
    public void setTicker(final String ticker) {
        this.ticker = ticker;
    }

    /**
     * Gets the account employees.
     * @return the value of the account employees.
     */
    public String getEmployees() {
        return employees;
    }

    /**
     * Sets the account employees.
     * @param employees account employees to set.
     */
    public void setEmployees(final String employees) {
        this.employees = employees;
    }

    /**
     * Gets the account Annual Revenue.
     * @return the value of the account Annual Revenue.
     */
    public String getAnnualRevenue() {
        return annualRevenue;
    }

    /**
     * Sets the account Annual Revenue.
     * @param annualRevenue account Annual Revenue to set.
     */
    public void setAnnualRevenue(final String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    /**
     * Gets the account Sic Code.
     * @return the value of the account Sic Code.
     */
    public String getSicCode() {
        return sicCode;
    }

    /**
     * Sets the account Sic Code.
     * @param sicCode account Sic Code to set.
     */
    public void setSicCode(final String sicCode) {
        this.sicCode = sicCode;
    }

    /**
     * Gets the account Sector.
     * @return the value of the account Sector.
     */
    public String getSector() {
        return sector;
    }

    /**
     * Sets the account Sector.
     * @param sector account Sector to set.
     */
    public void setSector(final String sector) {
        this.sector = sector;
    }

    /**
     * Gets the account Billing Street.
     * @return the value of the account Billing Street.
     */
    public String getBillingStreet() {
        return billingStreet;
    }

    /**
     * Sets the account Billing Street.
     * @param billingStreet account Billing Street to set.
     */
    public void setBillingStreet(final String billingStreet) {
        this.billingStreet = billingStreet;
    }

    /**
     * Gets the account Billing City.
     * @return the value of the account Billing City.
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * Sets the account Billing City.
     * @param billingCity account Billing City to set.
     */
    public void setBillingCity(final String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * Gets the account Billing State.
     * @return the value of the account Billing State.
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     * Sets the account Billing State.
     * @param billingState account Billing State to set.
     */
    public void setBillingState(final String billingState) {
        this.billingState = billingState;
    }

    /**
     * Gets the account Billing Zip.
     * @return the value of the account Billing Zip.
     */
    public String getBillingZip() {
        return billingZip;
    }

    /**
     * Sets the account Billing Zip.
     * @param billingZip account Billing Zip to set.
     */
    public void setBillingZip(final String billingZip) {
        this.billingZip = billingZip;
    }

    /**
     * Gets the account Billing Country.
     * @return the value of the account Billing Country.
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     * Sets the account Billing County.
     * @param billingCountry account Billing County to set.
     */
    public void setBillingCountry(final String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     * Gets the account Shipping Street.
     * @return the value of the account Shipping Street.
     */
    public String getShippingStreet() {
        return shippingStreet;
    }

    /**
     * Sets the account Shipping Street.
     * @param shippingStreet account Shipping Street to set.
     */
    public void setShippingStreet(final String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    /**
     * Gets the account Shipping City.
     * @return the value of the account Shipping City.
     */
    public String getShippingCity() {
        return shippingCity;
    }

    /**
     * Sets the account Shipping City.
     * @param shippingCity account Shipping City to set.
     */
    public void setShippingCity(final String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * Gets the account Shipping State.
     * @return the value of the account Shipping State.
     */
    public String getShippingState() {
        return shippingState;
    }

    /**
     * Sets the account Shipping State.
     * @param shippingState account Shipping State to set.
     */
    public void setShippingState(final String shippingState) {
        this.shippingState = shippingState;
    }

    /**
     * Gets the account Shipping Zip.
     * @return the value of the account Shipping Zip.
     */
    public String getShippingZip() {
        return shippingZip;
    }

    /**
     * Sets the account Shipping Zip.
     * @param shippingZip account Shipping Zip to set.
     */
    public void setShippingZip(final String shippingZip) {
        this.shippingZip = shippingZip;
    }

    /**
     * Gets the account Shipping Country.
     * @return the value of the account Shipping Country.
     */
    public String getShippingCountry() {
        return shippingCountry;
    }

    /**
     * Sets the account Shipping Country.
     * @param shippingCountry account Shipping Country to set.
     */
    public void setShippingCountry(final String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    /**
     * Gets the account Sla Expiration Date.
     * @return the value of the account Sla Expiration Date.
     */
    public String getSlaExpirationDate() {
        return slaExpirationDate;
    }

    /**
     * Sets the account Sla Expiration Date.
     * @param slaExpirationDate account Sla Expiration Date to set.
     */
    public void setSlaExpirationDate(final String slaExpirationDate) {
        this.slaExpirationDate = slaExpirationDate;
    }

    /**
     * Gets the account Sla Serial Number.
     * @return the value of the account Sla Serial Number.
     */
    public String getSlaSerialNumber() {
        return slaSerialNumber;
    }

    /**
     * Sets the account Sla Serial Number.
     * @param slaSerialNumber account Sla Serial Number to set.
     */
    public void setSlaSerialNumber(final String slaSerialNumber) {
        this.slaSerialNumber = slaSerialNumber;
    }

    /**
     * Gets the account Number Of Locations.
     * @return the value of the account Number Of Locations.
     */
    public String getNumberOfLocations() {
        return numberOfLocations;
    }

    /**
     * Sets the account Number Of Locations.
     * @param numberOfLocations account Number Of Locations to set.
     */
    public void setNumberOfLocations(final String numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    /**
     * Gets the account Description.
     * @return the value of the account Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the account Description.
     * @param description account Description to set.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
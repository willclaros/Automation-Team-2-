package com.jalasoft.sfdc.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    private String id;
    private String salutation = "";
    private String firstName = "";
    private String lastName = "";
    private String homePhone = "";
    private String accountName = "";
    private String mobile = "";
    private String title = "";
    private String otherPhone = "";
    private String departament = "";
    private String fax = "";
    private String birthdate = "";
    private String email = "";
    private String reportTo = "";
    private String assistant = "";
    private String leadSource = "";
    private String asstPhone = "";
    private String mailingStreet = "";
    private String mailingZip = "";
    private String mailingCity = "";
    private String mailingState = "";
    private String mailingCountry = "";
    private String otherStreet = "";
    private String otherZip = "";
    private String otherCity = "";
    private String otherState = "";
    private String otherCountry = "";
    private String languages = "";
    private String level = "";
    private String description = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the Salutation.
     * @return the current Salutation.
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the salutation.
     * @param salutation user salutation.
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * Gets the first name.
     * @return the current first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * @param firstName user first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     * @return the current getLastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last Name.
     * @param lastName user last Name.
     */
    public void setLastName(String lastName)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.lastName = lastName;
    }

    /**
     * Gets the Home Phone.
     * @return the current getHomePhone.
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Sets the last home Phone.
     * @param homePhone user home Phone.
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Gets the get Account Name.
     * @return the current getHomePhone.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the account Name.
     * @param accountName user account Name.
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Gets the get Mobile.
     * @return the current getMobile.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile.
     * @param mobile user mobile.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the get Title.
     * @return the current getTitle.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * @param title user title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the get Other Phone.
     * @return the current getOtherPhone.
     */
    public String getOtherPhone() {
        return otherPhone;
    }

    /**
     * Sets the other phone.
     * @param otherPhone user other phone.
     */
    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    /**
     * Gets the get Departament.
     * @return the current getDepartament.
     */
    public String getDepartament() {
        return departament;
    }

    /**
     * Sets the departament.
     * @param departament user departament.
     */
    public void setDepartament(String departament) {
        this.departament = departament;
    }

    /**
     * Gets the get Fax.
     * @return the current getFax.
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the fax.
     * @param fax user fax.
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the get Birthdate.
     * @return the current getBirthdate.
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate.
     * @param birthdate user birthdate.
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Gets the get Email.
     * @return the current getEmail.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * @param email user email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the get Report To.
     * @return the current getReportTo.
     */
    public String getReportTo() {
        return reportTo;
    }

    /**
     * Sets the reportTo.
     * @param reportTo user reportTo.
     */
    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    /**
     * Gets the get Assistant.
     * @return the current Assistant.
     */
    public String getAssistant() {
        return assistant;
    }

    /**
     * Sets the assistant.
     * @param assistant user assistant.
     */
    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    /**
     * Gets the get Lead Source.
     * @return the current Lead Source.
     */
    public String getLeadSource() {
        return leadSource;
    }

    /**
     * Sets the lead Source.
     * @param leadSource user lead Source.
     */
    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    /**
     * Gets the get Asst Phone.
     * @return the current Asst Phone.
     */
    public String getAsstPhone() {
        return asstPhone;
    }

    /**
     * Sets the asst Phone.
     * @param asstPhone user asst Phone.
     */
    public void setAsstPhone(String asstPhone) {
        this.asstPhone = asstPhone;
    }

    /**
     * Gets the get Mailing Street.
     * @return the current Mailing Street.
     */
    public String getMailingStreet() {
        return mailingStreet;
    }

    /**
     * Sets the mailing Street.
     * @param mailingStreet user mailing Street.
     */
    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    /**
     * Gets the get Mailing Zip.
     * @return the current Mailing Zip.
     */
    public String getMailingZip() {
        return mailingZip;
    }

    /**
     * Sets the mailing Zip.
     * @param mailingZip user mailing Zip.
     */
    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }

    /**
     * Gets the get Mailing City.
     * @return the current Mailing City.
     */
    public String getMailingCity() {
        return mailingCity;
    }

    /**
     * Sets the mailing City.
     * @param mailingCity user mailing City.
     */
    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    /**
     * Gets the get Mailing State.
     * @return the current Mailing State.
     */
    public String getMailingState() {
        return mailingState;
    }

    /**
     * Sets the mailing State.
     * @param mailingState user mailing State.
     */
    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    /**
     * Gets the get Mailing Country.
     * @return the current MailingCountry.
     */
    public String getMailingCountry() {
        return mailingCountry;
    }

    /**
     * Sets the mailing mailing Country.
     * @param mailingCountry user mailing Country.
     */
    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    /**
     * Gets the get Other Street.
     * @return the current OtherStreet.
     */
    public String getOtherStreet() {
        return otherStreet;
    }

    /**
     * Sets the mailing other Street.
     * @param otherStreet user other Street.
     */
    public void setOtherStreet(String otherStreet) {
        this.otherStreet = otherStreet;
    }

    /**
     * Gets the get Other Zip.
     * @return the current OtherZip.
     */
    public String getOtherZip() {
        return otherZip;
    }

    /**
     * Sets the mailing other Zip.
     * @param otherZip user other Zip.
     */
    public void setOtherZip(String otherZip) {
        this.otherZip = otherZip;
    }

    /**
     * Gets the get Other City.
     * @return the current OtherCity.
     */
    public String getOtherCity() {
        return otherCity;
    }

    /**
     * Sets the mailing other City.
     * @param otherCity user mailing other City.
     */
    public void setOtherCity(String otherCity) {
        this.otherCity = otherCity;
    }

    /**
     * Gets the get OtherState.
     * @return the current Other State.
     */
    public String getOtherState() {
        return otherState;
    }

    /**
     * Sets the mailing other State.
     * @param otherState user mailing other State.
     */
    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    /**
     * Gets the get Other Country.
     * @return the current OtherCountry.
     */
    public String getOtherCountry() {
        return otherCountry;
    }

    /**
     * Sets the mailing other Country.
     * @param otherCountry user mailing other Country.
     */
    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }

    /**
     * Gets the get Languages.
     * @return the current Languages.
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Sets the mailing languages.
     * @param languages user mailing languages.
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     * Gets the get level.
     * @return the current level.
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the mailing level.
     * @param level user mailing level.
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Gets the get description.
     * @return the current description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the mailing description.
     * @param description user mailing description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the get full name of contact.
     * @return the current fullName.
     */
    public String getFullName(){
        return firstName.concat(" ").concat(getLastName());
    }

    /**
     * Gets the get full other address.
     * @return the current FullOtherAddress.
     */
    public String getFullOtherAddress(){
        return null;
    }

    public String getNameWithTimeStamp(){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        lastName.concat(" ").concat(timeStamp);
        return null;
    }
}

package com.jalasoft.sfdc.entities;

/**
 * User class contains the user information.
 *
 * @author Silvia Valencia
 * @since 7/3/2018
 */
public class User {
    private String userName = "";
    private String password = "";
    private String firstName = "";
    private String lastName = "";
    private String alias = "";

    private String grantType = "";
    private String clientId="";
    private String clientSecret="";
    private String userToken="";

    /**
     * Sets the user name.
     *
     * @param userName user name to set.
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user name.
     *
     * @return the current user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user password.
     *
     * @param password user password to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the user password.
     *
     * @return the current user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user first name.
     *
     * @param firstName user first name to set.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user first name.
     *
     * @return the current user first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user last name.
     *
     * @param lastName user last name to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user last name.
     *
     * @return the current user last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the user full name.
     *
     * @return The current full name.
     */
    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }

    /**
     * Gets the alias full name.
     *
     * @return The current full name.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the alias last name.
     *
     * @param alias user last name to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }


    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

}

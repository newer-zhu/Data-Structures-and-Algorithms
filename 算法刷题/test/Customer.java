package test;

import java.util.Date;

public class Customer {
    private String accountNumber;
    private String name;
    private String company;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private Date birthDate;
    private String favorites;
    private double standardPayment;
    private Date latestPayment;
    private double balance;

    public Customer(String accountNumber, String name, String company, String street,
                    String city, String state, String zip, String email,
                    Date birthDate, String favorites, double standardPayment,
                    Date latestPayment, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.company = company;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.birthDate = birthDate;
        this.favorites = favorites;
        this.standardPayment = standardPayment;
        this.latestPayment = latestPayment;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public double getStandardPayment() {
        return standardPayment;
    }

    public void setStandardPayment(double standardPayment) {
        this.standardPayment = standardPayment;
    }

    public Date getLatestPayment() {
        return latestPayment;
    }

    public void setLatestPayment(Date latestPayment) {
        this.latestPayment = latestPayment;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

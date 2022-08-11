package edu.yu.cs.com1320.project;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account creates a user, adds his bank account(s), adds categories of things he wants to budget,
 * creates a password for the user and can also reset his password
 * @author Sam Shulman
 */

public class Account {
    /**
     * The users email address
     */
    private String email;
    /**
     * The users password
     */
    private String password;
    /**
     * The users first name
     */
    private String firstName;
    /**
     * The users last name
     */
    private String lastName;
    /**
     * Map of the name of the users bank account to the object Bank
     */
    private Map<String, Bank> bankAccounts;
    private Map<String, Investment> investmentAccounts;
    /**
     * A set of the users categories
     */
    private Set<Category> categories;

    private PriorityQueue<Category> pq = new PriorityQueue<>();

    /**
     * @param email users email address
     * @param password users password
     * @param firstName users first name
     * @param lastName users last name
     */
    public Account (String email, String password, String firstName, String lastName) {
        if (email.isBlank()) {
            throw new IllegalArgumentException("Enter an email");
        }
        this.password = setPassword(password);
        this.email = email.toLowerCase();
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.bankAccounts = new HashMap<>();
        this.investmentAccounts = new HashMap<>();
        this.categories = new HashSet<>();
    }

    /**
     * @throws IllegalArgumentException if bankName is empty or bank is null
     * @param bankName name of the users bank account
     * @param bank the users bank
     */
    public void putBankAccount (String bankName, Bank bank) {
        if (bankName.isBlank() || bank == null){
            throw new IllegalArgumentException();
        }
        bankAccounts.put(bankName,bank);

    }

    /**
     * @throws IllegalArgumentException if bankName is empty or null
     * @param bankName name of the users bank account
     * @return the users Bank
     */
    public Bank getBank(String bankName){
        if (bankName == null || bankName.isBlank()){
            throw new IllegalArgumentException();
        }
        return bankAccounts.get(bankName);
    }

    /**
     * @throws IllegalArgumentException If category is null
     * @param category The category being added
     * @return True if the category was added False if not
     */
    public boolean addCategory(Category category){
        if (category == null){
            throw new IllegalArgumentException("Pass in a category");
        }
        return categories.add(category) && pq.add(category);
    }

    /**
     * @throws IllegalArgumentException If the name of the category is blank
     * @param cat The name of the category being retrieved
     * @return The Category or null if it does not exist
     */
    public Category getCategory(String cat){
        if (cat.isBlank()){
            throw new IllegalArgumentException("Enter a category name");
        }
        for (Category category : categories){
            if (category.getName().equals(cat)){
                return category;
            }
        }
        return null;
    }

    /**
     * @throws IllegalArgumentException If the name of the category is blank
     * @param cat The name of the category being retrieved
     * @return True if the Category was successfully removed from the set and que or not
     */
    public boolean removeCategory(String cat){
        if (cat.isBlank()){
            throw new IllegalArgumentException("Enter a category name");
        }
        for (Category category : categories){
            if (category.getName().equals(cat)){
                return categories.remove(category) && pq.remove(category);
            }
        }
        return false;
    }

    /**
     * @throws IllegalArgumentException if the newPassword is empty or null
     * @throws IllegalArgumentException if the newPassword is the same as the users previous password
     * @param newPassword The name of the users new password
     * @return True if the password was successfully reset false if not
     */
    public Boolean resetPassword(String newPassword){
        String oldPassword = this.password;
        if (newPassword.equals(oldPassword)){
            throw new IllegalArgumentException("Tried to reset password to previous password");
        }
        try {
            this.password = setPassword(newPassword);
        } catch (IllegalStateException e){
            return false;
        }
        return true;
    }

    /**
     * @return the users email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the users first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the users last name
     */
    public String getLastName() {
        return lastName;
    }

    private String setPassword(String password){
        if (password == null || password.isBlank()){
            throw new IllegalArgumentException(password);
        }
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);
        boolean isStringContainsSpecialCharacter = matcher.find();

        if (password.length() != 8){
            throw new IllegalStateException("Password isn't at least 8 characters");
        }
        if (password.chars().noneMatch(Character::isUpperCase)){
            throw new IllegalStateException("Password doesn't at least one upper case character");
        }
        if (!isStringContainsSpecialCharacter){
            throw new IllegalStateException("Password doesn't contain a special character");
        }
        return this.password = password;
    }
}

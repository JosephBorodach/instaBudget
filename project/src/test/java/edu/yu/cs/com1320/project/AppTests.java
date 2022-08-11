package edu.yu.cs.com1320.project;

import edu.yu.cs.com1320.project.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTests {
    private String name;
    private String name1;
    private String name2;
    private String lastName;
    private String lastName1;
    private String lastName2;
    private String email;
    private String email1;
    private String email2;
    private String password;
    private String password1;
    private String password2;
    private String bank;
    private String bank1;
    private String bank2;
    private String bankAccount;
    private String bankAccount1;
    private String bankAccount2;
    private String category;
    private String category1;
    private String category2;

    @BeforeEach
    public void initiate() {
        this.name = "Berny";
        this.name1 = "Sam";
        this.name2 = "Yosef";
        this.lastName = "Benstein";
        this.lastName1 = "Schulman";
        this.lastName2 = "Borodach";
        this.email = "berny@gmail.com";
        this.email1 = "sam@gmail.com";
        this.email2 = "yosef@gmail.com";
        this.password = "water";
        this.password1 = "notwell";
        this.password2 = "verywellHaha101";
        this.bank = "Bank of America";
        this.bank1 = "Chase";
        this.bank2 = "TD";
        this.bankAccount = "bernyDaBank";
        this.bankAccount1 = "scarySam";
        this.bankAccount2 = "borodachBorough";
        this.category = "rent";
        this.category1 = "nights out";
        this.category2 = "boxing tickets";
    }
    
    @Test
    public void putTests () {
        App app = new App();
        assertThrows(IllegalStateException.class, () -> {
            app.putAccount(this.email, this.password, this.name, this.lastName);
        });
        assertThrows(IllegalStateException.class, () -> {
            app.putAccount(this.email, this.password1, this.name, this.lastName);
        });
        //app.putAccount(this.email, this.password2, this.name, this.lastName);
        //app.putBankAccount(this.email, this.bank, this.bankAccount, 100000);
        //app.putBankAccount(this.email, this.bank1, this.bankAccount2, 100000);
    }

    public void addCategory () {
        App app = new App();
        app.putAccount(this.email, this.password, this.name, this.lastName);
        app.putBankAccount(this.email, this.bank, this.bankAccount, 100000);
        assertTrue(app.addCategory(this.bank1, 30.0, this.password, this.category, 10));
        //The bank account doesn't have that much too alocate
        assertTrue(app.addCategory(this.bank1, 100000000, this.password, this.category, 10));

    }

    @Test
    public void putExceptions () {
        App app = new App();
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(null, this.password, this.name, this.lastName);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(this.email, null, this.name, this.lastName);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(this.email, this.password, null, this.lastName);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(this.email, this.password, this.name, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount("", this.password, this.name, this.lastName);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(this.email, "", this.name, this.lastName);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(this.email, this.password, "", this.lastName);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            app.putAccount(this.email, this.password, this.name, "");
        });
    }

    @Test
    public void addCategoryExceptions () {
        App app = new App();
        //Because this email does not exist in the system
        assertThrows(IllegalStateException.class, () -> {
            app.putAccount(this.email, this.password, this.name, this.lastName);
        });
        assertThrows(IllegalStateException.class, () -> {
            app.putAccount(this.email, this.password2, this.name, this.lastName);
        });
    }
}

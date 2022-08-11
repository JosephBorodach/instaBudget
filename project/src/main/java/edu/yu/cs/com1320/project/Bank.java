package edu.yu.cs.com1320.project;
/**
 * Creates a bank object
 * @author Sam Shulman
 */
public class Bank {
    String bankName;
    double totalFunds;

    public Bank(String bankName, double totalFunds){
        if (bankName.isBlank()){
            throw new IllegalArgumentException("Please enter a bank name");
        }
        this.bankName = bankName;
        this.totalFunds = totalFunds;
    }

    public void depositFunds(double cash){
        if (cash == 0){
            throw new IllegalArgumentException("Please enter an amount to withdraw");
        }

        totalFunds += cash;
    }

    public double withdrawFunds(Double cash){
        if (cash == 0){
            throw new IllegalArgumentException("Please enter an amount to withdraw");
        }
        if (cash > totalFunds || (this.totalFunds - cash) < 0){
            throw new IllegalStateException("You tried withdrawing more cash than you have");
        }

        totalFunds -= cash;
        return cash;
    }

    public double getTotalFunds(){
        return totalFunds;
    }

    public String getBankName(){
        return bankName;
    }


}

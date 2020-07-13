package COMP1008;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Bank {

    //variables
    private String bankName;
    private String location;
    private List<Account> accountList;

    //constructor
    public Bank(String bankName, String location) {
        this.bankName = bankName;
        this.location = location;
        accountList = new ArrayList<Account>();

    }

    //get account number
    public Account getAccount(String accountNumber) {
        Account accountObject = null;
        for (Account account : accountList) {
            if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
                accountObject = account;
            }
        }
        return accountObject;
    }

    //add account
    public void addAccounts() {
        Account account = new Account();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter account name");
        String accountName = in.nextLine();
        if (account.validateAccountName(accountName)) {

            System.out.println("Please enter account number");
            String accountNumber = in.nextLine();
            if (account.validateAccountNumber(accountNumber)) {
                System.out.println("Please enter balance");
                float balance = Float.parseFloat(in.nextLine());
                if (account.validateBalance(balance)) {
                    account.setAccountNumber(accountNumber);
                    account.setAccountName(accountName);
                    account.setBalance(balance);
                    accountList.add(account);
                    System.out.println("Account added\n");
                } else {
                    System.out.println("Balance cannot be less than 0\n choose again\n");
                }
            } else {
                System.out.println("Account number can only be alphanumeric\n choose again\n");
            }
        } else {
            System.out.println("Account name can only contain alphabets, space and hyphen\n choose again\n");
        }
    }

    //view accounts
    public void viewAllAccounts() {
        if (accountList.size() == 0) {
            System.out.println("No accounts are added yet\n");
        } else {
            for (Account account : accountList) {
                System.out.println("------------------------------------");
                System.out.println(account.toString());
            }
            System.out.println("------------------------------------\n");
        }
    }

    //details
    public void viewAccountDetails(String accountNumber) {
        int flag = 0;
        for (Account account : accountList) {
            if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
                System.out.println("------------------------------------");
                System.out.println(account.toString());
                flag = 1;
            }
        }

        if (flag == 0) {
            System.out.println("Account doesn't exist\n");
        } else {
            System.out.println("------------------------------------");
        }
    }

    //modify
    public void modifyAccountDetails(String accountNumber) {
        int flag = 0;
        Scanner in = new Scanner(System.in);
        for (Account account : accountList) {
            if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
                flag = 1;
                System.out.println("What do you want to modify?");
                System.out.println("Name");
                System.out.println("Number");
                System.out.println("Balance");
                String option = in.nextLine();
                if (option.equalsIgnoreCase("number")) {
                    System.out.println("Enter a new account number");
                    String number = in.nextLine();
                    while (!account.validateAccountNumber(number)) {
                        System.out.println("Account number can only be alphanumeric\n Enter again\n");
                        number = in.nextLine();
                    }
                    account.setAccountNumber(number);
                    System.out.println("Account number modified");
                } else if (option.equalsIgnoreCase("name")) {
                    System.out.println("Enter a new account name");
                    String name = in.nextLine();
                    while (!account.validateAccountName(name)) {
                        System.out.println("Account name can only contain alphabets, space and hyphen\n Enter again\n");
                        name = in.nextLine();
                    }
                    account.setAccountName(name);
                    System.out.println("Account name modified");
                } else if (option.equalsIgnoreCase("balance")) {
                    System.out.println("Enter the new account balance");
                    float balance = Float.parseFloat(in.nextLine());
                    while (!account.validateBalance(balance)) {
                        System.out.println("Balance cannot be less than 0\n Enter again\n");
                        balance = Float.parseFloat(in.nextLine());
                    }
                    account.setBalance(balance);
                    System.out.println("Account balance modified");
                } else {
                    System.out.println("Wrong input");
                }
                flag = 1;
            }
        }

        if (flag == 0) {
            System.out.println("Account doesn't exist\n");
        } else {
            System.out.println("------------------------------------");
        }
    }

    public void modifyAccountDetails(String accountNumber, String option) {
        int flag = 0;
        Scanner in = new Scanner(System.in);
        for (Account account : accountList) {
            if (accountNumber.equalsIgnoreCase(account.getAccountNumber())) {
                flag = 1;
                if (option.equalsIgnoreCase("number")) {
                    System.out.println("Enter a new account number");
                    String number = in.nextLine();
                    while (!account.validateAccountNumber(number)) {
                        System.out.println("Account number can only be alphanumeric\n Enter again\n");
                        number = in.nextLine();
                    }
                    account.setAccountNumber(number);
                    System.out.println("Account number modified");
                } else if (option.equalsIgnoreCase("name")) {
                    System.out.println("Enter a new account name");
                    String name = in.nextLine();
                    while (!account.validateAccountName(name)) {
                        System.out.println("Account name can only contain alphabets, space and hyphen\n Enter again\n");
                        name = in.nextLine();
                    }
                    account.setAccountName(name);
                    System.out.println("Account name modified");
                } else if (option.equalsIgnoreCase("balance")) {
                    System.out.println("Enter the new account balance");
                    float balance = Float.parseFloat(in.nextLine());
                    while (!account.validateBalance(balance)) {
                        System.out.println("Balance cannot be less than 0\n Enter again\n");
                        balance = Float.parseFloat(in.nextLine());
                    }
                    account.setBalance(balance);
                    System.out.println("Account balance modified");
                } else {
                    System.out.println("Wrong input");
                }
            }
        }
        if (flag == 0) {
            System.out.println("Account doesn't exist\n");
        } else {
            System.out.println("------------------------------------");
        }
    }

    //delete
    public void deleteAccount(String accountNumber) {
        Scanner in = new Scanner(System.in);
        int flag = 0;
        for (Iterator<Account> itr = accountList.iterator(); itr.hasNext();) {
            if (accountNumber.equalsIgnoreCase(itr.next().getAccountNumber())) {
                flag = 1;
                System.out.println("Do you really want to delete account? Type Y/N");
                String answer = in.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    itr.remove();
                    System.out.println("Account deleted");
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("You chose not to delete the account");
                } else {
                    System.out.println("Wrong input");
                    break;
                }
            }
        }

        if (flag == 0) {
            System.out.println("Account doesn't exist\n");
        } else {
            System.out.println("------------------------------------");
        }
    }

    //summary
    public void summary() {
        float sum = 0;
        float avg;
        int count = 0;
        if (accountList.size() == 0) {
            System.out.println("No accounts are added yet");
        } else {
            for (Account account : accountList) {
                sum = sum + account.getBalance();
                count++;
            }
            avg = sum / count;
            System.out.println("-----------------------------------------------------------------");
            System.out.format("Total Accounts Created:\t\t\t%4d\nSum of all account balances:\t\t%.2f\nAverage Balance for all accounts:\t%.2f\n", count, sum, avg);
            System.out.println();
            System.out.println("-----------------------------------------------------------------\n");
        }
    }

    //help
    public void help() {
        System.out.println("User commands available\n");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. Add Account\n");
        System.out.println("Summary:Adds a new account in the bank");
        System.out.println(" \tEnter the serial number 1 to use the command\n");
        System.out.println(" \t\tArguments:\tAccount Name(alphabets with space and hyphen(-))\n\t\t\t\t Account Number(alphanumeric)\n\t\t\t\t Balance(non-negtive)\n\n");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("2. View Accounts\n");
        System.out.println("Summary:Shows the information of all the accounts in the bank");
        System.out.println(" \tEnter the serial number 2 to use the command\n");
        System.out.println(" \t\tArguments:\tNo Arguments Required\n\n");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("3. Account Details\n");
        System.out.println("Summary:Shows the information of a bank account");
        System.out.println(" \tEnter the serial number 3 to use the command\n");
        System.out.println(" \tCommand: view ACCOUNT_NUMBER details\n");
        System.out.println(" \t\tArguments:\tAccount Number\n");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("4. Modify Account\n");
        System.out.println("Summary:Allows to modify the details of a bank account");
        System.out.println(" \tEnter the serial number 4 to use the command\n");
        System.out.println(" \tCommand: modify ACCOUNT_NUMBER\n \t\t\tOR\n\t\t    modify ACCOUNT_NUMBER OPTION\n");
        System.out.println(" \t\tArguments:\tAccount Number\n");
        System.out.println(" \t\tOPTION:\t\tAccount Name\n\t\t\t\tAccount Number\n\t\t\t\tBalance\n\n");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("5. Delete Account\n");
        System.out.println("Summary:Allows to delete an account from the bank");
        System.out.println(" \tEnter the serial number 5 to use the command\n");
        System.out.println(" \tCommand: delete ACCOUNT_NUMBER\n");
        System.out.println(" \t\tArguments:\tAccount Number\n");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("6. Help\n");
        System.out.println("Summary:Shows the information of all the commands in the program");
        System.out.println(" \tEnter the serial number 6 to use the command\n");
        System.out.println(" \t\tArguments:\tNo Arguments Required\n\n");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("7. Summary\n");
        System.out.println("Summary:Shows the count of total accounts in the bank\n\tAlso shows the total balance in all the accounts\n\tand averga balance in an account");
        System.out.println(" \tEnter the serial number 7 to use the command\n");
        System.out.println(" \t\tArguments:\tNo Arguments Required\n\n");

    }

    public List<Account> getAccountList() {
        return accountList;
    }

}
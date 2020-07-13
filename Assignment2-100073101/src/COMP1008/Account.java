package COMP1008;

public class Account {

    //Variables
    private String accountNumber;
    private float balance;
    private String accountName;

    //Constructor
    public Account(String accountNumber, float balance, String accountName)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountName = accountName;

    }

    //default Constructor
    public Account(){}


    //getters and setters
    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }


    public float getBalance()
    {
        return this.balance;
    }

    public void setBalance(float balance)
    {
        this.balance = balance;
    }


    public String getAccountName()
    {
        return this.accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    //make sure Account Number is Alphanumeric
    public boolean validateAccountNumber(String accountNumber)
    {
        String validator = "[A-Za-z0-9]+";
        if(accountNumber.matches(validator))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //make sure Account Name is Alphanumeric and can have space and hyphens
    public boolean validateAccountName(String accountName)
    {
        String validator = "^[0-9A-Za-z,\\-,\\ ]+";
        if(accountName.matches(validator))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //make sure balance is not a negative number
    public boolean validateBalance(float balance)
    {
        if(balance > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    //account details return
    @Override
    public String toString()
    {

        return "Account Name:\t\t\t"+this.accountName+"\nAccount Number:\t\t\t"+this.accountNumber+"\nBalance:\t\t\t"+ this.balance;

    }
}

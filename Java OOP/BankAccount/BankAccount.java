import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private long accountNumber;
    private static int numAccounts;
    private static double amountMoney;

    public BankAccount(){
        this.checkingBalance = 0;
        this.savingBalance = 0;
        this.accountNumber = generateAccountNum();
        numAccounts ++;
    }

    public BankAccount(double checkingBalance, double savingBalance){
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        this.accountNumber = generateAccountNum();
        numAccounts ++;
        amountMoney += savingBalance;
        amountMoney += checkingBalance;
    }

    public double getUserChecking(){
        return this.checkingBalance;
    }

    public double getUserSaving(){
        return this.savingBalance;
    }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Cannot deposit negative amount.");
        }
        else{
            this.checkingBalance += amount;
            amountMoney += amount;
        }
    }

    public void withdraw(double amount){
        if(amount > this.checkingBalance){
            System.out.println("Insufficient Balance.");
        }
        else{
            this.checkingBalance -= amount;
            amountMoney -= amount;
        }
    }

    public static double showAmount(){
        return amountMoney;
    }

    public static int showNumAccounts(){
        return numAccounts;
    }

    private long generateAccountNum(){
        long BankAccountNum = new Random().nextInt(300000000)+ 4200000000L;
        return BankAccountNum;
    }

    public long getAccountNum(){
        return this.accountNumber;
    }
}

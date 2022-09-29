
public class BankAccountTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount(2000, 2000);
        BankAccount account4 = new BankAccount(3333, 999999);

        System.out.println(BankAccount.showNumAccounts());
        System.out.println(BankAccount.showAmount());

        System.out.println("Your current balance in Checking: $" + account1.getUserChecking());
        account1.deposit(2000000);
        System.out.println("Your current balance in Checking: $" + account1.getUserChecking());
        System.out.println("The total amount saved in the bank: $" + BankAccount.showAmount());
        account2.withdraw(2000);
        System.out.println("Your Account Number:" + account1.getAccountNum());
        System.out.println("Your Account Number:" + account2.getAccountNum());
        System.out.println("Your Account Number:" + account3.getAccountNum());
        System.out.println("Your Account Number:" + account4.getAccountNum());
    }
}

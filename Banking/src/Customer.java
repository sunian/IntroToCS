/**
 * Created by Sun on 10/3/2015.
 */
public class Customer implements Robbable {
    public String name;
    public Integer age;
    public String phoneNumber;
    public Character gender;
    public Double favoriteNumber;
    public BankAccount myCheckingAccount;
    public SavingsAccount mySavingsAccount;
    public Boolean evil;


    //the constructor
    public Customer(Integer startingBalance, String name) {
        myCheckingAccount = new CheckingAccount(startingBalance);
        mySavingsAccount = new SavingsAccount(startingBalance);
        this.name = name;
    }


    public void depositMoney(Integer amountOfMoney) {
        //do the things for depositing money
//        myBankAccount.deposit(amountOfMoney);
    }

    // returns the amount of money your actually got
    public Integer tryToWithdrawMoney(Integer amountOfMoney) {
        myCheckingAccount.getInterestRate();
        return myCheckingAccount.tryWithdraw(amountOfMoney);
    }

    @Override
    public void rob() {
        myCheckingAccount.tryWithdraw(myCheckingAccount.balance);
    }

    @Override
    public String toString() {
        return name + " " + phoneNumber;
    }
}

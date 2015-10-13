import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun on 10/3/2015.
 */
public abstract class BankAccount {
    public Integer balance;
    public List<Integer> transactions;
    public Double interestRate;

    public BankAccount(Integer startingBalance){
        super();
        balance = startingBalance;
        transactions = new ArrayList<Integer>();
    }

    public abstract Double getInterestRate();

    public void deposit(Integer amount) {
        balance = balance + amount;
        transactions.add(amount);
    }

    /**
     * @param amountOfMoney is how much money you want to withdraw
     * @return integer amount of money actually withdrawn
     * */
    public Integer tryWithdraw(Integer amountOfMoney) {
        System.out.println("BankAccount withdraw");
        Boolean b = balance < amountOfMoney;
        Integer amountActuallyWithdrawn;
        if (b) {
            //cannot withdraw full amount because they don't have enough
            Integer oldBalance = balance;
            balance = 0;
            amountActuallyWithdrawn = oldBalance;
        } else {
            balance = balance - amountOfMoney;
            amountActuallyWithdrawn = amountOfMoney;
        }
        transactions.add(-amountActuallyWithdrawn);
        return amountActuallyWithdrawn;
    }
}

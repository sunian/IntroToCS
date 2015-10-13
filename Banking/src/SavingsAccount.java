/**
 * Created by Sun on 10/3/2015.
 */
public class SavingsAccount extends BankAccount {

    public SavingsAccount(Integer startingBalance) {
        super(startingBalance);
        interestRate = 0.04;
    }

    @Override
    public Double getInterestRate() {
        return 0.04;
    }


    @Override
    public Integer tryWithdraw(Integer amountOfMoney) {
        System.out.println("SavingsAccount withdraw");
        return 0;
    }
}

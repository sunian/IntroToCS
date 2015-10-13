/**
 * Created by Sun on 10/3/2015.
 */
public class CheckingAccount extends BankAccount {
    public CheckingAccount(Integer startingBalance) {
        super(startingBalance);
        interestRate = 0.02;
    }

    @Override
    public Double getInterestRate() {
        return 0.01;
    }

    @Override
    public Integer tryWithdraw(Integer amountOfMoney) {
        System.out.println("CheckingAccount withdraw");
//        return 0;
        return super.tryWithdraw(amountOfMoney);
    }

    public void NewMethod(){

    }

}

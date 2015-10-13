/**
 * Created by Sun on 10/3/2015.
 */
public class Main {
    static Main mainVariable;

    public static void main(String[] args) {
        Customer customerBob = new Customer(5, "Bob Dillan");
        Customer customerMelody = new Customer(5, "Melody");
        customerBob.phoneNumber = "4343218887";
        customerBob.gender = 'M';
        customerBob.favoriteNumber = 3.141592;
//        customerBob.tryToWithdrawMoney(1);
//        customerBob.myCheckingAccount = new SavingsAccount(3);
//        customerBob.tryToWithdrawMoney(1);
        System.out.println(customerBob.myCheckingAccount.balance);
        customerBob.rob();
        System.out.println(customerBob.myCheckingAccount.balance);
//        Robbable aPersonThatCanBeRobbed = new Robbable();
//        aPersonThatCanBeRobbed.rob();
    }
}

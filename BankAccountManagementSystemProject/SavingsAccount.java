public class SavingsAccount extends Account{

    private static final double  Minimum_BALANACE=100.00;
    private  double interestRatio;

    public SavingsAccount(String accountNumber, String holderName,double amount,double interestRatio)
    {
        super(accountNumber,holderName,amount);
        this.interestRatio=interestRatio;

    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        if(amount<=0){
            throw new IllegalArgumentException("Withdrawal must be greater than zero.");
        } else if (balance-amount< Minimum_BALANACE) {
            throw new InsufficientFundException("Cannot Withdrawal,Saving Account must Maintain Minimum balance");
        }else
        balance-=amount;
        System.out.println("Amount Succesfully Writhdrawal");

    }
    public void applyInterest(){
        double interest =balance*interestRatio;
        balance +=interest;
        System.out.println("Interest credited Succesfully $ :" +interest);
    }

}

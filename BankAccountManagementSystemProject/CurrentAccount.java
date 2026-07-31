public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName,double amount,double overdraftLimit)
    {
        super(accountNumber,holderName,amount);
        this.overdraftLimit=overdraftLimit;
    }


    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        if(amount<=0){
            throw new IllegalArgumentException("Withdrawal must be greater than zero.");
        } else if (balance-amount<=-overdraftLimit) {
            throw new InsufficientFundException("Cannot Withdrawal due to Overdraft Limit");
        }else
            balance-=amount;
        System.out.println("Amount Succesfully Writhdrawal");
    }

}

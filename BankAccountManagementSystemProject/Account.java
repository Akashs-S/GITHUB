abstract class Account {

    private String accountNumber;
    private String holderName;
    protected double balance;

    public Account(String accountNumber,String holderName,double balance)
    {
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=balance;
    }

    public Account() {
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }
    public String getHolderName()
    {
        return holderName;
    }
    public double getBalance()
    {
        return balance;
    }

    public void deposit (double amount){

    if (amount>0)
    {
        balance +=amount;
        System.out.print("Amount Sucessfully Deposited $:"+amount);
    }else{
        System.out.println("Invalid Amount");
    }
}

    public abstract void withdraw(double amount)throws InsufficientFundException;



}

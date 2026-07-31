public class BankApp{
    public static void main(String[] args) {
        
        BankService bank =new BankService();

        Customer alice =new Customer("C101","Alice Smith" ,"alice12@gmail.com");
        Customer John =new Customer("C102","John Adam" ,"johnadam34@gmail.com");
        
        SavingsAccount aliceAcc =new SavingsAccount("SAV101","alice",500.00, 0.05);
        CurrentAccount johnAcc =new CurrentAccount("CUR102","john",200.00, 300);
        

        bank.createAccount(aliceAcc);
        bank.createAccount(johnAcc);

        System.out.println("\n ---Testing Transactions---");
        bank.deposit("SAV101", 200.00);
        bank.withdraw("CUR102", 400);


        System.out.println("\n ---Testing Minimum Balance Constrain---");
        bank.withdraw("SAV101", 650.00);
        

        System.out.println("\n ---Testing Fund transfer---");
        bank.transfer("SAV101","CUR102",300.00);

        aliceAcc.applyInterest();

        System.out.println("\n---Final Account Status---");
        bank.printAccountDetails("SAV101");
        bank.printAccountDetails("CUR102");

        bank.printTransactionHistory();


    }
}
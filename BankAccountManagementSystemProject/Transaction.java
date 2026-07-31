import java.time.LocalDateTime;

public class Transaction  {
    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String transactionId,String accountNumber,String type,double amount)
    {
        this.transactionId=transactionId;
        this.accountNumber=accountNumber;
        this.type=type;
        this.amount=amount;
        this.timestamp =LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s]ID:%s|Acc:%s|%s|$%.2f",timestamp.toLocalDate().toString().substring(0,8),transactionId,accountNumber,type,amount);

    }
}

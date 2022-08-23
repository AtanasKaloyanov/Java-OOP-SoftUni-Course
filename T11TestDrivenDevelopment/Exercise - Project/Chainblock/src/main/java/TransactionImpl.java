public class TransactionImpl implements Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public TransactionStatus getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(TransactionStatus transactionStatus) {
        this.status = transactionStatus;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return this.id + " " + this.status.toString() + " " + this.from + " " + this.to + " " + this.amount;
    }
}

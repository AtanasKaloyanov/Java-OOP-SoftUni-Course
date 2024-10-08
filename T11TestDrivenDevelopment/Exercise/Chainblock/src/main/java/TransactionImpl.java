public class TransactionImpl implements Comparable<TransactionImpl>, Transaction {
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
    public int getId() {
        return this.id;
    }

    @Override
    public TransactionStatus getStatus() {
        return this.status;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo() {
        return this.to;
    }

    @Override
    public void setStatus(TransactionStatus newStatus) {
        this.status = newStatus;
    }

    @Override
    public int compareTo(TransactionImpl o) {
        return Double.compare(o.amount, this.amount);
    }

    @Override
    public String toString() {
        return this.id + " " + this.status + " " + this.from + " " + this.to + " " + this.amount;
    }


}

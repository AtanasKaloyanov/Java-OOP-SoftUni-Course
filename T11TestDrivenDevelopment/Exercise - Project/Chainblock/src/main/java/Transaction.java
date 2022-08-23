public interface Transaction {
    int getID();
    TransactionStatus getStatus();
    void setStatus(TransactionStatus transactionStatus);
    String getFrom();
    String getTo();
    double getAmount();
    String toString ();
}

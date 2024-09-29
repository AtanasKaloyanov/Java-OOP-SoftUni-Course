public interface Transaction {
    int getId();
    void changeStatus(TransactionStatus newStatus);
    TransactionStatus getStatus();
    double getAmount();
}

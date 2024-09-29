import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionByIdMap = new HashMap<>();
    private Map<TransactionStatus, Transaction> transactionByStatusMap = new HashMap<>();

    public int getCount() {
        return this.transactionByIdMap.size();
    }

    public void add(Transaction transaction) {
        int id = transaction.getId();
        if (this.contains(id)) {
            throw new IllegalArgumentException(
                    "The transaction is already saved");
        }

        this.transactionByIdMap.put(id, transaction);
    }

    public boolean contains(Transaction transaction) {
        int id = transaction.getId();
        return this.contains(id);
    }

    public boolean contains(int id) {
        return this.transactionByIdMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        transactionCheck(id);
        // 1. Change the element in the idMap:
        Transaction transaction = this.transactionByIdMap.get(id);
        TransactionStatus transactionOldStatus = transaction.getStatus();
        transaction.changeStatus(newStatus);
        // 2. Change the element in the statusMap:
        this.transactionByStatusMap.put(transactionOldStatus, transaction);
    }

    public void removeTransactionById(int id) {
        this.transactionCheck(id);
        Transaction removedTr = this.transactionByIdMap.remove(id);
    }

    public Transaction getById(int id) {
        transactionCheck(id);
        return this.transactionByIdMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        Predicate<Transaction> statusPredicate = hasStatus(status);
        Comparator<Transaction> amountComp = compareByAmountReversed();
        return this.transactionByIdMap.values()
                .stream()
                .filter(statusPredicate)
                .sorted(amountComp)
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private static Comparator<Transaction> compareByAmountReversed() {
        return Comparator.comparingDouble(Transaction::getAmount).reversed();
    }

    private static Predicate<Transaction> hasStatus(TransactionStatus status) {
        return transaction -> transaction.getStatus() == status;
    }

    private void transactionCheck(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException(
                    "The chainblock doesn't contains the transaction.");
        }
    }
}

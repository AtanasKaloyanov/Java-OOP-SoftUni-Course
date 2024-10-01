import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionByIdMap = new HashMap<>();
    private Map<TransactionStatus, Set<Transaction>> transactionSetByStatusMap = new HashMap<>();

    @Override
    public int getCount() {
        return this.transactionByIdMap.size();
    }

    @Override
    public void add(Transaction transaction) {
        // 1. Contains check:
        int id = transaction.getId();
        transactionExistCheck(id);

        // 2. Adding the transaction to both maps:
        // 2.1. idMap adding:
        this.transactionByIdMap.put(id, transaction);
        // 2.2. statusMap adding:
        TransactionStatus status = transaction.getStatus();
        Comparator<Transaction> amountComparator = compareByAmountReversed();
        this.transactionSetByStatusMap.putIfAbsent(status, new TreeSet<>(amountComparator));
        this.transactionSetByStatusMap.get(status).add(transaction);
    }

    @Override
    public boolean contains(Transaction transaction) {
        int id = transaction.getId();
        return this.contains(id);
    }

    @Override
    public boolean contains(int id) {
        return this.transactionByIdMap.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        transactionDoesntExistCheck(id);
        // 1. Change the element in the idMap:
        Transaction transaction = this.transactionByIdMap.get(id);
        TransactionStatus transactionOldStatus = transaction.getStatus();
        transaction.setStatus(newStatus);
        // 2. Change the element in the statusMap:
        Set<Transaction> transactionSet =  this.transactionSetByStatusMap.get(transactionOldStatus);

        for (Transaction currentTransaction : transactionSet) {
            if (currentTransaction.getId() == id) {
                currentTransaction.setStatus(newStatus);
                break;
            }
        }
    }

    @Override
    public void removeTransactionById(int id) {
        // 1. Existence check:
        this.transactionDoesntExistCheck(id);
        // 2. Transaction removing from both map:
        Transaction removedTransaction = this.transactionByIdMap.remove(id);
        TransactionStatus removingStatus = removedTransaction.getStatus();
        this.transactionSetByStatusMap.get(removingStatus).remove(removedTransaction);
    }

    @Override
    public Transaction getById(int id) {
        transactionDoesntExistCheck(id);
        return this.transactionByIdMap.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        return getTransactions(status);
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Set<Transaction> transactions = getTransactions(status);
        return transactions.stream()
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        Set<Transaction> transactions = getTransactions(status);
        return transactions.stream()
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionByIdMap.values().stream()
                .sorted(getAmountReversedAndIdComp())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return this.transactionByIdMap.values();
               // .removeIf( (transaction) -> transaction.getFrom().equals(sender))


    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return null;
    }

    private static Comparator<Transaction> compareByAmountReversed() {
        return Comparator.comparingDouble(Transaction::getAmount).reversed();
    }

    private static Comparator<Transaction> getAmountReversedAndIdComp() {
        return Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId);
    }

    private void transactionExistCheck(int id) {
        if (this.contains(id)) {
            throw new IllegalArgumentException("The transaction is already saved");
        }
    }

    private void transactionDoesntExistCheck(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException("The chainblock doesn't contain the transaction.");
        }
    }

    private static void isEmptyCheck(Set<Transaction> transactions) {
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException("There are no transactions with this status");
        }
    }

    private Set<Transaction> getTransactions(TransactionStatus status) {
        Set<Transaction> transactions = this.transactionSetByStatusMap.get(status);
        isEmptyCheck(transactions);
        return transactions;
    }
}

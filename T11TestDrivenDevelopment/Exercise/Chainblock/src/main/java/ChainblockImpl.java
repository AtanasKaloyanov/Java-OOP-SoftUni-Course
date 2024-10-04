import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionByIdMap = new HashMap<>();

    @Override
    public int getCount() {
        return this.transactionByIdMap.size();
    }

    @Override
    public void add(Transaction transaction) {
        int id = transaction.getId();
        transactionExistCheck(id);
        this.transactionByIdMap.put(id, transaction);
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
        Transaction transaction = this.transactionByIdMap.get(id);
        transaction.setStatus(newStatus);
    }

    @Override
    public void removeTransactionById(int id) {
        this.transactionDoesntExistCheck(id);
        this.transactionByIdMap.remove(id);
    }

    @Override
    public Transaction getById(int id) {
        transactionDoesntExistCheck(id);
        return this.transactionByIdMap.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.transactionByIdMap.values()
                .stream()
                .filter(getByStatusPredicate(status))
                .sorted(getAmountReversedComp())
                .collect(Collectors.toList());

        isEmptyCheck(transactions);
        return transactions;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Function<Transaction, String> mapToSender = Transaction::getFrom;
        return getPeopleWithStatusTrans(status, mapToSender);
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        Function<Transaction, String> mapToReceiver = Transaction::getTo;
        return getPeopleWithStatusTrans(status, mapToReceiver);
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionByIdMap.values()
                .stream()
                .sorted(getAmountReversedAndIdComp())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        Predicate<Transaction> senderPredicate = getBySenderPredicate(sender);
        return getTransactionsBy(senderPredicate);
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        Predicate<Transaction> receiverPredicate = getByReceiverPredicate(receiver);
        return getTransactionsBy(receiverPredicate);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactionByIdMap.values()
                .stream()
                .filter(getByStatusAndMaxAmountPredicate(status, amount))
                .sorted(getAmountReversedComp())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = this.transactionByIdMap.values()
                .stream()
                .filter(getBtSenderAndAmountPredicate(sender, amount))
                .collect(Collectors.toList());

        isEmptyCheck(transactions);
        return transactions;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = this.transactionByIdMap.values()
                .stream()
                .filter(getByReceiverAndAmountPredicate(receiver, lo, hi))
                .sorted(getAmountReversedComp())
                .collect(Collectors.toList());

        isEmptyCheck(transactions);
        return transactions;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = this.transactionByIdMap.values()
                .stream()
                .filter(getAmountPredicate(lo, hi))
                .sorted(getAmountReversedAndIdComp())
                .collect(Collectors.toList());

        isEmptyCheck(transactions);
        return transactions;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return this.transactionByIdMap.values().iterator();
    }

    // Getter:
    public Map<Integer, Transaction> getTransactionByIdMap() {
        return this.transactionByIdMap;
    }

    // Predicates:
    private static Predicate<Transaction> getByStatusPredicate(TransactionStatus status) {
        return (trans) -> trans.getStatus() == status;
    }

    private static Predicate<Transaction> getBySenderPredicate(String sender) {
        return (transaction) -> transaction.getFrom().equals(sender);
    }

    private static Predicate<Transaction> getByReceiverPredicate(String receiver) {
        return (transaction) -> transaction.getTo().equals(receiver);
    }

    private static Predicate<Transaction> getByStatusAndMaxAmountPredicate(TransactionStatus status, double amount) {
        return (trans) -> trans.getStatus() == status && trans.getAmount() <= amount;
    }

    private static Predicate<Transaction> getAmountPredicate(double lo, double hi) {
        return (amount) -> amount.getAmount() >= lo && amount.getAmount() < hi;
    }

    private static Predicate<Transaction> getByReceiverAndAmountPredicate(String receiver, double lo, double hi) {
        return (transaction) -> transaction.getTo().equals(receiver) &&
                transaction.getAmount() >= lo && transaction.getAmount() < hi;
    }

    private static Predicate<Transaction> getBtSenderAndAmountPredicate(String sender, double amount) {
        return (trans) -> trans.getFrom().equals(sender) && trans.getAmount() > amount;
    }

    // Comparators:
    private static Comparator<Transaction> getAmountReversedComp() {
        return Comparator.comparingDouble(Transaction::getAmount).reversed();
    }

    private static Comparator<Transaction> getAmountReversedAndIdComp() {
        return Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId);
    }

    // Checked exceptions:
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

    private static void isEmptyCheck(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException("There are no such a transactions.");
        }
    }

    // Another repeatable logic:
    private List<String> getPeopleWithStatusTrans(TransactionStatus status, Function<Transaction, String> mapToString) {
        List<String> transactions = this.transactionByIdMap.values()
                .stream()
                .filter(getByStatusPredicate(status))
                .sorted(getAmountReversedComp())
                .map(mapToString)
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException("There are no such transactions.");
        }

        return transactions;
    }

    private List<Transaction> getTransactionsBy(Predicate<Transaction> personPredicate) {
        List<Transaction> result = this.transactionByIdMap.values().stream()
                .filter(personPredicate)
                .sorted(getAmountReversedComp())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException("There are no transaction related to this person.");
        }

        return result;
    }
}

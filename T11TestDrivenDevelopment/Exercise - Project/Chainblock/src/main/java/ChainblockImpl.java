
import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionsMap;

    public ChainblockImpl() {
        this.transactionsMap = new HashMap<>();
    }

    public int getCount() {
        return this.transactionsMap.size();
    }

    public void add(Transaction transaction) {
        int ID = transaction.getID();

        if (!this.transactionsMap.containsKey(ID)) {
            this.transactionsMap.put(ID, transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.transactionsMap.containsValue(transaction);
    }

    public boolean contains(int id) {
        return this.transactionsMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.transactionsMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        this.transactionsMap.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.transactionsMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        this.transactionsMap.remove(id);
    }

    public Transaction getById(int id) {
        if (!this.transactionsMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return this.transactionsMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = this.transactionsMap.values().stream()
                .filter(element -> element.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactionList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> returnedList = this.transactionsMap.values().stream()
                .filter(element -> element.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> returnedList = this.transactionsMap.values().stream()
                .filter(element -> element.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> returnedList = this.transactionsMap.values().stream()
                .sorted((element1, element2) -> {
                    int result = Double.compare(element2.getAmount(), element1.getAmount());

                    if (result == 0) {
                        result = Integer.compare(element1.getID(), element2.getID());
                    }

                    return result;
                }).collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> returnedList = this.transactionsMap.values().stream()
                .filter(element -> element.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> returnedList = transactionsMap.values().stream()
                .filter(element -> element.getTo().equals(receiver))
                .sorted((element1, element2) -> {
                    int result = Double.compare(element2.getAmount(), element1.getAmount());

                    if (result == 0) {
                        result = Integer.compare(element1.getID(), element2.getID());
                    }

                    return result;
                }).collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> returnedList = this.transactionsMap.values().stream()
                .filter(element -> element.getStatus().equals(status))
                .filter(element -> element.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;

        //getByTransactionStatusAndMaximumAmount(status, amount) –
        //returns all transactions with given status and amount less or equal to a maximum allowed amount ordered by amount descending.
        //Returns an empty collection if no such transactions were found.
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> returnedList = transactionsMap.values().stream()
                .filter(element -> element.getFrom().equals(sender))
                .filter(element -> element.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
        //getBySenderAndMinimumAmountDescending(sender, amount) –
        //returns all transactions with given sender and amount bigger than given amount ordered by amount descending.
        //If there are no such transactions throw IllegalArgumentException.
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> returnedList = this.transactionsMap.values().stream()
                .filter(element -> element.getTo().equals(receiver))
                .filter(element -> element.getAmount() >= lo && element.getAmount() < hi)
                .sorted((element1, element2) -> {
                    int result = Double.compare(element2.getAmount(), element1.getAmount());

                    if (result == 0) {
                        result = Integer.compare(element1.getID(), element2.getID());
                    }

                    return result;
                }).collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return returnedList;
        //	getByReceiverAndAmountRange(receiver, lo, hi) –
        // returns all transactions with given receiver and amount between lo (inclusive) and hi (exclusive) ordered by amount descending then by id.
        // If there are no such transactions throw IllegalArgumentException
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> returnedList = this.transactionsMap.values().stream()
                .filter(element -> element.getAmount() >= lo && element.getAmount() <= hi)
                .collect(Collectors.toList());

        if (returnedList.isEmpty()) {
            return new ArrayList<>();
        }

        return returnedList;
        //getAllInAmountRange(lo, hi) – returns all transactions within a range by insertion order (the range is inclusive).
        // Returns an empty collection if no such transactions were found.
    }

    public Iterator<Transaction> iterator() {
        return new ArrayList<>(this.transactionsMap.values()).iterator();
    }
}

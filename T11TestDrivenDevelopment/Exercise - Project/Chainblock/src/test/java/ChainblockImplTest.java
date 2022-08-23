import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {
    private Chainblock database;
    private List<Transaction> transactions;

    @Before()
    public void setUp() {
        this.database = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        fillingTheListWithTransactions();
    }

    @Test()
    public void testAddMethodForAddingTheCorrectTransaction() {

        Assert.assertEquals(0, this.database.getCount());

        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());

    }

    @Test()
    public void testAddMethodForAddingATransactionWithSameID() {
        Transaction transaction2 = new TransactionImpl(1, TransactionStatus.FAILED, "George", "John", 150.50);
        Assert.assertEquals(0, this.database.getCount());

        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());

        this.database.add(transaction2);
        Assert.assertEquals(1, this.database.getCount());
    }

    @Test()
    public void testContainsMethodsForCorrectReturn() {
        Assert.assertFalse(this.database.contains(this.transactions.get(0)));
        Assert.assertFalse(this.database.contains(this.transactions.get(0).getID()));

        this.database.add(this.transactions.get(0));

        Assert.assertTrue(this.database.contains(this.transactions.get(0)));
        Assert.assertTrue(this.database.contains(this.transactions.get(0).getID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusForExceptionBecauseOfRepeatingID() {
        this.database.add(this.transactions.get(0));
        this.database.changeTransactionStatus(2, TransactionStatus.UNAUTHORIZED);
    }

    @Test()
    public void testChangeTransactionStatusCorrectness() {
        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());
        this.database.changeTransactionStatus(1, TransactionStatus.UNAUTHORIZED);

        TransactionStatus expectedStatus = TransactionStatus.UNAUTHORIZED;
        Assert.assertEquals(expectedStatus, this.transactions.get(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIDForExceptionBecauseOfUnexistentID() {
        this.database.removeTransactionById(4);
    }

    @Test()
    public void testRemoveTransactionByIDCorrectness() {
        fillingTheChainblockWithTransactions();

        Assert.assertEquals(3, this.database.getCount());
        this.database.removeTransactionById(1);

        Assert.assertEquals(2, this.database.getCount());
        Assert.assertFalse(database.contains(transactions.get(0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIDForExceptionBecauseOfUnexistentID() {
        this.database.add(transactions.get(0));
        this.database.add(transactions.get(1));

        Transaction unexistentTransaction = this.database.getById(3);
    }

    @Test()
    public void testGetByIDCorrectness() {
        fillingTheChainblockWithTransactions();

        Transaction returnedTransaction = this.database.getById(3);
        Assert.assertEquals(returnedTransaction, this.transactions.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactioStatusForExceptionBecauseOfUnexistentStatus() {
        this.database.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test()
    public void testGetByTransactioStatusCorrectness() {
        List<Transaction> returnedTransactionsList = new ArrayList<>();
        fillingTheChainblockWithTransactions();

        Iterable<Transaction> returnedTransactions = this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        for (Transaction currentTransaction : returnedTransactions) {
            returnedTransactionsList.add(currentTransaction);
        }

        returnedTransactionsList = returnedTransactionsList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        this.transactions = this.transactions.stream()
                .filter(element -> element.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(returnedTransactionsList, this.transactions);
        Assert.assertEquals(returnedTransactionsList.size(), this.transactions.size());
        returnedTransactionsList.forEach(element -> Assert.assertEquals(element.getStatus(), TransactionStatus.SUCCESSFUL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusForExceptionBecauseOfNonExistentTransactionStatus() {
        fillingTheChainblockWithTransactions();
        Iterable<String> exceptionReturned = this.database.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }


    @Test()
    public void testGetAllSendersWithTransactionStatusCorrectness() {
        fillingTheChainblockWithTransactions();
        Transaction fourthTransaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Peter", "Georgi", 200.50);
        this.database.add(fourthTransaction);

        Iterable<String> returnedIterable = this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> returnedList = new ArrayList<>();
        returnedIterable.forEach(returnedList::add);

        this.transactions.add(fourthTransaction);
        List<String> expectedTransactionList = this.transactions.stream()
                .filter(element -> element.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Assert.assertEquals(expectedTransactionList, returnedList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusForExceptionBecauseOfNonExistentTransactionStatus() {
        fillingTheChainblockWithTransactions();
        Iterable<String> exceptionReturned = this.database.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }


    @Test()
    public void testGetAllReceiversWithTransactionStatusCorrectness() {
        fillingTheChainblockWithTransactions();
        Transaction fourthTransaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Peter", "Georgi", 200.50);
        this.database.add(fourthTransaction);

        Iterable<String> returnedIterable = this.database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> returnedList = new ArrayList<>();
        returnedIterable.forEach(returnedList::add);

        this.transactions.add(fourthTransaction);
        List<String> expectedTransactionList = this.transactions.stream()
                .filter(element -> element.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Assert.assertEquals(expectedTransactionList, returnedList);
    }

    @Test()
    public void testGetAllOrderedByAmountDescendingThenByIDCorrectness() {
        fillingTheChainblockWithTransactions();
        Transaction fourthTransaction = new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "Atanas", "Maria", 150.50);
        Transaction fifthTransaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Atanas", "Maria", 150.50);
        this.database.add(fourthTransaction);
        this.database.add(fifthTransaction);

        Iterable<Transaction> returnedIterable = this.database.getAllOrderedByAmountDescendingThenById();
        List<Transaction> returnedList = new ArrayList<>();
        returnedIterable.forEach(returnedList::add);

        this.transactions.add(fourthTransaction);
        this.transactions.add(fifthTransaction);

        this.transactions = this.transactions.stream()
                .sorted((element1, element2) -> {
                    int result = Double.compare(element2.getAmount(), element1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(element1.getID(), element2.getID());
                    }
                    return result;
                }).collect(Collectors.toList());

        Assert.assertEquals(transactions, returnedList);
    }


    private void fillingTheChainblockWithTransactions() {
        this.database.add(this.transactions.get(0));
        this.database.add(this.transactions.get(1));
        this.database.add(this.transactions.get(2));
    }

    private void fillingTheListWithTransactions() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Atanas", "Peter", 150.50);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Atanas", "George", 190.50);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Atanas", "Maria", 120.50);
        this.transactions.add(transaction1);
        this.transactions.add(transaction2);
        this.transactions.add(transaction3);
    }


}
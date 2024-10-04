import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ChainBlockTest {
    private ChainblockImpl chainblock;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    private Transaction transaction4;
    private Transaction nonExistentTransaction;

    @Before
    public void setUp() {
        // 1. Real Transactions' Instantiation:
        this.chainblock = new ChainblockImpl();
        this.transaction1 = new TransactionImpl(Constants.ID1, TransactionStatus.SUCCESSFUL, Constants.SENDER1, Constants.RECEIVER1, Constants.AMOUNT1);
        this.transaction2 = new TransactionImpl(Constants.ID2, TransactionStatus.ABORTED, Constants.SENDER2, Constants.RECEIVER2, Constants.AMOUNT2);
        this.transaction3 = new TransactionImpl(Constants.ID3, TransactionStatus.SUCCESSFUL, Constants.SENDER3, Constants.RECEIVER3, Constants.AMOUNT3);
        this.transaction4 = new TransactionImpl(Constants.ID4, TransactionStatus.SUCCESSFUL, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT4);
        // 2. Adding:
        this.chainblock.add(this.transaction1);
        this.chainblock.add(this.transaction2);
        this.chainblock.add(this.transaction3);
        this.chainblock.add(this.transaction4);
        // 3. Non-existent transaction implementation:
        this.nonExistentTransaction = new TransactionImpl(Constants.NONEXISTENT_TRANSACTION_ID, TransactionStatus.SUCCESSFUL, Constants.SENDER1, Constants.RECEIVER1, Constants.AMOUNT1);
    }

    // Tests:
    // 1. Contains1:
    @Test
    public void testContainsById() {
        Assert.assertTrue(this.chainblock.contains(Constants.ID1));
        Assert.assertTrue(this.chainblock.contains(Constants.ID2));
        Assert.assertTrue(this.chainblock.contains(Constants.ID3));
        Assert.assertTrue(this.chainblock.contains(Constants.ID4));
        Assert.assertFalse(this.chainblock.contains(Constants.NONEXISTENT_TRANSACTION_ID));
    }

    // 2. Contains2:
    @Test
    public void testContainsByTransaction() {
        Assert.assertTrue(this.chainblock.contains(this.transaction1));
        Assert.assertTrue(this.chainblock.contains(this.transaction2));
        Assert.assertTrue(this.chainblock.contains(this.transaction3));
        Assert.assertTrue(this.chainblock.contains(this.transaction4));
        Assert.assertFalse(this.chainblock.contains(this.nonExistentTransaction));
    }

    // 3. Add:
    @Test
    public void testAdd() {
        List<Transaction> expectedTransactions = new ArrayList<>(List.of(
                this.transaction1, this.transaction2, this.transaction3, this.transaction4));
        Map<Integer, Transaction> actualTransactionsById = this.chainblock.getTransactionByIdMap();
        List<Transaction> actualTransactions = getActualTransactions(actualTransactionsById);
        Assert.assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithExistentTransactionShouldThrow() {
        this.chainblock.add(this.transaction1);
    }

    // 4. Count:
    @Test
    public void testCount() {
        int actualCount = this.chainblock.getCount();
        Assert.assertEquals(Constants.TRANSACTIONS_COUNT, actualCount);
    }

    // 5. getById:
    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithNonExistentIdShouldThrow() {
        this.chainblock.getById(Constants.NONEXISTENT_TRANSACTION_ID);
    }

    @Test
    public void testGetById() {
        Transaction actualTrans1 = this.chainblock.getById(Constants.ID1);
        Transaction actualTrans2 = this.chainblock.getById(Constants.ID2);
        Transaction actualTrans3 = this.chainblock.getById(Constants.ID3);
        Transaction actualTrans4 = this.chainblock.getById(Constants.ID4);

        Assert.assertEquals(this.transaction1, actualTrans1);
        Assert.assertEquals(this.transaction2, actualTrans2);
        Assert.assertEquals(this.transaction3, actualTrans3);
        Assert.assertEquals(this.transaction4, actualTrans4);
    }

    // 6. ChangeTransStatus:
    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionWithNonExistentTransShouldThrow() {
        this.chainblock.changeTransactionStatus(Constants.NONEXISTENT_TRANSACTION_ID, TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeTransaction() {
        this.chainblock.changeTransactionStatus(Constants.ID1, TransactionStatus.ABORTED);
        this.chainblock.changeTransactionStatus(Constants.ID2, TransactionStatus.SUCCESSFUL);
        this.chainblock.changeTransactionStatus(Constants.ID3, TransactionStatus.ABORTED);
        this.chainblock.changeTransactionStatus(Constants.ID4, TransactionStatus.ABORTED);

        Transaction transaction1 = this.chainblock.getById(Constants.ID1);
        Transaction transaction2 = this.chainblock.getById(Constants.ID2);
        Transaction transaction3 = this.chainblock.getById(Constants.ID3);
        Transaction transaction4 = this.chainblock.getById(Constants.ID4);

        Assert.assertEquals(TransactionStatus.ABORTED, transaction1.getStatus());
        Assert.assertEquals(TransactionStatus.SUCCESSFUL, transaction2.getStatus());
        Assert.assertEquals(TransactionStatus.ABORTED, transaction3.getStatus());
        Assert.assertEquals(TransactionStatus.ABORTED, transaction4.getStatus());
    }

    // 7. removeTransactions:
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionsWithNonExistenIdShouldThrow() {
        this.chainblock.removeTransactionById(Constants.NONEXISTENT_TRANSACTION_ID);
    }

    @Test
    public void testRemoveTransaction() {
        this.chainblock.removeTransactionById(Constants.ID1);
        this.chainblock.removeTransactionById(Constants.ID3);

        List<Transaction> expectedTrans = new ArrayList<>(List.of(this.transaction2, this.transaction4));
        Map<Integer, Transaction> transactionMap = this.chainblock.getTransactionByIdMap();
        List<Transaction> actualTrans = getActualTransactions(transactionMap);

        Assert.assertEquals(expectedTrans, actualTrans);
    }

    // 8. getByTransStatus:
    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWithNonExistenTransShouldThrow() {
        this.chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWithNonExistenTransShouldThrow2() {
        this.chainblock.getByTransactionStatus(TransactionStatus.FAILED);
    }

    @Test()
    public void testGetByTransactionStatus1() {
        Iterable<Transaction> expectedTransactions = new ArrayList<>(List.of(
                this.transaction3, this.transaction4, this.transaction1));
        Iterable<Transaction> actualTransactions = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertEquals(expectedTransactions, actualTransactions);
    }

    @Test()
    public void testGetByTransactionStatus2() {
        Iterable<Transaction> expectedTransactions = new ArrayList<>(List.of(
                this.transaction2));
        Iterable<Transaction> actualTransactions = this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
        Assert.assertEquals(expectedTransactions, actualTransactions);
    }

    // 9. getAllSendersWithTransactionStatus:
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrow() {
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrow2() {
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatus() {
        Iterable<String> expectedSenders1 = new ArrayList<>(
                List.of(Constants.SENDER3, Constants.SENDER4, Constants.SENDER1));
        Iterable<String> actualSenders1 = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        Iterable<String> expectedSenders2 = new ArrayList<>(
                List.of(Constants.SENDER2));
        Iterable<String> actualSenders2 = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
        Assert.assertEquals(expectedSenders1, actualSenders1);
        Assert.assertEquals(expectedSenders2, actualSenders2);
    }

    // 10. getAllReceiversWithTransactionStatus:
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrow() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusThrow2() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatus() {
        Iterable<String> expectedReceivers1 = new ArrayList<>(
                List.of(Constants.RECEIVER3, Constants.RECEIVER4, Constants.RECEIVER1));
        Iterable<String> actualReceivers1 = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        Iterable<String> expectedReceivers2 = new ArrayList<>(
                List.of(Constants.RECEIVER2));
        Iterable<String> actualReceivers2 = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
        Assert.assertEquals(expectedReceivers1, actualReceivers1);
        Assert.assertEquals(expectedReceivers2, actualReceivers2);
    }

    // 11. getAllOrderedByAmountDescendingThenById:
    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        Transaction transactionWithSameAmount = new TransactionImpl(Constants.ID5, TransactionStatus.SUCCESSFUL, Constants.SENDER5, Constants.RECEIVER5, Constants.AMOUNT5);
        this.chainblock.add(transactionWithSameAmount);
        Iterable<Transaction> expectedTransactions = new ArrayList<>(
                List.of(this.transaction3, transactionWithSameAmount, this.transaction4, this.transaction1, this.transaction2));
        Iterable<Transaction> actualTransactions = this.chainblock.getAllOrderedByAmountDescendingThenById();
        Assert.assertEquals(expectedTransactions, actualTransactions);
    }

    // 12. getBySenderOrderedByAmountDescending:
    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingWithNonExistentSenderShouldThrow() {
        this.chainblock.getBySenderOrderedByAmountDescending(Constants.NONEXISTENT_SENDER);
    }

    @Test
    public void testGetBySenderOrderedByAmountDescending() {
        Transaction transactionWithSameSender = new TransactionImpl(
                Constants.ID6, TransactionStatus.UNAUTHORIZED, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT3);
        Transaction transactionWithSameSender2 = new TransactionImpl(
                Constants.ID5, TransactionStatus.UNAUTHORIZED, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT1);
        this.chainblock.add(transactionWithSameSender);
        this.chainblock.add(transactionWithSameSender2);

        Iterable<Transaction> expectedTransactions = new ArrayList<>(List.of(transactionWithSameSender, this.transaction4, transactionWithSameSender2));
        Iterable<Transaction> actualTransactions = this.chainblock.getBySenderOrderedByAmountDescending(Constants.SENDER4);
        Assert.assertEquals(expectedTransactions, actualTransactions);
    }

    // 13. getByReceiverOrderedByAmountThenById:
    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountDescendingWithNonExistentSenderShouldThrow() {
        this.chainblock.getBySenderOrderedByAmountDescending(Constants.NONEXISTENT_RECEIVER);
    }

    @Test
    public void testGetByReceiverOrderedByAmountDescendingThenById() {
        Transaction transactionWithSameReceiver = new TransactionImpl(
                Constants.ID6, TransactionStatus.UNAUTHORIZED, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT3);
        Transaction transactionWithSameReceiver2 = new TransactionImpl(
                Constants.ID5, TransactionStatus.UNAUTHORIZED, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT3);
        this.chainblock.add(transactionWithSameReceiver);
        this.chainblock.add(transactionWithSameReceiver2);

        Iterable<Transaction> expectedTransactions = new ArrayList<>(List.of(transactionWithSameReceiver2, transactionWithSameReceiver, this.transaction4));
        Iterable<Transaction> actualTransactions = this.chainblock.getByReceiverOrderedByAmountThenById(Constants.RECEIVER4);
        Assert.assertEquals(expectedTransactions, actualTransactions);
    }

    // 14. testGetByTransactionStatusAndMaximumAmount
    @Test
    public void testGetByTransactionStatusAndMaximumAmount() {
        Iterable<Transaction> expectedTrans1 = new ArrayList<>();
        Iterable<Transaction> actualTrans1 = this.chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, Constants.AMOUNT1);
        Iterable<Transaction> expectedTrans2 = new ArrayList<>(List.of(this.transaction4, this.transaction1));
        Iterable<Transaction> actualTrans2 = this.chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, Constants.AMOUNT4);

        Assert.assertEquals(expectedTrans1, actualTrans1);
        Assert.assertEquals(expectedTrans2, actualTrans2);
    }

    // 15. getBySenderAndMinimumAmountDescending
    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingWithLessAmountShouldThrow() {
        this.chainblock.getBySenderAndMinimumAmountDescending(Constants.SENDER1, Constants.AMOUNT1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingWithLessAmountShouldThrow2() {
        this.chainblock.getBySenderAndMinimumAmountDescending(Constants.SENDER2, Constants.AMOUNT2);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescending() {
        Iterable<Transaction> expectedTrans1 = new ArrayList<>(List.of(this.transaction1));
        Iterable<Transaction> actualTrans1 = this.chainblock.getBySenderAndMinimumAmountDescending(Constants.SENDER1, Constants.AMOUNT1 - Constants.ONE);
        Iterable<Transaction> expectedTrans2 = new ArrayList<>(List.of(this.transaction2));
        Iterable<Transaction> actualTrans2 = this.chainblock.getBySenderAndMinimumAmountDescending(Constants.SENDER2, Constants.AMOUNT2 - Constants.ONE);
        Iterable<Transaction> expectedTrans3 = new ArrayList<>(List.of(this.transaction3));
        Iterable<Transaction> actualTrans3 = this.chainblock.getBySenderAndMinimumAmountDescending(Constants.SENDER3, Constants.AMOUNT3 - Constants.ONE);
        Iterable<Transaction> expectedTrans4 = new ArrayList<>(List.of(this.transaction4));
        Iterable<Transaction> actualTrans4 = this.chainblock.getBySenderAndMinimumAmountDescending(Constants.SENDER4, Constants.AMOUNT4 - Constants.ONE);

        Assert.assertEquals(expectedTrans1, actualTrans1);
        Assert.assertEquals(expectedTrans2, actualTrans2);
        Assert.assertEquals(expectedTrans3, actualTrans3);
        Assert.assertEquals(expectedTrans4, actualTrans4);
    }

    // 16. getByReceiverAndAmountRange
    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrow() {
        double lowerBound = Constants.AMOUNT3;
        double upperBound = Constants.AMOUNT3;
        this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER1, lowerBound, upperBound);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrow2() {
        double lowerBound = Constants.AMOUNT2;
        double upperBound = Constants.AMOUNT2;
        this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER1, lowerBound, upperBound);
    }

    @Test
    public void testGetByReceiverAndAmountRange() {
        Iterable<Transaction> expected1 = new ArrayList<>(List.of(this.transaction1));
        Iterable<Transaction> actual1 = this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER1, Constants.AMOUNT1, Constants.AMOUNT1 + Constants.ONE);
        Iterable<Transaction> expected2 = new ArrayList<>(List.of(this.transaction2));
        Iterable<Transaction> actual2 = this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER2, Constants.AMOUNT2, Constants.AMOUNT2 + Constants.ONE);
        Iterable<Transaction> expected3 = new ArrayList<>(List.of(this.transaction3));
        Iterable<Transaction> actual3 = this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER3, Constants.AMOUNT3, Constants.AMOUNT3 + Constants.ONE);
        Iterable<Transaction> expected4 = new ArrayList<>(List.of(this.transaction4));
        Iterable<Transaction> actual4 = this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER4, Constants.AMOUNT4, Constants.AMOUNT4 + Constants.ONE);

        Transaction transaction5 = new TransactionImpl(
                Constants.ID5, TransactionStatus.UNAUTHORIZED, Constants.SENDER3, Constants.RECEIVER4, Constants.AMOUNT2);
        Transaction transaction6 = new TransactionImpl(
                Constants.ID6, TransactionStatus.UNAUTHORIZED, Constants.SENDER3, Constants.RECEIVER4, Constants.AMOUNT3);
        this.chainblock.add(transaction5);
        this.chainblock.add(transaction6);

        Iterable<Transaction> expected5 = new ArrayList<>(List.of(transaction6, this.transaction4, transaction5));
        Iterable<Transaction> actual5 = this.chainblock.getByReceiverAndAmountRange(Constants.RECEIVER4, Constants.AMOUNT2, Constants.AMOUNT3 + Constants.ONE);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
        Assert.assertEquals(expected5, actual5);
    }

    // 17. getAllInAmountRange
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllInAmountRangeOutOfRangeShouldThrow() {
        double lowerBound = Constants.AMOUNT3;
        double upperBound = Constants.AMOUNT3;
        this.chainblock.getAllInAmountRange(lowerBound, upperBound);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllInAmountRangeOutOfRangeShouldThrow2() {
        double lowerBound = Constants.AMOUNT2;
        double upperBound = Constants.AMOUNT2;
        this.chainblock.getAllInAmountRange(lowerBound, upperBound);
    }

    @Test
    public void testGetAllInAmountRange() {
        Iterable<Transaction> expected1 = new ArrayList<>(List.of(this.transaction2));
        double lowerBound1 = Constants.AMOUNT2;
        double upperBound1 = Constants.AMOUNT1;
        Iterable<Transaction> actual1 = this.chainblock.getAllInAmountRange(lowerBound1, upperBound1);

        Iterable<Transaction> expected2 = new ArrayList<>(List.of(this.transaction1, this.transaction2));
        double lowerBound2 = Constants.AMOUNT2;
        double upperBound2 = Constants.AMOUNT4;
        Iterable<Transaction> actual2 = this.chainblock.getAllInAmountRange(lowerBound2, upperBound2);

        Iterable<Transaction> expected3 = new ArrayList<>(List.of(this.transaction4, this.transaction1, this.transaction2));
        double lowerBound3 = Constants.AMOUNT2;
        double upperBound3 = Constants.AMOUNT3;
        Iterable<Transaction> actual3 = this.chainblock.getAllInAmountRange(lowerBound3, upperBound3);

        Iterable<Transaction> expected4 = new ArrayList<>(List.of(this.transaction3, this.transaction4, this.transaction1, this.transaction2));
        double lowerBound4 = Constants.AMOUNT2;
        double upperBound4 = Constants.AMOUNT3 + Constants.ONE;
        Iterable<Transaction> actual4 = this.chainblock.getAllInAmountRange(lowerBound4, upperBound4);

        Iterable<Transaction> expected5 = new ArrayList<>(List.of(this.transaction3, this.transaction4, this.transaction1));
        double lowerBound5 = Constants.AMOUNT2 + Constants.ONE;
        double upperBound5 = Constants.AMOUNT3 + Constants.ONE;
        Iterable<Transaction> actual5 = this.chainblock.getAllInAmountRange(lowerBound5, upperBound5);

        Iterable<Transaction> expected6 = new ArrayList<>(List.of(this.transaction4, this.transaction1));
        double lowerBound6 = Constants.AMOUNT2 + Constants.ONE;
        double upperBound6 = Constants.AMOUNT3;
        Iterable<Transaction> actual6 = this.chainblock.getAllInAmountRange(lowerBound6, upperBound6);

        Transaction transaction5 = new TransactionImpl(
                Constants.ID5, TransactionStatus.UNAUTHORIZED, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT4);
        Transaction transaction6 = new TransactionImpl(
                Constants.ID6, TransactionStatus.UNAUTHORIZED, Constants.SENDER4, Constants.RECEIVER4, Constants.AMOUNT1);
        this.chainblock.add(transaction5);
        this.chainblock.add(transaction6);

        Iterable<Transaction> expected7 = new ArrayList<>(List.of(this.transaction4, transaction5, this.transaction1, transaction6));
        double lowerBound7 = Constants.AMOUNT2 + Constants.ONE;
        double upperBound7 = Constants.AMOUNT3;
        Iterable<Transaction> actual7 = this.chainblock.getAllInAmountRange(lowerBound7, upperBound7);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
        Assert.assertEquals(expected5, actual5);
        Assert.assertEquals(expected6, actual6);
        Assert.assertEquals(expected7, actual7);
    }

    // 18. iterator
    @Test
    public void testIterator() {
        Iterator<Transaction> expectedIter = this.chainblock.iterator();
        List<Transaction> expectedTrans = new ArrayList<>(this.chainblock.getTransactionByIdMap().values());
        List<Transaction> actualTrans = new ArrayList<>();

        while (expectedIter.hasNext()) {
            Transaction currentTrans = expectedIter.next();
            actualTrans.add(currentTrans);
        }

        Assert.assertEquals(expectedTrans, actualTrans);
    }
    /*


    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return this.transactionByIdMap.values().stream()
                .filter(getByReceiverAndAmountPredicate(receiver, lo, hi))
                .collect(Collectors.toList());
    }

     */

    private static List<Transaction> getActualTransactions(Map<Integer, Transaction> actualTransactionsById) {
        return actualTransactionsById.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getId))
                .collect(Collectors.toList());
    }


}

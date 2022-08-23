import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Chainblock chainblock = new ChainblockImpl();
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Atanas", "Peter", 150.50);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Atanas", "George", 190.50);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Atanas", "Maria", 120.50);
        chainblock.add(transaction1);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> returnedList;

        //getByTransactionStatus
        returnedList = new ArrayList<>();
        Iterable<Transaction> iterableReturned = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        iterableReturned.forEach(returnedList::add);
        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //getAllSendersByTransactionStatus

        Transaction fourthTransaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Peter", "Georgi", 200.50);
        chainblock.add(fourthTransaction);
        Iterable<String> returnedIter = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> returnedList2 = new ArrayList<>();
        returnedIter.forEach(returnedList2::add);

        returnedList2.forEach(System.out::println);
        System.out.println();

        //getAllReceiverWithTransactionStatus
        returnedIter = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        returnedList2 = new ArrayList<>();
        returnedIter.forEach(returnedList2::add);

        returnedList2.forEach(System.out::println);
        System.out.println();

        //getAllOrderedByAmountDescendingThenById()
        Transaction transaction5 = new TransactionImpl(6, TransactionStatus.SUCCESSFUL, "Atanas", "Maria", 150.50);
        Transaction transaction6 = new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "Atanas", "Maria", 150.50);
        chainblock.add(transaction5);
        chainblock.add(transaction6);

        iterableReturned = chainblock.getAllOrderedByAmountDescendingThenById();
        returnedList = new ArrayList<>();
        iterableReturned.forEach(returnedList::add);

        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //getBySenderOrderedByAmountDescending
        iterableReturned = chainblock.getBySenderOrderedByAmountDescending("Atanas");
        returnedList = new ArrayList<>();
        iterableReturned.forEach(returnedList::add);

        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //getByReceiverOrderedByAmountThenById
        iterableReturned = chainblock.getByReceiverOrderedByAmountThenById("Maria");
        returnedList = new ArrayList<>();
        iterableReturned.forEach(returnedList::add);

        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //getByTransactionStatusAndMaximumAmount
        iterableReturned = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 150.50);
        returnedList = new ArrayList<>();
        iterableReturned.forEach(returnedList::add);

        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //getBySenderAndMinimumAmountDescending
        iterableReturned = chainblock.getBySenderAndMinimumAmountDescending("Atanas", 150.50);
        returnedList = new ArrayList<>();
        iterableReturned.forEach(returnedList::add);

        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //getByReceiverAndAmountRange
        iterableReturned = chainblock.getByReceiverAndAmountRange("Maria", 120.50, 150.51);
        returnedList = new ArrayList<>();
        iterableReturned.forEach(returnedList::add);

        returnedList.forEach(element -> System.out.println(element.toString()));
        System.out.println();

        //iterator
        Iterator<Transaction> it = chainblock.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

    }
}

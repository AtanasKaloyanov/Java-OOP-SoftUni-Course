import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Transaction> map1 = new HashMap<>();
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Example.A", "Example.A", 1.0);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Example.A", "Example.A", 1.0);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Example.A", "Example.A", 1.0);
        map1.put(1, transaction1);
        map1.put(2, transaction2);
        map1.put(3, transaction3);

        Map<TransactionStatus, Set<Transaction>> map2 = new HashMap<>();
        map2.put(TransactionStatus.SUCCESSFUL, new HashSet<>());
        map2.get(TransactionStatus.SUCCESSFUL).add(transaction1);
        map2.get(TransactionStatus.SUCCESSFUL).add(transaction2);
        map2.get(TransactionStatus.SUCCESSFUL).add(transaction3);

        Transaction transaction = map1.remove(1);
        Set<Transaction> set = map2.get(TransactionStatus.FAILED);
        System.out.println(set);

    }
}

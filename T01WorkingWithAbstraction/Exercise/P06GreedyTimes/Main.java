package T01WorkingWithAbstraction.Exercise.P06GreedyTimes;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading - capacity and adding tuples
        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] addingTuples = scanner.nextLine().split("\\s+");

        // 2. Creating a map with key the type of the product and with vaue another map.
        // The inner map has key product and value the quantity of the product. Creating 3 long variables too:

        //             type                product quantity
        LinkedHashMap<String, LinkedHashMap<String, Long>> quantityByProductMapByType = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < addingTuples.length; i += 2) {
            // 3. For cycle algorithm:
            // 3.1. Reading the product and the quantity
            String product = addingTuples[i];
            long addingQuantity = Long.parseLong(addingTuples[i + 1]);

            // 3.2. Exceeding the capacity check:
            long currentQuantity = gold + gems + cash;
            if (capacity < currentQuantity + addingQuantity) {
                continue;
            }

            // 3.3. Finding the type of the product and adding:
            String type;
            // 3.3.1. Cash adding:
            if (product.length() == 3) {
                type = "Cash";
                if (cash + addingQuantity > gems) {
                    continue;
                }
                quantityByProductMapByType.putIfAbsent(type, new LinkedHashMap<>());
                Map<String, Long> cashByProduct = quantityByProductMapByType.get(type);
                cashByProduct.putIfAbsent(product, 0L);
                cashByProduct.put(product, cashByProduct.get(product) + addingQuantity);

                cash += addingQuantity;
                // 3.3.2. Gem adding:
            } else if (product.toLowerCase().endsWith("gem")) {
                type = "Gem";
                if (gems + addingQuantity > gold) {
                    continue;
                }
                quantityByProductMapByType.putIfAbsent(type, new LinkedHashMap<>());
                Map<String, Long> gemByProduct = quantityByProductMapByType.get(type);
                gemByProduct.putIfAbsent(product, 0L);
                gemByProduct.put(product, gemByProduct.get(product) + addingQuantity);

                gems += addingQuantity;

                // 3.3.3. Gold adding:
            } else if (product.equalsIgnoreCase("gold")) {
                type = "Gold";
                quantityByProductMapByType.putIfAbsent(type, new LinkedHashMap<>());
                Map<String, Long> goldByProduct = quantityByProductMapByType.get(type);
                goldByProduct.putIfAbsent(product, 0L);
                goldByProduct.put(product, goldByProduct.get(product) + addingQuantity);

                gold += addingQuantity;
            }
        }

        // 4. Sorting with the help of 2 Comparators and printing:
        quantityByProductMapByType.entrySet().stream()
                .sorted(productSumComparator())
                .forEach( (entry) -> {
                    String type = entry.getKey();
                    Map<String, Long> quantityByProduct = entry.getValue();
                    long typeSum = getSum(quantityByProduct);
                    System.out.printf("<%s> $%d\n", type, typeSum);

                    quantityByProduct.entrySet().stream()
                            .sorted(nameAndSumComparator())
                            .forEach(innerEntryPrinting());
                });
    }

    private static Consumer<Map.Entry<String, Long>> innerEntryPrinting() {
        return (innerEntry) -> {
            String product = innerEntry.getKey();
            long quantity = innerEntry.getValue();
            System.out.printf("##%s - %d\n", product, quantity);
        };
    }

    private static Comparator<Map.Entry<String, Long>> nameAndSumComparator() {
        return (entry1, entry2) -> {
            String product1 = entry1.getKey();
            String product2 = entry2.getKey();
            int compN = product2.compareTo(product1);
            if (compN == 0) {
                long sum1 = entry1.getValue();
                long sum2 = entry2.getValue();
                compN = Long.compare(sum1, sum2);
            }
            return compN;
        };
    }

    private static Comparator<Map.Entry<String, LinkedHashMap<String, Long>>> productSumComparator() {
        return (map1, map2) -> {
            Map<String, Long> valueMap1 = map1.getValue();
            Map<String, Long> valueMap2 = map2.getValue();
            long sum1 = getSum(valueMap1);
            long sum2 = getSum(valueMap2);
            return Long.compare(sum2, sum1);
        };
    }

    private static long getSum(Map<String, Long> valueMap1) {
        return valueMap1.values().stream().mapToLong((e) -> e).sum();
    }
}

/*
Collection of 3 items:
 1. Gold - The item's name is the same - Gold
 2. Gem - Every item that ends with Gem and is at lest 4 symbols
 3. Cash - 3 letters items

Conditions:
 1. gem <= gold
 2. cash <= gem
 3. allItems <= capacity

The reading of the gem and the gold is case-insensitive
The reading of the Cash is case-sensitive

long allSum
Map<String, Long> sumsByItem;
Map<String, Map<String, Long>> sumByItemsMapByCategories = {<Gold>
                                                            <Gem>
                                                            <Cash>
                                                                    };

Input 1:
capacity - 150

   1. Gold 28 - The item is Gold. 1. <Gold> - 1.1. Gold = 28
                                                        / 28
                                  2. <Gem>
                                  3. <Cash>

   2. Rubygem  16 - The item is Gem . 1. <Gold> - 1.1. Gold = 28
                                                            / 28

                                      2. <Gem> - 2.1. Rubygem = 16
                                                              / 16
                                      3. <Cash>

   3. USD 9 - The item is Cash.       1. <Gold> - 1.1. Gold = 28
                                                            / 28

                                      2. <Gem> - 2.1. Rubygem = 16
                                                              / 16

                                      3. <Cash> - 3.1. USD = 9
                                                           / 9

   4. GBP 8 - The item is Cash. With it the cas sum becomes 17. It is more than the gems => skipping

                                   1. <Gold> - 1.1. Gold = 28
                                                         / 28

                                   2. <Gem> - 2.1. Rubygem = 16
                                                           / 16

                                   3. <Cash> - 3.1. USD = 9
                                                        / 9
Output 1:
       1. Gold = 28
         1.1. Gold = 28
       2. Gem = 16
         2.1 Rubygem = 16
       3. Cash = 9
         3.1. USD = 9


Input 2:
capacity - 24 000 010

   1. USD 1030 -  The item is Cash. The cash should be always smaller than the gems => skipping.
                        allItems = 0
                        1. <Gold> = {}
                        2. <Gem>  = {}
                        3. <Cash> = {}

   2. Gold 300 000  - The item is Gold.

                        allItems = 0 + 300 000 = 300 000
                        1. <Gold> = 1.1 Gold = 300 000
                                              /300 000

                        2. <Gem>  = {}
                        3. <Cash> = {}

   3. EmeraldGem 900 000 - The item is Gem. The gem should be smaller than gold => skipping

                        allItems = 300 000
                        1. <Gold> = 1.1 Gold = 300 000
                                              /300 000

                        2. <Gem>  = {}
                        3. <Cash> = {}

   4. Topazgem 290 000 - The item is gem. Adding.
                    allItems = 300 000 + 290 000 = 590 000
                        1. <Gold> = 1.1 Gold = 300 000
                                              /300 000

                        2. <Gem>  = 2.1 Topazgem = 290 000
                                                  /290 000

                        3. <Cash> = {}

   5. CHF 280 000. The item is cash. It is less than the gem => Adding
                   allItems = 590 000 + 280 000 = 870 000
                        1. <Gold> = 1.1 Gold = 300 000
                                              /300 000

                        2. <Gem>  = 2.1 Topazgem = 290 000
                                                  /290 000

                        3. <Cash> = 3.1.  CHF = 280 000
                                               /280 000

   6. Gold 10 000 000. The item is Gold. Adding
                  allItems = 870 000 + 10 000 000 = 10 870 000
                        1. <Gold> = 1.1 Gold = 300 000 + 10 000 000 = 10 300 000
                                                                     /10 300 000

                        2. <Gem>  = 2.1 Topazgem = 290 000

                        3. <Cash> = 3.1.  CHF = 280 000

   7. JPN 10 000 - The item is cash. Adding.
                allItems = 10 870 000 + 10 000 = 10 880 000
                        1. <Gold> = 1.1 Gold = 10 300 000
                                              /10 300 000

                        2. <Gem>  = 2.1 Topazgem = 290 000
                                                  /290 000

                        3. <Cash> = 3.1.  CHF = 280 000
                                    3.2.  JPN = 10 000
                                             / 290 000

   8. Rubygem 10 000 000 - The item is gem. Adding.
                allItems = 10 880 000 + 10 000 000 = 20 880 000
                        1. <Gold> = 1.1 Gold = 10 300 000
                                              /10 300 000

                        2. <Gem>  = 2.1. Topazgem =    290 000
                                    2.2. Rubygem  = 10 000 000
                                                   /10 290 000

                        3. <Cash> = 3.1.  CHF = 280 000
                                    3.2.  JPN  = 10 000
                                              / 290 000

   9. KLM 3 120 010 - The item is Cash. Adding
         allItems = 20 880 000 + 3 120 010 = 24 000 010
                        1. <Gold> = 1.1 Gold = 10 300 000
                                              /10 300 000

                        2. <Gem>  = 2.1. Topazgem =    290 000
                                    2.2. Rubygem  = 10 000 000
                                                   /10 290 000

                        3. <Cash> = 3.1.  CHF =   280 000
                                    3.2.  JPN  =   10 000
                                    3.3.  KLM = 3 120 010
                                              / 3 410 010

          Output 2:
                         1. Gold = 10 300 000
                            1.1. Gold = 10 300 000
                         2. Gem =  10 290 000
                            2.1. Topazgem = 290 000
                            2.2. Rubygem = 10 000 000
                         3. Cash = 3 410 010
                            3.1. KLM = 3 120 010
                            3.2. JPN = 10 000
                            3.3. CHF = 280 000


    Input 3:
       capacity - 80 345

       1. RubyGem 70 000 - Skipping
       2. JAV 10 960 - Skipping
       3. Bau 60 000 - Skipping
       4. Gold 80 000 - Adding

    Output 3:
        1. Gold = 80 000
            1.1. 80 000

Input 4:

27
Gold 10 Rubygem 0 USD 9 GBP 8

 */

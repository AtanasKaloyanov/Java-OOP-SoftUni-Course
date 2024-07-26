package T04InterfacesAndAbstraction.Exercise.P07CollectionHierarchy;

import java.util.Scanner;

public class Main {
    private static int n = 0;
    public static void main(String[] args) {
        // 1. Input reading - The elements for adding and the number of the
        // removed operation for every collection:
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        n = Integer.parseInt(scanner.nextLine());

        // 2. Creating 3 collections:
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        // 3. Adding the elements of the array into the collections via
        // the addElements method:
        addElements(array, addCollection);
        addElements(array, addRemoveCollection);
        addElements(array, myList);

        // 4. Removing n times the elements of both collection:
        remove(addRemoveCollection);
        remove(myList);
    }

    private static void remove(AddRemovable collection) {
        for (int i = 0; i < n; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void addElements(String[] array, Addable collection) {
        for (String element : array) {
            int index = collection.add(element);
            System.out.print(index + " ");
        }
        System.out.println();
    }
}

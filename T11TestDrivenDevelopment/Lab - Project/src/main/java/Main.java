
public class Main {
    public static void main(String[] args) {

        Product product = new Product("cheese", 3.40, 2);
        Product secondProduct = new Product("wine", 90, 2);
        Product thirdProduct = new Product("grape", 7.0, 3);
        Product fourthProduct = new Product("cola", 2, 3);
        Product fifthProduct = new Product("tea", 1, 5);
        Instock instock = new Instock();

        instock.addFiveProducts(product, secondProduct, thirdProduct, fourthProduct, fifthProduct);

        //findAllInRange()
        Iterable<Product> sortedProducts = instock.findAllInRange(1, 7);

        for (Product currentProduct : sortedProducts) {
            System.out.println(currentProduct.toString());
        }

        System.out.println();

        //findFirstMostExpensiveProducts()
        sortedProducts = instock.findFirstMostExpensiveProducts(4);

        for (Product currentProduct : sortedProducts) {
            System.out.println(currentProduct.toString());
        }

        System.out.println();

        //findAllByQuantity()
        sortedProducts = instock.findAllByQuantity(3);

        for (Product currentProduct : sortedProducts) {
            System.out.println(currentProduct);
        }


    }
}

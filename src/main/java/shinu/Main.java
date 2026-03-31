package shinu;

public class Main {
    public static void main(String[] args) {
        Product[] products = createProducts();
        printProducts(products);
    }

    public static Product[] createProducts() {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, false);

        productsArray[1] = new Product("Apple iPhone 17 Pro", "01.02.2025",
                "Apple Inc.", "USA", 5600, true);

        productsArray[2] = new Product("MacBook Pro 17' 256 32", "23.12.2025",
                "Apple Inc.", "USA", 7000, false);

        productsArray[3] = new Product("Huawei Mate 30", "29.03.2025",
                "Samsung Corp.", "China", 5200, true);

        productsArray[4] = new Product("Google Pixel 7", "11.11.2025",
                "Google Corp.", "USA", 5400, false);

    return productsArray;
    }

    public static void printProducts(Product[] products) {
        for (Product product : products) {
            product.printProduct();
            System.out.println("------------");
        }
    }
}
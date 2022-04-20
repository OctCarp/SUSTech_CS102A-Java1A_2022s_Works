package demos.onlineshopping;

import java.util.ArrayList;
import java.util.Map;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Product> rattingCart = new ArrayList<>();
    private ArrayList<Product> priceCart = new ArrayList<>();
    private float wallet;
    Map<Product, Store> link;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating > 0 && rating < 6) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            updateWallet(product.getPrice());
            shoppingCart.add(product);
            store.removeProduct(product);
            link.put(product, store);
            return true;
        } else {
            return false;
        }
    }

    public void sortByTime() {
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
    }

    public void sortByRatting() {
        priceCart = shoppingCart;
        priceCart.stream().sorted((p1, p2) -> ((Float) p1.getRatings()).compareTo(p2.getRatings()))
                .forEach(product -> System.out.println(product));
    }

    public void sortByPrice() {
        priceCart = shoppingCart;
        priceCart.stream().sorted((p1, p2) -> ((Float) p1.getPrice()).compareTo(p2.getPrice()))
                .forEach(product -> System.out.println(product));
    }

    public void viewShoppingCart(SortBy sortMethod) {

    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(product)) {
                link.get(product).addProduct(product);
                link.get(product).refundIncome(product);
                this.wallet += product.getPrice();
                shoppingCart.remove(product);
                return true;
            }
        }
        return false;
    }
}

package final65.onlineshopping;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> rattingCart = new ArrayList<>();
    private ArrayList<Product> priceCart = new ArrayList<>();
    private float wallet;
    HashMap<Product, Store> link=new HashMap<>();

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
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            link.put(product, store);
            store.transact(product, 0);
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
        priceCart.stream().sorted((p1, p2) -> ((Float) p1.getAvgRating()).compareTo(p2.getAvgRating()))
                .forEach(product -> System.out.println(product));
    }

    public void sortByPrice() {
        priceCart = shoppingCart;
        priceCart.stream().sorted((p1, p2) -> ((Float) p1.getPrice()).compareTo(p2.getPrice()))
                .forEach(product -> System.out.println(product));
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if(sortMethod==SortBy.PurchaseTime){
            sortByTime();
        }
        if(sortMethod==SortBy.Price){
            sortByPrice();
        }
        if(sortMethod==SortBy.Rating){
            sortByRatting();
        }
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

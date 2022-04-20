package demos.onlineshopping;

import java.util.ArrayList;

class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

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
            return true;
        } else {
            return false;
        }
    }
    public enum SortBy {
        PurchaseTime, Rating, Price;
        }


        public void viewShoppingCart(SortBy sortMethod) {

    }
}
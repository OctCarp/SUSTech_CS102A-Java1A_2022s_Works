package demos.onlineshopping;

import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        id = cnt;
        this.name = name;
        income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                productList.remove(productList.get(i));
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (hasProduct(product)) {
                income += product.getPrice();
                removeProduct(product);
            }
        }
        if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
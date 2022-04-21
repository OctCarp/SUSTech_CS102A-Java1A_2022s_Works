package final65.onlineshopping;

import java.util.ArrayList;

public class Product {

    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating > 0 && rating < 6) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        } else {
            int sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return (float) sum / ratings.size();
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public float getPrice() {
        return price;
    }


    public boolean equals(Product obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getId() != obj.getId()) {
            return false;
        } else if (this.getName() != obj.getName()) {
            return false;
        } else if (this.getPrice() != obj.getPrice()) {
            return false;
        } else if (!(this.getRatings().equals(obj.getRatings()))) {
            return false;
        }
        return true;
    }
}


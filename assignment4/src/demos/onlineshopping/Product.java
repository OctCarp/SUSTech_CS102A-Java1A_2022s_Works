package demos.onlineshopping;

import java.util.ArrayList;

public class Product {

        private static int cnt = 0;
        private int id = 1;
        private String name;
        private float price;
        private ArrayList<Integer> ratings;

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
            int sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return sum / ratings.size();
        }

        public String toString() {
            return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
        }

        public float getPrice() {
            return price;
        }
    }


package lc1352_Product_of_the_Last_K_Numbers;

import java.util.*;

// LeetCode 1352. Product of the Last K Numbers

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        arr = new ArrayList<>();
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k >= prefix.size()) {
            return 0;
        }
        return prefix.get(prefix.size() - 1) / prefix.get(prefix.size() - k - 1);
    }
}

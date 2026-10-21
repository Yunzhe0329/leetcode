package lc605_Can_Place_Flowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {

            boolean left_nei = (i == 0 || flowerbed[i - 1] == 0);
            boolean right_nei = (i == m - 1 || flowerbed[i + 1] == 0);

            if (left_nei && right_nei && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    void main() {
        int[] flowerbed1 = { 1, 0, 0, 0, 1 };
        int n1 = 1;
        IO.println(canPlaceFlowers(flowerbed1, n1));

        int[] flowerbed2 = { 1, 0, 0, 0, 1 };
        int n2 = 2;
        IO.println(canPlaceFlowers(flowerbed2, n2));
    }
}
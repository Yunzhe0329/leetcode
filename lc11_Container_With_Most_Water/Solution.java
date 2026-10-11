package lc11_Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        // 面積要最大 -> Min(height[l], height[r])要最大 && r -l 要最大
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height1 = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(sol.maxArea(height1));

        int[] height2 = new int[] { 1, 1 };
        System.out.println(sol.maxArea(height2));

    }
}
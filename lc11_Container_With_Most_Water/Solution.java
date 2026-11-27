package lc11_Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            result = Math.max(result, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height1 = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(sol.maxArea(height1));

        int[] height2 = new int[] {1, 1};
        System.out.println(sol.maxArea(height2));
    }
}

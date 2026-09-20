class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 找到最靠近圓心的 point
        // case 1 -> center is inside rect : x1 - xCenter - x2 -> xCenter (中)
        // case 2 -> center is to the left : xCenter - x1 - x2 -> x1 (左)
        // case 3 -> center is to the right : x1 - x2 - xCenter -> x2 (右)
        int closestX = Math.max(x1, Math.min(x2, xCenter));
        // y 同理
        int closestY = Math.max(y1, Math.min(y2, yCenter));
        // 計算和圓心的距離
        int dx = closestX - xCenter;
        int dy = closestY - yCenter;
        
        return dx*dx + dy*dy <= radius * radius;
    }
}

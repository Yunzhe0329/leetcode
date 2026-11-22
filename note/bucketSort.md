# Bucket sort

**排序演算法**，和 Quick sort, Bubble sort 不同的之處是 Bucket sort **不是比較排序**，而是分配排序

- 先準備幾個桶子，每個 bucket 有固定的區間(Interval)
- 先把要排序的資料丟到 bucket 中
- 接著再對桶子去排序(可以用其他的排序算法)
- 用空間換時間的算法

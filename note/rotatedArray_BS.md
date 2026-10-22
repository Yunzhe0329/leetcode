### Edge case 檢查
- 先往邊界找，例如今天給你一個長度為 n 的陣列，可以先思考:
    - idx = 0, idx = n - 1，在邊界上的時候，程式會不會有問題
    - 如果長度為 0 或是有重複值等等也可以去思考
    - 想辦法打爆自己的程式
- 可以先觀察 Constraints 確認 TC 的邊界在哪，先理解 Time complexity 限制再去思考解法


### BS 幾個重點
- [l, r] 當中是否可以找到題目所求的答案，什麼時候停?
    - 找到就回傳 → l <= r
    - 縮到剩一個 → l < r
- 題目給得比較條件可以知道要動哪個 pointer ?
- 在 mid 位置的數值可能是答案嗎?
    - yes -> l = mid or r = mid，避免略過當作沒有 (**可參考lc153**)
- 用 2 - 3 個元素的陣列去驗證初步的想法，在這些 case 中可以找出指標移動的問題

---
### 相關題目參考
- LC1752 Check if Array Is Sorted and Rotated
- LC33 Search in Rotated Sorted Array
- LC189 Rotate Array
- LC443 String Compression
- LC153 Find Minimum in Rotated Sorted Array
- LC34 Find First and Last Position (unfinished)
- LC35 Search Insert Position(unfinished)
- LC26 / LC27 / LC283(unfinished)


---














---

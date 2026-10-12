package lc2897_Apply_Operations_on_Array_to_Maximize_Sum_of_Squares;

public class BitConcept {
    void main() {
        long a = 0;
        // 1 << 31 左移 31 位元的運算結果是 int
        // int 使用 2's complement 表示，因此，最高位會是符號(0正數、1負數)
        // 指派給 long 的物件會自動extent成64bit(補0或1取決於你原先32位元是 0 or 1)
        // a |= 1 << 31; // 會變成負數, -2147483648
        a |= 1L << 31; // 2147483648
        IO.println(a);
        // 1111 1111 ... 1111 1111 ( 32 位全是 1) 1000 0000 ... 0000
        IO.println(Long.toBinaryString(a));

    }
}

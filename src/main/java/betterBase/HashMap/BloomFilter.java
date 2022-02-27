package betterBase.HashMap;

public class BloomFilter {
    public static void bitMap() {
        int[] arr = new int[10]; // 该数组大小可以表示320个bit，一个字节表示
        // arr[0] 0 ~ 32
        // arr[1] 32 ~ 64

        // 取出 178 位的bit值
        int i = 178;
        // 在哪个区间内
        int numIndex = 178 / 32;
        // 在区间内的偏移值
        int bitIndex = 178 % 32;

        // 拿到 178 位的状态
        int s = ((arr[numIndex] >> bitIndex) & 1);

        // 将 178 位的状态改成 1
        // 将 bitIndex上的那一位为 1， 其他位为 0，
        // 再与原来的数 arr[numIndex] 进行 或运算，即其他位与0或不会变，而bitIndex上的那一位与 1 进行或运算，不管怎么样都会变成 1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);


        // 将 178 位的状态改成 0，
        // 将bitIndex位置上的数变成1，其他位都是0，
        // 然后取反，除了bitIndex上的位全是1，再与原来的数arr[numIndex]进行与运算，使得只有bitIndex上那一位变成了0
        arr[numIndex] = arr[numIndex] & ( ~ (1 << bitIndex));
    }
}

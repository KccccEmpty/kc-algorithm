package base.xor;


/**
 * 异或运算的性质与扩展
 * 1）0^N == N N^N == 0
 * 2）异或运算满足交换律和结合率
 * 3）不用额外变量交换两个数
 * 4）一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
 * 5）一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
 */
public class EvenTimesOddTimes {

    //4）一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
    public static void printOddTimesNum1(int[] arr) {
        int result = 0;
        for (int cur : arr) {
           result ^= cur;
        }
        System.out.println(result);
    }

    //5）一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
    public static void printOddTimesNum2(int[] arr) {
        int eO = 0;
        int eHasOne = 0;
        for (int cur : arr) {
            eO ^= cur;  // eO = a ^ b
        }
        // ~eO：取反码
        // ~eO + 1：取补码
        // eO & (~eO + 1) ：得到二进制位第一个 1
        int rightOne = eO & (~eO + 1);
        for (int cur : arr) {
            if ((rightOne & cur) != 0) {
                eHasOne ^= cur; //eHasOne = a or b
            }
        }
        System.out.println(eHasOne + " " + (eHasOne ^ eO));

    }
}

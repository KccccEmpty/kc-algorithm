package base.暴力递归;

public class NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n]; // record[i] i 行的皇后放在第几列
        return process1(0, record, n);
    }

    // recode[0...i-1]的皇后，任何两个皇后一定都不共行，不共列，不共斜线
    // 目前来到了第 i 行
    // record[0...i-1]表示之前的行，放了的皇后位置
    // n 代表整体一共有多少行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // 终止行
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { // 当前行在 i 行，尝试 i 行所有的列 -> j
            // 当前 i 行的皇后，放在i列，会不会和之前（0...i-1)的皇后，共行共列或者共斜线
            // 如果是，认为无效
            // 如果不是，认为有效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}

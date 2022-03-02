package betterBase.KMP;

public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || s.length() < 1 || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0, i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            // 若两者匹配，两边都往后面走
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
                // 若此时 i2 已经移到第一位了，说明都没有匹配到，需要移动 i1 了
            } else if (next[i2] == -1) {
                i1++;
                // i2 没到第一位时，通过next数组向前移动 i2，相当于将str2往后推
            } else {
                i2 = next[i2];
            }
        }
        // i1 或者 i2 越界 说明匹配成功
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{1};
        }
        int[] next = new int[str.length];
        // 人为规定
        next[0] = -1;
        next[1] = 0;
        int i = 2; // next 数组的开始位置
        int cn = 0; // 往回跳的标识
        if (i < next.length) {
            // 当前跳到 cn 位置的字符，和 i-1 位置的字符配不上
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else { // 若 cn = 0，则表示没有相同的前后缀，即为0
                next[i++] = 0;
            }
        }
        return next;
    }
}

package 字符串;

/**
 * 1323. 6 和 9 组成的最大数字
 */
class Solution1323 {
    public int maximum69Number (int num) {
        String str = num + "";
        int index = str.indexOf("6");
        if (index == -1) {
            return num;
        }
        return Integer.parseInt(str.substring(0, index) + "9" + str.substring(index + 1));
    }

    public static void main(String[] args) {
        double v = 3 / 2.0;

    }
}
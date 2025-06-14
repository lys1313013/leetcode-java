package 字符串;

/**
 * 2566. 替换一个数字后的最大差值
 */
class Solution2566 {
    public int minMaxDifference(int num) {
        String str = num + "";
        int max = num;

        for (int i = 0; i < str.length(); i++) {
            String first = str.substring(i, i + 1);
            if (!"9".equals(first)) {
                max = Integer.parseInt(str.replaceAll(first, "9"));
                break;
            }
        }

        int min = Integer.parseInt(str.replaceAll(str.substring(0, 1), "0"));
        return max - min;
    }
}
package 字符串;

/**
 * 1432. 改变一个整数能得到的最大差值
 */
class Solution1432 {
    public int maxDiff(int num) {
        String str = num + "";
        int max = num;
        int min = num;

        for (int i = 0; i < str.length(); i++) {
            String first = str.substring(i, i + 1);
            if (!"9".equals(first)) {
                max = Integer.parseInt(str.replaceAll(first, "9"));
                break;
            }
        }
        // 如果第一位不等于1，则直接替换为1
        // 如果第一位等于1，则向后面遍历，遇到不是0和1的字符串替换为0
        String temp = str.substring(0, 1);
        if (!"1".equals(temp)) {
            min = Integer.parseInt(str.replaceAll(temp, "1"));
        } else {
            for (int i = 1; i < str.length(); i++) {
                String first = str.substring(i, i + 1);
                if ((!"0".equals(first)) && (!"1".equals(first))) {
                    min = Integer.parseInt(str.replaceAll(first, "0"));
                    break;
                }
            }
        }
        System.out.println(min);
        return max - min;
    }
}

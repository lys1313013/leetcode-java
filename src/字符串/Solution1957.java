package 字符串;

/**
 * 1957. 删除字符使字符串变好
 */
class Solution1957 {
    public String makeFancyString(String s) {
        if (s.length() <= 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        sb.append(c1);
        sb.append(c2);
        for (int i = 2; i < s.length(); i++) {
            char c3 = s.charAt(i);

            if (c1 == c2 && c2 == c3) {
                continue;
            } else {
                c1 = c2;
                c2 = c3;
                sb.append(c3);
            }
        }

        return sb.toString();
    }
}
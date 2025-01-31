package 字符串;

class Solution541 {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i+=k) {
            if (i + k < s.length()) {
                String substring = s.substring(i, i + k);
                if (flag) {
                    substring = new StringBuilder(substring).reverse().toString();
                }
                result.append(substring);
            } else {
                // 加上k就超出了，就不指定最后位置
                String substring = s.substring(i);
                if (flag) {
                    substring = new StringBuilder(substring).reverse().toString();
                }
                result.append(substring);
            }
            flag = !flag;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution541 solution = new Solution541();
        System.out.println(solution.reverseStr("abcdefg", 2)); // bacdfeg

        System.out.println(solution.reverseStr("abcdefg", 100));
    }
}
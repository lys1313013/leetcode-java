package 字符串;

class Solution0680 {
    public boolean validPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) {
            return true;
        }
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            String temp1 = s.substring(0, i) + s.substring(i + 1);
            String temp2 = new StringBuilder(temp1).reverse().toString();
            if (temp1.equals(temp2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0680 solution = new Solution0680();
//        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("cbbcc"));

    }
}
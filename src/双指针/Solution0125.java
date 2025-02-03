package 双指针;

class Solution0125 {
    public boolean isPalindrome(String s) {
        // 全部转成小写
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        int right = 0;
        int left = s.length() - 1;
        while (right < left) {
            char leftC = s.charAt(right);
            char rightC = s.charAt(left);
            if (leftC != rightC) {
                return false;
            }
            right++;
            left--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0125 solution = new Solution0125();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
package 二分;

class Solution0852 {
    public int peakIndexInMountainArray(int[] arr) {
        // 这里left和right要注意从第二位和最后第二位开始，防止+1、-1的时候越界
        // 同时，因为一定有山峰，所以没必要从第一位和最后一位开始
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int midle = (left + right) / 2;
            if (arr[midle] > arr[midle - 1] && arr[midle] > arr[midle + 1]) {
                return midle;
            } else if (arr[midle] > arr[midle + 1]) {
                right = midle - 1;
            } else {
                left = midle + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution0852 solution0852 = new Solution0852();
        // 输入：arr = [0,1,0]
        int[] arr = {0,1,0};
        System.out.println(solution0852.peakIndexInMountainArray(arr));
        // 输入 [3,4,5,1]
        // 预期结果 2
        int[] arr2 = {3,4,5,1};
        System.out.println(solution0852.peakIndexInMountainArray(arr2));

        // [18,29,38,59,98,100,99,98,90]
        // 预期结果 5
        int[] arr3 = {18,29,38,59,98,100,99,98,90};
        System.out.println(solution0852.peakIndexInMountainArray(arr3));

        // [3,5,3,2,0]
        int[] arr4 = {3,5,3,2,0};
        System.out.println(solution0852.peakIndexInMountainArray(arr4));

    }
}
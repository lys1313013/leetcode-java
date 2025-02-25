package 数组;

/**
 * 2502. 设计内存分配器
 * https://leetcode.cn/problems/design-memory-allocator/description/?envType=daily-question&envId=2025-02-25
 */
class Allocator {
    int[] arr;

    public Allocator(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
    }

    public int allocate(int size, int mID) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                sum++;
                if (sum == size) {
                    int j = 0;
                    for (; j < sum; j++) {
                        arr[i - j] = mID;
                    }
                    return i - j + 1;
                }
            } else {
                sum = 0;
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == mID) {
                sum++;
                arr[i] = Integer.MAX_VALUE;
            }
        }
        return sum;

    }
}

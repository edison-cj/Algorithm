package wcj.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description:
 * @author: Edison
 * @date: 2022/11/15 16:10
 */
public class BinarySearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[7];
        System.out.println("输入的数组：");
        for (int i = 0; i < 7; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("target:");
        int target = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println("输出：" + solution.search(nums,target));
    }

}

class Solution{

    public int search(int[] nums, int target) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
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

        int[] nums = new int[]{};
        int target = 1;
        int[] range;

        Solution solution = new Solution();
        range = solution.searchRange2(nums,target);
        for(int num : range){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("69. x 的平方根");
        System.out.println("算数平平方根:" + solution.mySqrt(1));
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

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1,- 1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                int temp = mid;
                while (nums[temp] == target) {
                    mid = temp;
                    range[0] = mid;
                    if(temp == 0) {
                        break;
                    }
                    temp--;
                }

                while (nums[mid] == target) {
                    range[1] = mid;
                    if(mid == nums.length - 1) {
                        break;
                    }
                    mid++;
                }
                break;
            }
        }
        return range;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] range = new int[]{-1,- 1};
        int left;
        int right;
        left = searchInsert(nums,target);
        right = searchInsert(nums,target + 1);
        if(left != nums.length && nums[left] == target) {
            range[0] = left;
            range[1] = right - 1;
        }
        return range;
    }

    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

}
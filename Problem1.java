// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2; // for integer overflow
            
            // if left side is sorted
            if(nums[low] <= nums[mid]){
                if(nums[mid] == target){
                    return mid;
                }
                // if number lies in left side range
                else if(nums[low] <= target && target <= nums[mid]){ 
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // else if right side is sorted
            else if(nums[mid] <= nums[high]){ 
                if (nums[mid] == target){
                    return mid;
                }
                // if the number lies in right side range
                else if(nums[mid] <= target && target <= nums[high]){ 
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

public class Problem1{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(nums, target));
    }
}
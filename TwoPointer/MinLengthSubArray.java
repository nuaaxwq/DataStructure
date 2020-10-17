package Oct_17_2020;
/*209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。



示例：

输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。*/
// two pointer
// taken left to record left index and traverse right, update sum and left while sum >= target
// taken min to save result
// time complex O(n) space complex O(1)
public class MinLengthSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < nums.length; right ++) {
            sum += nums[right];

            while (sum >= s) {
                sum -= nums[left];

                min = Math.min(min, right - left + 1);
                left ++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

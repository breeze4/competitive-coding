package leetcode;

import org.junit.Assert;

public class NumArray {

    public static void main(String[] args) {
        NumArray nums = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        Assert.assertEquals(1, nums.sumRange(0, 2));
        Assert.assertEquals(-1, nums.sumRange(2, 5));
        Assert.assertEquals(-3, nums.sumRange(0, 5));
    }

    private final int[] nums;
    private final int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int sum = 0;
            for(int x = 0; x <= i; x++)
                sum += nums[x];
            sums[i] = sum;

        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        if(i == 0) {
            sum = sums[j];
        } else {
            sum = sums[j] - sums[i - 1];
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
package leetcode;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 */
public class MaxSizeSubarraySumEqualsK {

    public static void main(String[] args) {
        MaxSizeSubarraySumEqualsK solution = new MaxSizeSubarraySumEqualsK();
        int actual1 = solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        Assert.assertEquals(4, actual1);
        int actual2 = solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 1);
        Assert.assertEquals(2, actual2);
        int actual3 = solution.maxSubArrayLen(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);
        Assert.assertEquals(2, actual3);
        int actual4 = solution.maxSubArrayLen(new int[]{13, 2, 3, 3, 4, 5, 2, 3, 1}, 1);
        Assert.assertEquals(1, actual4);
        int actual5 = solution.maxSubArrayLen(new int[]{1, 2, 13, 21, 4, 5, 2, 3, 4}, 1);
        Assert.assertEquals(1, actual5);
        int actual6 = solution.maxSubArrayLen(new int[]{2, 13, 21, 4, 3, 5, 2, 3, 4, 13, 21, 4, 3, 5, 2, 3, 4}, 1);
        Assert.assertEquals(0, actual6);
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        return maxSubArrayLenBFS(nums, k, totalSum);
    }

    private int maxSubArrayLenBFS(int[] nums, int k, int totalSum) {
        Queue<Node> nodes = new LinkedList<>();

        int start = 0;
        int end = nums.length - 1;
        nodes.offer(new Node(totalSum, start, end));

        int currSum = totalSum;
        int operations = 0;
        int N = nums.length;
        // estimate the time complexity:
        // breadth first traversal of the nodes, starting from the max length
        // then splits into two nodes, 1 less length than the length it started at
        // where one node has the list of nodes where the left-most node has been removed
        // and where one node has the list of nodes where the right-most node has been removed
        // this results in a time complexity resembling (in the worst case):
        // sum of N choose K (binomial coefficients) for K = N to 1;
        long estimatedOps = 0;
        for (int i = N; i > 0; i--) {
            long binomialCoefficient = CombinatoricsUtils.binomialCoefficient(N, i);
            estimatedOps += binomialCoefficient;
        }
        int logN = log(N, 2);
        while (start <= end) {
            operations++;
            Node curr = nodes.poll();
            currSum = curr.sum;
            start = curr.start;
            end = curr.end;
            if (currSum == k) {
                System.out.println(String.format("%s elements, performed %s traversals, worst case %s", N, operations, estimatedOps));
                return end - start + 1;
            } else if (start >= 0 && end >= start) {
                int leftElemRemoved = currSum - nums[start];
                int rightElemRemoved = currSum - nums[end];

                Node withLeftRemoved = new Node(leftElemRemoved, start + 1, end);
                Node withRightRemoved = new Node(rightElemRemoved, start, end - 1);

                nodes.offer(withLeftRemoved);
                nodes.offer(withRightRemoved);
            }
        }
        System.out.println(String.format("no match found: %s elements, performed %s traversals, worst case %s", N, operations, estimatedOps));
        return 0;
    }

    public static int sq(int n) {
        int i = n;
        int sq = 0;
        int count = 0;

        while (i > 0) {
            if ((i & 1) == 1) {
                sq += n << count;
            }

            i = i >> 1;
            count++;
        }

        return sq;
    }

    static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    class Node {
        int sum;
        int start;
        int end;

        Node(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "sum=" + sum +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}

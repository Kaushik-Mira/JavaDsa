import java.util.Arrays;

public class kthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int countPairs(int[] nums, int mid) {
        int count = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 1 };
        int k = 1;
        int result = smallestDistancePair(nums, k);
        System.out.println("The " + k + "-th smallest pair distance is: " + result);
    }
}

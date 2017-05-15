package subsetSumWithRepeats;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 16.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {3, 5, -1, 10, 5, 7};
        int targetSum = 19;

        boolean[] possibleSums = calcPossibleSums(nums, targetSum);

        List<Integer> subset = findSubset(nums, targetSum, possibleSums);

        System.out.println(targetSum + " = " +
                String.join(" + ", subset.stream().map(Object::toString).collect(Collectors.toList())));
    }

    private static boolean[] calcPossibleSums(int[] nums, int targetSum) {
        boolean[] possible = new boolean[targetSum + 1];
        possible[0] = true;

        for (int sum = 0; sum < possible.length; sum++) {
            if (possible[sum]) {
                for (int i = 0; i < nums.length; i++) {
                    int newSum = sum + nums[i];
                    if (newSum <= targetSum) {
                        possible[newSum] = true;
                    }
                }
            }
        }

        return possible;
    }

    // Recovery
    private static List<Integer> findSubset(int[] nums, int targetSum, boolean[] possibleSums) {
        List<Integer> subset = new ArrayList<>();

        while (targetSum > 0) {
            for (int i = 0; i < nums.length; i++) {
                int newSum = targetSum - nums[i];
                if (newSum >= 0 && possibleSums[newSum]) {
                    targetSum = newSum;
                    subset.add(nums[i]);
                }
            }
        }

        return subset;
    }
}

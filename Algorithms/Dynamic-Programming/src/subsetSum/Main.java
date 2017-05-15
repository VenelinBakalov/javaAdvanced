package subsetSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 12.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = { 3, 5, -1, 10, 5, 7 };
        int targetSum = 19;

        Map<Integer, Integer> possibleSums = calculatePossibleSums(nums, targetSum);

        // Print subset
        if (possibleSums.containsKey(targetSum)) {
            List<Integer> subset = findSubset(nums, targetSum, possibleSums);
            System.out.println(targetSum + " = " +
            String.join(" + ", subset.stream().map(Object::toString).collect(Collectors.toList())));
        }
    }

    // No repeats
    private static Map<Integer, Integer> calculatePossibleSums(int[] nums, int targetSum) {

        // sum -> what we added to obtain the sum
        // if we want all subsets sum -> List<Integer>
        Map<Integer, Integer> possibleSums = new HashMap<>();
        possibleSums.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            Map<Integer, Integer> newSums = new HashMap<>();

            for (Integer possibleSum : possibleSums.keySet()) {
                int newSum = possibleSum + currentNum;
                newSums.putIfAbsent(newSum, currentNum);
            }

            for (Integer newSum : newSums.keySet()) {
                possibleSums.putIfAbsent(newSum, newSums.get(newSum));
            }
        }

        return possibleSums;
    }

    private static List<Integer> findSubset(int[] nums, int targetSum, Map<Integer, Integer> possibleSums) {
        List<Integer> subset = new ArrayList<>();

        while (targetSum > 0) {
            int lastNum = possibleSums.get(targetSum);
            subset.add(0, lastNum);
            targetSum -= lastNum;
        }

        return subset;
    }

}

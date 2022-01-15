package amazon;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static int solve(int target, int[] numbers) {
        int result = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        int sum = 0;
        sumCount.put(sum, 1);

        for (int i : numbers) {
            sum += i;

            if (sumCount.containsKey(sum - target)) {
                result++;
            }

            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, -4, 5, 7, 2, -4};

        System.out.println(solve(5, numbers));
    }
}

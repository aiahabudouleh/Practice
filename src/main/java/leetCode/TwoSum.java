package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {  public int[] twoSum(int[] nums, int target) {
    /**
     Map Number to its Idex,
     Key = number
     values = index
     */
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> tracker = new HashMap<>();
    for (int i=0; i<nums.length ; ++i) {
        int key = target - nums[i];
        int index = tracker.getOrDefault(key, -1);
        if (index != -1) {
            ans.add(i);
            ans.add(index);
        } else {
            tracker.put(nums[i], i);
        }
    }

    return ans.stream().mapToInt(x -> x).toArray();

}

}

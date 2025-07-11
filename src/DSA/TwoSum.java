package DSA;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i< nums.length; i++)
        {
            numMap.put(nums[i],i);
        }
        for(int i =0; i<nums.length; i++)
        {
            int c = target-nums[i];
            if(numMap.containsKey(c)&&numMap.get(c)!=i)
            {
                return new int[]{i, numMap.get(c)};
            }
        }
        return null;
    }
    public static void main(String[] args)
    {
        TwoSum t = new TwoSum();
        int[] nums = {1,3,5,6};
        int target = 11;
        int[] res = t.twoSum(nums, target);
        System.out.println(res);

        if (res != null) {
            System.out.println(Arrays.toString(res));
        } else {
            System.out.println("No solution found.");
        }
    }
}

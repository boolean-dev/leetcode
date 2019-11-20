import java.util.HashMap;
import java.util.Map;

/**
 * @author 谛听
 * @className Leetcode01
 * @descriiption TODO
 * @date 2019/11/18 20:07
 **/
public class Leetcode01 {

    /*
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/two-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Leetcode01 leetcode01 = new Leetcode01();
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = leetcode01.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }


    /**
     * hash值方法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(4);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    // ----------------------------------------
    // 以下不是最优解

    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }


}
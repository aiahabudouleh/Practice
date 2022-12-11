package leetCode;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        for (int i=0 ; i< nums.length ; ++i) {
            if (nums[i] != 0) {
                swap(i, zeroIdx, nums);
                zeroIdx++ ;
            }
        }
    }

    private static void swap(int a , int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


}

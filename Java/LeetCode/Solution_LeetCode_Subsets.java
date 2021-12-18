package study;
import java.util.*;

public class Solution_LeetCode_Subsets {
	static List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        int n = nums.length;
        for(int i=1;i<=n;i++){
            int[] arr = new int[i];
            subset(n, i, 0, 0, nums, arr);
        }
        return list;
    }
    private static void subset(int n, int r, int start, int count, int[] nums, int[] selected){
        if(count == r) {
            List<Integer> newList = new ArrayList<Integer>();
            for(int i=0;i<r;i++)
                newList.add(selected[i]);
            list.add(newList);
            return;
        }
        for(int i=start;i<n;i++) {
            selected[count] = nums[i];
            subset(n, r, i+1, count+1, nums, selected);
        }
    }
}

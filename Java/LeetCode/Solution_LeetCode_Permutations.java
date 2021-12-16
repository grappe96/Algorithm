package study;

import java.util.*;
public class Solution_LeetCode_Permutations {
	static List<List<Integer>> list;
    static int n, selected[];
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        selected = new int[n];
        boolean[] visited = new boolean[n];
        list = new ArrayList<List<Integer>>();
        
        permutation(nums, 0, visited);
        
        return list;
    }
    private static void permutation(int[] nums, int now, boolean[] visited){
        if(now == n){
            List<Integer> newList = new ArrayList<Integer>();
            for(int i=0;i<n;i++)
                newList.add(selected[i]);
            list.add(newList);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            selected[now] = nums[i];
            visited[i] = true;
            permutation(nums, now+1, visited);
            visited[i] = false;
        }
    }
}

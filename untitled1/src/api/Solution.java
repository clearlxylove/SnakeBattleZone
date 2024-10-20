package api;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public double minimumAverage(int[] nums) {
        ArrayList<Double> avg = new ArrayList<>();
        double ans= Double.MAX_VALUE;
        while(nums.length>0){
            int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
            int min = Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
            System.out.println(max + " " + min);
            nums = Arrays.stream(nums).filter(n -> n!= max && n!= min).toArray();
            double value = (double)(max + min)/2;
            avg.add(value);
        }
        for(double i : avg){
            ans =Math.min(ans,i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumAverage(new int[]{7,8,3,4,15,13,4,1}));
    }
}
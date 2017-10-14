/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    3Sum Closest
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/3sum-closest/
 Notes:
 Given an array S of n integers, find three integers in S such that the sum is closest to 
 a given number, target. Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 Solution: Similar to 3Sum, taking O(n^2) time complexity.
 */
import java.lang.Math;
import java.lang.Exception;
//import java.io.*;
import java.util.Arrays;

public class Solution_3SumClosest {
    int[] cmb;
    int clst; 

    public static void main(String[] args) throws Exception{
        int nNumber = args.length - 1;
        int target = Integer.parseInt(args[args.length-1]);
        int[] num = new int[nNumber];

        for(int i=0;i<nNumber;i++){
            num[i] = Integer.parseInt(args[i]);
        }

        Solution_3SumClosest obj = new Solution_3SumClosest(num,target);

        System.out.println("the closest sum to " + target + " is: " + obj.clst + " with combination " + Arrays.toString(obj.cmb));
    }

    public Solution_3SumClosest(int[] num, int target) throws Exception{
        int N = num.length;
        try{
                int res = num[0] + num[1] + num[2];
                int[] bestcmb = {num[0],num[1],num[2]};
                Arrays.sort(num);
                for (int i = 0; i < N-2; ++i)
                {
                    int l = i + 1, r = N - 1;
                    while (l < r)
                    {
                        int threesum = num[i] + num[l] + num[r];
                        if (threesum == target) {
                            int[] tmp = {num[i],num[l],num[r]};
                            this.cmb = tmp;
                            this.clst = target;
                            return;
                        }
                        else if (threesum < target) ++l;
                        else --r;
                        if (Math.abs(threesum - target) < Math.abs(res - target))
                            {
                                res = threesum;
                                bestcmb = new int[]{num[i],num[l],num[r]};
                            }
                    }
                }
                this.cmb = bestcmb;
                this.clst = res;
            } catch(Exception e){
                System.out.println("Not Enough Parameters!!!");
                throw e;
            }
    }
}



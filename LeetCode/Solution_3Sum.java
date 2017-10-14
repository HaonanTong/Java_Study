
/*
 Author:     King, wangjingui@outlook.com
 Modified: Haonan Tong
 Date:       Dec 20, 2014
 Problem:    3Sum
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/3sum/
 Notes:
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.
 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},
 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 Solution: Simplify '3sum' to '2sum' O(n^2). http://en.wikipedia.org/wiki/3SUM
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;// for Arrays.sort

public class Solution_3Sum{
    public static void main(String args[]){
        System.out.println("Number of Input:" + args.length);
        int[] num = new int[args.length];
        for (int i = 1; i < args.length; i++){
            num[i] = Integer.parseInt(args[i-1]);
        }
       // System.out.println(args.length);
        //System.out.println(args.length);
        List<List<Integer>> res = threeSum(num);
        System.out.println(res);

	//res = threeSum(args[0]);
	//print(res);	
    }


    public static ArrayList<List<Integer>> threeSum(int[] num) {
            System.out.println("Input Array: " + Arrays.toString(num));

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
            System.out.println("Sorted Array:" + Arrays.toString(num));
        int N = num.length;
        for (int i = 0; i < N-2 && num[i] <= 0; ++i)
        {
            if (i > 0 && num[i] == num[i-1])
                continue; // avoid duplicates
            int twosum = 0 - num[i];
            int l = i + 1, r = N - 1;
            while (l < r)
            {
                int sum = num[l] + num[r];
                if (sum < twosum) ++l;
                else if (sum > twosum) --r;
                else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]); tmp.add(num[l]); tmp.add(num[r]);
                    res.add(tmp);
                    ++l; --r;
                    while (l < r && num[l] == num[l-1]) ++l;  // avoid duplicates
                    while (l < r && num[r] == num[r+1]) --r;  // avoid duplicates
                }
            }
        }
        return res;
    }
}

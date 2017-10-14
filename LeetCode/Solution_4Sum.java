/*
 Author:     Haonan Tong
 Problem:    4Sum
 Difficulty: Medium
 Note:
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 Find all unique quadruplets in the array which gives the sum of target.
 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 
Input:
[-3,-2,-1,0,0,1,2,3]
0
Expected:
[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

 class Solution_4Sum {
    int target;
    int[] array;
    ArrayList<List<Integer>> solution;

    public static void main(String args[]){
        System.out.println("-------------------------------");

        //int[] array = {1, 0, -1, 0, -2, 2};
        int[] array = {0,0,0,0};
        int target = 0;
        System.out.println("Input Array: " + Arrays.toString(array));
        System.out.println("Target: " + target); 

        Solution_4Sum obj = new Solution_4Sum(array, target);
        System.out.println("Solution: " + obj.solution);
    }

    public Solution_4Sum(int[] array, int target){
        this.array = array;
        this.target = target;
        Arrays.sort(array);//-2 -1 0 0 1 2
        ArrayList<List<Integer>> solution = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < array.length ; i++){
            if(i>0 && array[i]==array[i-1]) continue;//if array[i]==array[i-1], jump this iteration;
            for(int j=i+1; j<array.length; j++){
                if(j>(i+1) && array[j]==array[j-1]) continue;
                int twosum = target - array[i] - array[j];
                int l = j+1; int r = array.length - 1;
                while(l<r){
                    twosum = target - array[i] - array[j];
                    int sum = array[l] + array[r];
                    if(twosum == sum){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(array[i]);
                        tmp.add(array[j]);
                        tmp.add(array[l]);
                        tmp.add(array[r]);
                        solution.add(tmp);
                        while(l < r && array[l]==array[l+1]) l = l+1;// Order of contrains is important
                        while(l < r && array[r]==array[r-1]) r = r-1;
                        ++l;
                        --r;
                    }
                    if(twosum > sum){
                        ++l;
                    }

                    if(twosum < sum){
                        --r;
                    }
                    // System.out.println("i: " + i + "j: " + j + "l:" + l + "r:" +r);

                }
            }
        }
        this.solution = solution;
    }
 }
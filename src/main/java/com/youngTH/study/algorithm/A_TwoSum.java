package com.youngTH.study.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * @author YoungTH
 * @date 2019/5/7
 * 两数求和
 */
public class A_TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }


//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            //创建Map集合
//            Map<Integer,Integer> map = new HashMap<>();
//            //把给定数组导入Map集合
//            for (int i = 0; i < nums.length; i ++) {
//                map.put(nums[i], i);
//            }
//            //循环数组
//            for (int i = 0; i < nums.length; i ++) {
//                //用 target（和） 减去 数组里的一个数，得出complement
//                int complement = target - nums[i];
//                //判断map集合里是否含有complement && 判断 value 不是nums[i]的i
//                if (map.containsKey(complement) && map.get(complement) != i) {
//                    //返回两个索引
//                    return new int[] { i, map.get(complement) };
//                }
//            }
//            throw new IllegalArgumentException("No two sum solution");
//        }
//    }

}

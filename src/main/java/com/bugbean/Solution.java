package com.bugbean;

import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = findMax(candies);
        int differ = max-extraCandies;
        List<Boolean> result = new ArrayList<>();
        for(int i : candies){
            if(i>=differ){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }

    public int findMax(int[] candies) {
        int max = candies[0];
        for(int i : candies){
            if(max<i){
                max = i;
            }
        }
        return max;
    }
}
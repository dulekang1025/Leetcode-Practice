package Leetcode_658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int closest = x;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(arr[mid] > closest) high = mid;
            else low = mid + 1;
        }
        int upper = low;
        int lower = low - 1;
        for(int i = k; i > 0 ; i--){
            if((upper <= arr.length - 1) && (lower >= 0)){
                if((arr[upper] - x) >= (x - arr[lower])) ans.add(arr[lower--]);
                else ans.add(arr[upper++]);
            }else if(upper > arr.length - 1){
                ans.add(arr[lower--]);
            }else if(lower <= 0){
                ans.add(arr[upper++]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

package Leetcode_842_Split_Array_into_Fibonacci_Sequence;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans = new ArrayList<>();
    String s;
    public List<Integer> splitIntoFibonacci(String S) {
        this.s = S;
        if(S.length() < 3) return ans;
        for(int i = 1; i <= Math.min(s.length() / 2, 10); i++){ // i <=
            if(i > 1 && s.charAt(0) == '0') break;
            for(int j = 1; s.length() - i - j >= Math.max(i, j) ; j++){  // j >=
                if(j > 1 && s.charAt(i) == '0') continue;
                Long first = Long.valueOf(s.substring(0, i));
                Long second = Long.valueOf(s.substring(i, i + j));
                if(first > Integer.MAX_VALUE || second > Integer.MAX_VALUE) break;
                ans.add((int)(long)first);
                ans.add((int)(long)second);
                if(canSplit(first, second, i + j)){
                    return ans;
                }else{
                    ans.clear();
                }
            }
        }
        return new ArrayList<>();
    }
    private boolean canSplit(Long first, Long second, int index){
        if(index == s.length()) return true;
        //System.out.print(first + " " + second + " ");
        second = first + second;
        if(second > Integer.MAX_VALUE) return false;
        first = second - first;
        String sum = second.toString();
        //System.out.println(sum);
        if(!s.startsWith(sum, index)){
            return false;
        }
        ans.add((int)(long)second);
        return canSplit(first, second, index + sum.length());
    }
}

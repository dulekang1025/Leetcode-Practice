package Leetcode_166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator == 0) return "0";
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
            sb.append("-");
        long top = Math.abs((long)numerator);
        long btm = Math.abs((long)denominator);
        sb.append(top / btm);
        long reminder = top % btm;
        if(reminder == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(reminder != 0){
            if(map.containsKey(reminder)){
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }
            map.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / btm);
            reminder %= btm;
        }
        return sb.toString();
    }
}

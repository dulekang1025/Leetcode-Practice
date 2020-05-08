package Leetcode_306_Additive_Number;

class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3 || num == "") return false;
        for(int i = 1; i <= num.length() / 2; i++){
            if(i > 1 && num.charAt(0) == '0') break;
            for(int j = 1; num.length() - i - j >= Math.max(i, j); j++){
                if(j > 1 && num.charAt(i) == '0') continue;
                Long first = Long.valueOf(num.substring(0, i));
                Long second = Long.valueOf(num.substring(i, i + j));
                if(vaild(first, second, num, i + j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean vaild(Long first, Long second, String num, int start){
        if(start == num.length()) return true;
        System.out.println(first + " " + second);
        second = first + second;
        first = second - first;
        String sum = second.toString();
        if(num.startsWith(sum, start)){
            return vaild(first, second, num, start + sum.length());
        }
        return false;
    }
}

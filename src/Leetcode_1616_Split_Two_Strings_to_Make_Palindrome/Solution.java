package Leetcode_1616_Split_Two_Strings_to_Make_Palindrome;

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b){
        for(int i = 0, j = b.length() - 1; i < j; i++, j--){
            if(a.charAt(i) != b.charAt(j)){
                return isPalindrome(a, i, j) || isPalindrome(b, i, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}

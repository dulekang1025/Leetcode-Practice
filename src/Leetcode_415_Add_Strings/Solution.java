package Leetcode_415_Add_Strings;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int temp = 0;
            if (l1 >= 0) {
                temp += (num1.charAt(l1--) - '0');
            }
            if (l2 >= 0) {
                temp += (num2.charAt(l2--) - '0');
            }
            temp += carry;
            carry = temp / 10;
            res.append(temp % 10);
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}


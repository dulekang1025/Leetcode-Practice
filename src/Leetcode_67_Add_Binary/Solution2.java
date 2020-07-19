package Leetcode_67_Add_Binary;

class Solution2 {
    public String addBinary(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int len1 = s1.length, len2 = s2.length;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(len1 > 0 && len2 > 0){
            int i = Character.getNumericValue(s1[len1 - 1]);
            int j = Character.getNumericValue(s2[len2 - 1]);
            int temp = i + j + carry;
            if(temp == 3){
                sb.append(1);
                carry = 1;
            }else if(temp == 2){
                sb.append(0);
                carry = 1;
            }else if(temp == 1){
                sb.append(1);
                carry = 0;
            }else{
                sb.append(0);
                carry = 0;
            }
            len1--;
            len2--;
        }
        while(len1 > 0){
            int i = Character.getNumericValue(s1[len1 - 1]);
            int temp = i + carry;
            if(temp == 3){
                sb.append(1);
                carry = 1;
            }else if(temp == 2){
                sb.append(0);
                carry = 1;
            }else if(temp == 1){
                sb.append(1);
                carry = 0;
            }else{
                sb.append(0);
                carry = 0;
            }
            len1--;
        }
        while(len2 > 0){
            int i = Character.getNumericValue(s2[len2 - 1]);
            int temp = i + carry;
            if(temp == 3){
                sb.append(1);
                carry = 1;
            }else if(temp == 2){
                sb.append(0);
                carry = 1;
            }else if(temp == 1){
                sb.append(1);
                carry = 0;
            }else{
                sb.append(0);
                carry = 0;
            }
            len2--;
        }
        if(carry == 1){
            carry = 0;
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

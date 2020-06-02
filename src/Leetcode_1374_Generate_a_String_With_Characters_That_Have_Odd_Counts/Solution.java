package Leetcode_1374_Generate_a_String_With_Characters_That_Have_Odd_Counts;

class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        char a = 'a';
        char b = 'b';
        if(n % 2 == 0){
            for(int i = 0; i < n - 1; i++){
                sb.append(a);
            }
            sb.append(b);
        }else{
            for(int i = 0; i < n; i++){
                sb.append(a);
            }
        }
        return sb.toString();
    }
}

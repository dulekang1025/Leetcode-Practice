package Leecode_67_Add_Binary;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb =  new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int head = 0;
        while(i >= 0 || j >=0){
            int sum = head;
            if(i >= 0) sum += a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            head = sum / 2;
            j--;
            i--;
        }
        if(head == 1) {
            sb.append(head);
        }
        return sb.reverse().toString();
    }
}

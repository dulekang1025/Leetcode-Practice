package Leetcode_468_Validate_IP_Address;

class Solution {
    public String validIPAddress(String IP) {
        if(isIPv4(IP))
            return "IPv4";
        else if(isIPv6(IP))
            return "IPv6";
        else
            return "Neither";
    }
    private boolean isIPv4(String IP){
        if(IP.indexOf('.') == -1) return false;
        String[] parts = IP.split("\\.", -1);
        if(parts.length != 4) return false;
        for(String s : parts){
            if(s.equals("")) return false;
            if(s.length() > 1 && s.charAt(0) == '0') return false;
            for(char c : s.toCharArray()){
                if(!Character.isDigit(c)) return false;
            }
            try{
                int num = Integer.parseInt(s);
                if(num > 255) return false;
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    private boolean isIPv6(String IP){
        if(IP.indexOf(':') == -1) return false;
        String[] parts = IP.split(":", -2);
        if(parts.length != 8) return false;
        for(String s : parts){
            if(s.equals("")) return false;
            if(s.length() > 4) return false;
            s = s.toLowerCase();
            for(char c : s.toCharArray()){
                if(!Character.isDigit(c) && (c > 'f' || c < 'a')) return false;
            }

        }
        return true;
    }
}
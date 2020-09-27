package Leetcode_1598_Crawler_Log_Folder;

class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for(String l : logs){
            if(l.equals("../")){
                if(level != 0) level--;
            }else if(l.equals("./")){
                continue;
            }else{
                level++;
            }
        }
        return level;
    }
}

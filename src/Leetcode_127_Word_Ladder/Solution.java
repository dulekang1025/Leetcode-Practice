package Leetcode_127_Word_Ladder;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        if(!set.contains(endWord)) return level;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            //System.out.println("~");
            int size = queue.size();
            for(int k = 0; k < size; k++){
                String cur = queue.poll();
                if(endWord.equals(cur)) return level + 1;
                char[] curWord = cur.toCharArray();
                for(int i = 0; i < curWord.length; i++){
                    char temp = curWord[i];
                    for(char j = 'a'; j <= 'z'; j++){
                        if(j == temp) continue;
                        curWord[i] = j;
                        String s = new String(curWord);
                        if(set.contains(s)){
                            queue.offer(s);
                            set.remove(s);
                        }
                        curWord[i] = temp;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

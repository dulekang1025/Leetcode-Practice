package Leetcode_720_Longest_Word_in_Dictionary;

class Solution {

    Node root = new Node();
    String ans = null;

    public String longestWord(String[] words) {
        for(String s : words){
            Node cur = root;
            int level = 0;
            for(char c : s.toCharArray()){
                if(cur.arr[c - 'a'] == null){
                    cur.arr[c - 'a'] = new Node();
                }
                cur = cur.arr[c - 'a'];
                cur.level = level;
                level++;
            }
            cur.s = s;
        }
        dfs(root);
        return ans;
    }
    private String dfs(Node node){
        Node cur = node;
        for(int i = 0; i < 26; i++){
            if(cur.arr[i] != null && cur.arr[i].s != null){
                String temp = dfs(cur.arr[i]);
                if(ans == null){
                    ans = temp;
                }else{
                    ans = temp.length() != ans.length() ?
                            (temp.length() > ans.length() ? temp : ans) :
                            (temp.compareTo(ans) > 0 ? ans : temp);
                }
            }
        }
        return cur.s;
    }
}

class Node{
    Node[] arr;
    String s;
    int level;
    public Node(){
        arr = new Node[26];
        s = null;
        level = 0;
    }
}

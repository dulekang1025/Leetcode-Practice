package Leetcode_648_Replace_Words;

import java.util.List;

class Solution {

    Node root = new Node();

    public String replaceWords(List<String> dict, String sentence) {
        build(dict);
        String[] s = sentence.split(" ");
        replace(s);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            sb.append(s[i]);
            if(i != s.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    private void replace(String[] s){
        for(int i = 0; i < s.length; i++){
            String temp = search(s[i].trim());
            if(temp != null) s[i] = temp;
        }
    }

    private String search(String s){
        String ans = null;
        Node cur = root;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;
            if(cur.arr[s.charAt(i) - 'a'] == null) break;
            cur = cur.arr[s.charAt(i) - 'a'];
            if(cur.flag){
                ans = s.substring(0, i + 1);
                break;
            }
        }
        //System.out.println(ans);
        return ans;
    }

    private void build(List<String> dict){
        for(String s : dict){
            Node cur = root;
            for(int i = 0; i < s.length() ; i++){
                if(cur.arr[s.charAt(i) - 'a'] == null){
                    cur.arr[s.charAt(i) - 'a'] = new Node();
                }
                cur = cur.arr[s.charAt(i) - 'a'];
            }
            cur.flag = true;
        }
    }
}

class Node{
    Node[] arr;
    boolean flag;
    public Node(){
        this.arr = new Node[26];
        this.flag = false;
    }
}

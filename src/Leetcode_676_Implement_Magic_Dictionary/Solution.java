package Leetcode_676_Implement_Magic_Dictionary;

class MagicDictionary {

    Node root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict){
            Node cur = root;
            for(char c : s.toCharArray()){
                if(cur.arr[c - 'a'] == null){
                    cur.arr[c - 'a'] = new Node();
                }
                cur = cur.arr[c - 'a'];
            }
            cur.s = s;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(word, root, 0, 1);
    }

    private boolean dfs(String word, Node node, int index, int modify){
        Node cur = node;
        if(modify < 0) return false;
        if(index == word.length()){
            return modify == 0 && cur.s != null;
        }
        char c = word.charAt(index);
        for(int i = 0; i < 26; i++){
            if(cur.arr[i] == null) continue;
            if(i == c - 'a'){
                if(dfs(word, cur.arr[i], index + 1, modify)){
                    return true;
                }
            }else{
                if(dfs(word, cur.arr[i], index + 1, modify - 1)){
                    return true;
                }
            }
        }
        return false;
    }
}

class Node{
    Node[] arr;
    String s;
    public Node(){
        this.arr = new Node[26];
        this.s = null;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

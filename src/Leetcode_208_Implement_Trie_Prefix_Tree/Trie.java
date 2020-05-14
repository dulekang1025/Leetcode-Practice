package Leetcode_208_Implement_Trie_Prefix_Tree;

class Trie {

    class Node{
        Node[] children;
        boolean flag;
        public Node(){
            children = new Node[26];
            flag = false;
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for(char c : arr){
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for(char c : arr){
            if(cur.children[c - 'a'] == null) return false;
            else{
                cur = cur.children[c - 'a'];
            }
        }
        return cur.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Node cur = root;
        for(char c : arr){
            if(cur.children[c - 'a'] == null) return false;
            else{
                cur = cur.children[c - 'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

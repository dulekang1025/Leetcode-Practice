package Leetcode_211_Add_and_Search_Word_Data_structure_design;

class WordDictionary {

    Node root;
    Node cur;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        cur = root;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.arr[word.charAt(i) - 'a'] == null){
                cur.arr[word.charAt(i) - 'a'] = new Node();
            }
            cur = cur.arr[word.charAt(i) - 'a'];
        }
        cur.isString = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, Node node){
        Node temp = node;
        for(int j = 0; j < word.length(); j++){
            if(word.charAt(j) == '.'){
                for(int i = 0; i < 26; i++){
                    if(temp.arr[i] == null) continue;
                    if(dfs(word.substring(j + 1), temp.arr[i])) return true;
                }
                return false;
            }
            if(temp.arr[word.charAt(j) - 'a'] == null) return false;
            temp = temp.arr[word.charAt(j) - 'a'];
        }
        return temp.isString;
    }
}

class Node{
    Node[] arr;
    boolean isString;
    public Node(){
        arr = new Node[26];
        isString = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
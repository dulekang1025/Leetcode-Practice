package Leetcode_1032_Stream_of_Characters;

class StreamChecker {

    Node root = new Node();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for(String w : words){
            Node cur = root;
            char[] a = w.toCharArray();
            for(int i = a.length - 1; i >= 0; i--){
                char c = a[i];
                if(cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Node();
                cur = cur.arr[c - 'a'];
            }
            cur.f = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        Node cur = root;
        for(int i = sb.length() - 1; i >= 0; i--){
            if(cur.arr[sb.charAt(i) - 'a'] == null) return false;
            if(cur.arr[sb.charAt(i) - 'a'].f) return true;
            cur = cur.arr[sb.charAt(i) - 'a'];
        }
        return false;
    }
}

class Node{
    Node[] arr;
    boolean f;
    public Node(){
        this.arr = new Node[26];
        this.f = false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

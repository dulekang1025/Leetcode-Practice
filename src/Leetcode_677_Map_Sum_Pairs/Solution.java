package Leetcode_677_Map_Sum_Pairs;

class MapSum {

    Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for(int i = 0; i < key.length(); i++){
            if(cur.arr[key.charAt(i) - 'a'] == null){
                cur.arr[key.charAt(i) - 'a'] = new Node();
            }
            cur = cur.arr[key.charAt(i) - 'a'];
        }
        cur.flag = true;
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            if(cur.arr[prefix.charAt(i) - 'a'] == null) return 0;
            cur = cur.arr[prefix.charAt(i) - 'a'];
        }
        return dfs(cur);
    }

    private int dfs(Node cur){
        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(cur.arr[i] == null) continue;
            ans += dfs(cur.arr[i]);
        }
        return ans + cur.val;
    }
}

class Node{
    Node[] arr;
    boolean flag;
    int val;
    public Node(){
        arr = new Node[26];
        flag = false;
        val = 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

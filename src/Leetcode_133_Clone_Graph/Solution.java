package Leetcode_133_Clone_Graph;

import Graph_Node.Node;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return helper(node);
    }
    public Node helper(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node cur = new Node();
        cur.neighbors = new ArrayList();
        cur.val = node.val;
        map.put(node,cur);
        for(Node n : node.neighbors){
            cur.neighbors.add(helper(n));
        }
        return cur;
    }

}

package Leetcode_133_Clone_Graph;

import java.util.*;

public class Solution2 {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node cloned = new Node(node.val, new ArrayList<>());
        queue.add(node);
        map.put(node, cloned);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node nei : cur.neighbors){
                if(!map.containsKey(nei)){
                    Node new_node = new Node(nei.val, new ArrayList<>());
                    map.put(nei, new_node);
                    queue.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return cloned;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

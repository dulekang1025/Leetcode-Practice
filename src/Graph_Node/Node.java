package Graph_Node;

import java.util.List;

// Definition for a Node of graph from Leetcode
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

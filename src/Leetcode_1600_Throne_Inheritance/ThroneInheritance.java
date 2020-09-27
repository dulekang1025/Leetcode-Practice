package Leetcode_1600_Throne_Inheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThroneInheritance {

    Map<String, Node> map = new HashMap<>();
    Node root;

    public ThroneInheritance(String kingName) {
        root = new Node(kingName);
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node(childName);
        map.put(childName, child);
        parent.children.add(child);
    }

    public void death(String name) {
        map.get(name).death = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<String> res){
        if(node == null) return;
        if(!node.death) res.add(node.name);
        for(Node c : node.children){
            dfs(c, res);
        }
    }
}

class Node{
    List<Node> children;
    boolean death;
    String name;

    public Node(String name){
        this.children = new ArrayList<>();
        this.death = false;
        this.name = name;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

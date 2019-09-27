package Leetcode_684_RedundantConnection;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] findRedundantConnection(int[][] edges){
        // 使用邻接表来储存图的信息, 无向图， 双向添加节点
        HashMap<Integer, ArrayList<Integer>> garph = new HashMap<>();

        // 遍历每条边
        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            ArrayList<Integer> visited = new ArrayList<>();
            //深度优先遍历，判断判断u，v之间是否已经存在一条路径
            boolean hasPath = dfs_helper(u,v,garph,visited);

            if(hasPath){
                return edge;
            }
            else {
                // 将该边加入邻接表
                if(!garph.containsKey(u)){
                    garph.put(u,new ArrayList<Integer>());
                }
                garph.get(u).add(v);

                if(!garph.containsKey(v)){
                    garph.put(v,new ArrayList<Integer>());
                }
                garph.get(v).add(u);

            }
        }
        return null;
    }

    //深度优先遍历，判断判断start，end之间是否已经存在一条路径，return true就是已存在
    private boolean dfs_helper(int start, int end, HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> visited){

        //先判断keyset里，start 和 end 是否存在，不存在就返回false，从而把节点加入图中
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return false;
        }

        //最后一层， 通常也是判断条件触发的地方
        if(start == end){
            return true;
        }

        //将start节点加入visited, 从start开始遍历
        visited.add(start);

        //遍历start 所有相邻节点, 直到所有节点都在visited里
        for(int adj: graph.get(start)){
            if(!visited.contains(adj)){
                if(dfs_helper(adj,end,graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
























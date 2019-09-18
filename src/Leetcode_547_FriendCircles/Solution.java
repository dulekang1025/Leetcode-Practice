package Leetcode_547_FriendCircles;

//        - define visited array for each person, mark all ppl in one cycle visited using dfs
//        - traverse the he specific row, if get 1, traverse the corresponding row of that column #
//        since 2's friend is considered indirect friend of 1
//        - once finishing visit a 1 cycle, increment circle res

//题解：声明一个visited，用于记录遍历过的结点。
// 每次dfs找到一个原矩阵为1的位置（除了对角线），就把这个位置的列数变成行数再dfs，
// 如果是在同一个圈里，最终会绕回已经遍历过的行，visited为true，return 0；
// 如果不是同一个圈，则增加1。（mat[i][j]==1这个判断相当于i的邻接点，深度优先遍历）

public class Solution {
    public int findCircleNum(int[][] M) {
        boolean visited[] = new boolean[M.length];
        int cycle = 0;
        for(int i = 0; i < M.length; i ++){
            if(!visited[i]){
                cycle++;
                visited[i] = true;
                // 看dfs一次下去能visited多少个节点，一次dfs就是一个连通分量
                dfs(M, visited, i);//dfs to mark all ppl in the cycle visited
            }
        }
        return cycle;
    }
    public void dfs(int[][] M, boolean[] visited, int i){
        for(int j = 0; j < M[0].length; j++){//no return case here!!
            if(!visited[j] && M[i][j] == 1){
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}

//public class Solution {
//    public int findCircleNum(int[][] M) {
//        int[] visited = new int[M.length];
//        int res = 0;
//        for(int i = 0; i < M.length; i++){
//            if(visited[i] == 0){
//                res++;
//                dfs(M,i,visited);
//            }
//        }
//        return res;
//    }
//    public void dfs(int[][] M, int i, int[] visited){
//        visited[i] = 1;  //Set current node to 1 as visited
//        for(int j = 0; j < M.length; j++){
//            if(M[i][j] == 1 && visited[j] == 0){  // i and j is friend and j is not visited
//                dfs(M,j,visited);
//            }
//        }
//
//    }
//}
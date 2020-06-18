package Leetcode_1366_Rank_Teams_by_Votes;

import java.util.*;

class Solution {
    public static String rankTeams(String[] votes) {
        if(votes.length == 1) return votes[0];
        Map<Character, int[]> map = new HashMap<>();
        for(String vote : votes){
            for(int i = 0; i < vote.length(); i++){
                int[] rank = map.getOrDefault(vote.charAt(i), new int[26]);
                rank[i]++;
                map.put(vote.charAt(i), rank);
            }
        }
        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (v1, v2) -> {
            int[] rank1 = v1.getValue();
            int[] rank2 = v2.getValue();
            for(int i = 0; i < 26; i++){
                if(rank1[i] != rank2[i]){
                    return rank2[i] - rank1[i];
                }
            }
            return v1.getKey().compareTo(v2.getKey());
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, int[]> entry : list){
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] in1 = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(rankTeams(in1));
    }
}

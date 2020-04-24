package Leetcode_957_Prison_Cells_After_N_Days;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> map = new HashMap<>();   // state : i
        int[] ans;
        for(int i = 0; i < N; i++){
            int[] temp = new int[cells.length];
            int state = 0;
            for(int j = 1; j < cells.length - 1; j++){
                temp[j] = (cells[j-1] ^ cells[j+1]) == 0 ? 1 : 0;
                state = state | (temp[j] << j);
            }
            if(map.containsKey(state)){
                int pattern = i - map.get(state);
                return prisonAfterNDays(cells, N % pattern); // think again
            }
            map.put(state, i);
            cells = temp;
        }
        return cells;
    }
}

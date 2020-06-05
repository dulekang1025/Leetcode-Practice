package Problems_from_other_platform;

import java.util.Arrays;

public class MaximumOverlappingIntervals {
    //Maximum number of overlapping intervals
    // There is a party that records guests' arriving time and leaving time
    // Find out the maximum number of people that stays in the party at the same time;
    // Input:    arri  [] = {1, 2, 9, 5, 5}
    //           exit  [] = {4, 5, 12, 9, 12}
    public int maxIntervals(int[] arri, int []leav){
        Arrays.sort(arri);
        Arrays.sort(leav);
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int arrive = 0;
        // arri will be finished first. Once arri is finished, there's no need to
        // visited the rest of leav, because the number of people will not increase.
        while(i < arri.length && j < leav.length){
            if(arri[i] <= leav[j]){
                arrive++;
                i++;
                max = arrive > max ? arrive : max;
            }else{
                arrive--;
                j++;
            }
        }
        return max;
    }
}

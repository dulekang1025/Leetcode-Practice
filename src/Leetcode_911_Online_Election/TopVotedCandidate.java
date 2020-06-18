package Leetcode_911_Online_Election;

class TopVotedCandidate {

    int[] cur;
    int[] p;
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        p = persons;
        time = times;
        cur = new int[persons.length];
        int max = 0;
        int user = -1;
        int[] count = new int[5001];
        for(int i = 0; i < p.length; i++){
            if(++count[p[i]] >= max){
                max = count[p[i]];
                user = p[i];
            }
            cur[i] = user;
        }
    }

    public int q(int t) {
        int low = 0, high = time.length, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(time[mid] >= t)
                high = mid;
            else
                low = mid + 1;
        }
        //System.out.println(time[low]);
        int index = 0;
        if(low == time.length){
            index = time.length - 1;
        }else if(low == 0){
            index = 0;
        }else if(t != time[low]){
            index = low - 1;
        }else{
            index = low;
        }
        return cur[index];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

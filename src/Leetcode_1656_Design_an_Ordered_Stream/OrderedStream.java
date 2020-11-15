package Leetcode_1656_Design_an_Ordered_Stream;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    String[] arr;
    int p = 1;

    public OrderedStream(int n) {
        arr = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        arr[id] = value;
        if(p == id){
            while(p < arr.length && arr[p] != null){
                res.add(arr[p]);
                p++;
            }
        }
        return res;
    }
}

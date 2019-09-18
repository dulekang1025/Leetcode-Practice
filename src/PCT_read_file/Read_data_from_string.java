package PCT_read_file;

import java.util.ArrayList;
import java.util.Scanner;

public class Read_data_from_string {
//     2
//     3,3 4,4 5,5
//     5,6 6,7 7,8 8,9
    // 将上面的坐标读出来

    public static void main(String[] argv){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        String no = scan.nextLine();
        ArrayList<String[]> s_data = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = scan.nextLine();
            String[] a =  s.split(" ");
            s_data.add(a);
        }
        for(String a[] : s_data){
            for(String b : a)
            System.out.println(b);
        }

    }

}

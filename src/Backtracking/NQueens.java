package Backtracking;

// 8 queens problem, use backtracking
public class NQueens {

    public int[][] mat = new int[8][8];
    public int res_num = 0;

    public static void main(String[] argv){
        NQueens nq = new NQueens();
        nq.sreach(0);

    }

    public boolean check(int row, int col){
        if(row == 0) return true;
        int i,j;

        // check up
        i = row;
        while(i>0){
            if(mat[i-1][col] == 1) return false;
            i--;
        }

        //check oblique down
        i = row;
        j = col;
        while(i>0 && j>0){
            if(mat[i-1][j-1]==1) return false;
            i--;
            j--;
        }

        //check oblique up
        i = row;
        j = col;
        while(i>0 && j<7)
        {
            if(mat[i-1][j+1]==1) return false;
            i--;
            j++;
        }
        return true;
    }

    public void output(){
        int i,j;
        res_num++;
        System.out.println(res_num + ": ");
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++){
                System.out.print(mat[i][j] + " ");
                //mat[i][j] = 0; // clear
            }
            System.out.println();
        }

    }

    public void sreach(int row){
        int j; // col
        for(j=0;j<8;j++){
            mat[row][j] = 1;
            if(check(row,j)){
                if(row==7) output();
                else sreach(row+1);
            }
            mat[row][j] = 0;
        }
    }
}

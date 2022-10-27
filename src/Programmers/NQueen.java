package Programmers;
import java.util.*;

public class NQueen {
    static int cnt=0;
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    static public int solution(int n) {

        int [][] board = new int [n][n];
        dfs(board,0,n);
        return cnt;
    }

    static public void dfs(int [][]board, int depth, int n){
        System.out.println();
        System.out.println("start dfs "+depth);
        if( depth == n){
            System.out.println("finish");
            cnt++;
            return;
        }

        for( int i=0; i< n; i++){
            for( int j =0; j<n; j++){
                if(board[i][j] !=0) continue;

                int [][] nBoard = board;

                nBoard[i][j] =1;
                System.out.print(i+" "+j+"   ");

                for(int k=0; k<n; k++){
                    nBoard[k][j] =2;
                    nBoard[i][k] =2;
                    System.out.print("("+k+","+j+")  ");
                    System.out.print("("+i+","+k+")  ");

                }

                int x=i-1;
                int y= j-1;
                while (x >= 0 && y >= 0){
                    System.out.print("("+x+","+y+")  ");
                    if(nBoard[x][y] == 0) nBoard[x][y] = 2;
                    x--;
                    y--;
                }

                x= i+1;
                y=j+1;
                while (x < n && y < n) {
                    System.out.print("("+x+","+y+")  ");
                    nBoard[x][y] = 2;
                    x++;
                    y++;
                }

                dfs(nBoard, depth+1,n);
            }
        }
    }
}

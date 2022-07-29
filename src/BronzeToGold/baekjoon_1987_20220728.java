package BronzeToGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2022-07-28
알파벳
https://www.acmicpc.net/problem/1987

 */
public class baekjoon_1987_20220728 {
    public static int R, C;
    public static int count =0;
    public static int [] dx = {-1,1,-0,0};
    public static int [] dy = {0,0,-1,1};
    public static char [][] board ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        R =Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char [R][C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = line.charAt(j);
            }
        }
        boolean [] alpaCheck =new boolean[26];

        dfs(0,0,0,alpaCheck);
        System.out.println(count);
    }
    public static void dfs (int x, int y, int depth, boolean[]alpaCheck){
        if (alpaCheck[board[x][y]-65]){
            count = Math.max(count, depth);
            return;
        }

        alpaCheck[board[x][y]-65] = true;

        for(int i=0; i<4; i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            if(nx<0 ||ny<0 || nx>=R || ny>=C) continue;
            dfs(nx,ny,depth+1,alpaCheck);
        }
        alpaCheck[board[x][y]-65] = false;

    }
}
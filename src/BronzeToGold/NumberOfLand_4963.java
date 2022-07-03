package BronzeToGold;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
섬의 개수
https://www.acmicpc.net/problem/4963

아니 대각선도 포함이라녀 진짜 빡치네
//시간 남으면 dfs로도 풀자
 */
public class NumberOfLand_4963 {
    static class location{
        int x; int y;
        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int w,h;
    static int [][]earth;
    static ArrayList<Integer> results = new ArrayList<>();
    static int[]dx = {-1,1,0,0,-1,1,-1,1};
    static int[]dy = {0,0,-1,1,-1,-1,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st =new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w ==0 & h == 0) break;

            earth  = new int [h][w];

            int cnt =0;
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    earth[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(earth[i][j] == 0) continue;
                    bfs(i,j);
                    cnt++;
                }
            }
            results.add(cnt);
        }

        for(int r : results){
            bw.write(r+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static public void bfs (int startx, int starty){
        Queue<location>queue = new LinkedList<location>();
        queue.add(new location(startx,starty));
        earth[startx][starty] = 0;
        while(!queue.isEmpty()) {
            location cur = queue.remove();
            //팔방으로 모두 체크
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if(earth[nx][ny] == 0) continue;
                earth[nx][ny] = 0;

                queue.add(new location(nx, ny));
            }
        }
    }
}
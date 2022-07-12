package BronzeToGold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
2022-07-11
영역 구하기
https://www.acmicpc.net/problem/2583

0. 모눈 종이의 크기와 각 직사각형의 위치를 입력 받는다.
1. 직사각형의 위치는 1 빈 공간은 0으로
2. dfs를 돌리면서 해당 빈 공간의 크기를 입력 및 갯수를 카운트한다.
 */
public class FindArea_2538_220712 {
    static int m,n,k;
    static int [][] papers;
    static int cnt;

//    왜자꾸 오류가 나는가 했더니, TreeSet은 중복 제거네ㅠㅠ
//    static TreeSet <Integer> results =new TreeSet<>();
    static ArrayList<Integer> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        papers= new int [m][n];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for(int y=sy; y<ey; y++){
                for(int x=sx; x<ex; x++){
                    papers[y][x] = 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(papers[i][j] != 0)continue;
                cnt++;
                results.add(dfs(i,j,1));
            }
        }
        Collections.sort(results);
        bw.write(cnt+"\n");
        results.forEach((r)-> {
            try {
                bw.write(r+" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
        bw.close();
        br.close();
    }
    static public int dfs(int x, int y, int zone){
        if(x<0 || x>=m || y<0 || y>=n) return 0;
        if(papers[x][y] !=0) return 0;
        papers[x][y] =1;
        zone += dfs(x-1,y,1);
        zone +=dfs(x+1,y,1);
        zone +=dfs(x,y-1,1);
        zone +=dfs(x,y+1,1);
        return zone;
    }
}
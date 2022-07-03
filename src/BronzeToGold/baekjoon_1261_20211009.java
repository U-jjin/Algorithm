package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class baekjoon_1261_20211009 {
    static class loc implements Comparable<loc>{
        int n,m;
        int cnt;
        public loc(int n, int m,int cnt ){
            this.n = n;
            this.m = m;
            this.cnt =cnt;
        }

        @Override
        public int compareTo(loc o) {
            return this.cnt-o.cnt;
        }
    }
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int N,M;
    static boolean [][] visited;
    static char [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char [N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }
        System.out.print(bfs());
    }
    static public int bfs(){

        PriorityQueue<loc> queue =new PriorityQueue<>();
        queue.add(new loc(0,0,0));
        visited[0][0] =true;
        while(true){
            loc now = queue.poll();
            if (now.n == N-1 && now.m == M-1) {
                return now.cnt;
            }
            for(int i=0; i<4; i++){
                int nx = now.n+dx[i];
                int ny = now.m+dy[i];

                if(nx<0 || ny<0 || nx>=N||ny>=M|| visited[nx][ny]) continue;

                int check;
                if( map[nx][ny] =='1') check=now.cnt+1;
                else check =now.cnt;

                visited[nx][ny] =true;
                queue.add(new loc(nx,ny,check));
            }
        }
    }
}

/*
import java.io.*;
import java.util.*;
class Main {
    static class loc{
        int n,m;
        public loc(int n, int m ){
            this.n = n;
            this.m = m;
        }
    }
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int N,M;
    static int [][] visited;
    static char [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new int [N][M];
        map = new char [N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }
        System.out.print(bfs());
    }
    static public int bfs(){

        Queue<loc> queue =new LinkedList<>();
        queue.add(new loc(0,0));
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            loc now = queue.poll();

            for(int i=0; i<4; i++){
                int nx = now.n+dx[i];
                int ny = now.m+dy[i];

                if(nx<0 || ny<0 || nx>=N||ny>=M) continue;

                int check;
                if( map[nx][ny] =='1') check= visited[now.n][now.m]+1;
                else check =visited[now.n][now.m];

                if(visited[nx][ny]!=0){
                        visited[nx][ny] = Math.min(check,visited[nx][ny]);
                        continue;
                }

                visited[nx][ny] =check;
                queue.add(new loc(nx,ny));
            }
        }
        return --visited[N-1][M-1];
    }
}

 */
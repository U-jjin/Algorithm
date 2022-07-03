package com.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class baekjoon_1967_20211009 {
    static class Node{
        int node, dist;
        public Node(int node, int dist){
            this.node =node;
            this.dist = dist;
        }
    }
    static ArrayList<ArrayList<Node>> list =new ArrayList<ArrayList<Node>>();
    static boolean[] visited;
    static int n, mxdist,mxidx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        if( n==1) {
            System.out.print(0);
            return;
        }

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens()) break;
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
           list.get(p).add(new Node(c,d));
           list.get(c).add(new Node(p,d));
           if(c == n) break;
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[n+1];
        visited[mxidx] = true;
        dfs(mxidx,0);

       bw.write(mxdist);
       bw.flush();
       bw.close();
       br.close();

    }
    static public void dfs(int i,int c){
        if(mxdist<c){
            mxdist = c;
            mxidx = i;
        }
        for(Node n: list.get(i)){
            if(!visited[n.node]){
                visited[n.node] = true;
                dfs(n.node,c+n.dist);
            }
        }
    }
}

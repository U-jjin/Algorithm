package BronzeToGold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2022-07-04
촌수계산
https://www.acmicpc.net/problem/2644

 */

public class Chonsu_2644 {

    static int n,m;
    static LinkedList<Integer> [] family;
    static int [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        family = new LinkedList[n + 1];
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            family[i] = new LinkedList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family[parent].add(child);
            family[child].add(parent);
        }

        bfs(t1,t2);

        if(visited[t2] == 0) System.out.println(-1);
        else System.out.println(visited[t2]-1);  //본인을 1부터 시작해서 하나 빼기
    }
    public static void bfs(int start, int target){
        Queue<Integer> queue =new LinkedList<>();
        visited[start] = 1;
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.remove();
            //System.out.println("Im "+current+" chonsu:"+visited[current]);

            if(current == target) break;
            if(family[current].isEmpty()) continue;


            for(int f: family[current]){
                if(visited[f] !=0) continue;
                visited[f] = visited[current]+1;
                queue.add(f);
            }

        }
    }
}
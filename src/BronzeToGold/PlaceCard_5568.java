package BronzeToGold;

import java.io.*;
import java.util.HashSet;

/*
 카드 놓기
 https://www.acmicpc.net/problem/5568
 */
public class PlaceCard_5568 {
    static int n, k;
    static String [] list;
    static HashSet<Integer> results = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        list = new String [n];
        boolean[] visited = new boolean[n];
        String []output = new String [k];

        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }

        //순열로 n개의 카드중에 k개 뽑기
        permutation(visited, output, 0);

        System.out.println(results.size());
    }

    static public void permutation(boolean[] visited, String[] output,int depth) {
        if (depth == k) {
            String str ="";
            for(String s: output){
                str+=s;
            }
            //만들어진 숫자 중에 중복을 제외하기 위해 hashset에 저장.
           results.add(Integer.parseInt(str));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth]= list[i];
                permutation(visited, output, depth+1);
                visited[i] = false;
            }
        }
    }
}
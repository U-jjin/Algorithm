package BronzeToGold;

import java.io.*;

//1,2,3 더하기
// https://www.acmicpc.net/problem/9095


/*
DP 가 세상에서 제일 시러
1 -> 1개
2 -> 2개
3 -> 4개
4 -> 7개
5 -> 13개
6 -> 24개
f(n) = f(n-1)+f(n-2)+f(n-3)
 */

public class Plus123_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int [] results = new int [12];
        results[1] = 1;
        results[2] = 2;
        results[3] = 4;
        for(int i=4; i<=11; i++){
            results[i] = results[i-1]+results[i-2]+results[i-3];
        }

        for(int i=0; i<num; i++){
            int check = Integer.parseInt(br.readLine());
            bw.write(Integer.toString(results[check])+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
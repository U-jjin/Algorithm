package AlgorithmForSamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2022-07-28
퇴사
https://www.acmicpc.net/problem/14501

 */
public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] T = new int [N+1];
        int [] P = new int [N+1];
        int [] dp = new int [N+1];
        int result = 0;

        for(int i=1; i<=N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; i--){
            if(T[i]+i<=N+1) dp[i]=P[i];
            for(int j=i+T[i]; j<=N; j++){
                 dp[i]= Math.max(P[i]+dp[j],dp[i]);
            }
            result = Math.max(dp[i],result);
        }

        System.out.println(result);
    }
}
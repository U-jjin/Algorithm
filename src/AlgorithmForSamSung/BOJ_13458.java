package AlgorithmForSamSung;

import java.io.*;
import java.util.StringTokenizer;

/*
삼성 코테 준비
 시험감독
 https://www.acmicpc.net/problem/13458
 */
public class BOJ_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] A = new int [N];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long sum =N;

        for(int a : A){
            int remain = a-B;
            if(remain <=0) continue;
            sum +=((remain%C == 0)? remain/C : (remain/C +1));
        }
        System.out.println(sum);
    }
}
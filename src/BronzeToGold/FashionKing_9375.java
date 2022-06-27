package BronzeToGold;

import java.io.*;
import java.util.HashMap;

/*
 패션왕신해빈
 https://www.acmicpc.net/problem/9375
 */
public class FashionKing_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        int [] results = new int [testcase];

        for(int i=0; i<testcase; i++){
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> hashMap = new HashMap<>();
            results[i] = 1;
            //옷 타입 별로 갯수 세기
            for(int j=0; j<n; j++){
                String [] type= br.readLine().split(" ");
                if(!hashMap.containsKey(type[1])) hashMap.put(type[1],1);
                else hashMap.put(type[1], hashMap.get(type[1])+1);
            }
            // 안입는것 포함해서 v+1 곱하기 팩토리얼
            for(int v: hashMap.values()){
             results[i] *=(v+1);
            }
            //알몸 제외
            results[i] --;
        }
        for(int r:results){
            System.out.println(r);
        }
    }
}
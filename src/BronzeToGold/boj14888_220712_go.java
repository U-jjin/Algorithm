package BronzeToGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2022-07-12
연산자 끼워넣기
https://www.acmicpc.net/problem/14888

시간 초과 발생
 - 연산자를 하나하나 입력 받지 말고 연산자 갯수를 줄여가면서 dfs 돌려보자
 - dfs 돌릴 때 최댓값 최소값 체크도 할 수 있도록 .
 */
public class boj14888_220712_go {
    static int n;
    static long max = Long.MIN_VALUE ;
    static long min = Long.MAX_VALUE;
    static int [] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        int [] operators = new int [4];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(operators,nums[0],1);
        System.out.print(max+"\n"+min);

    }

    static void dfs(int []operators,long curnum, int idx) {
        if(idx == n) {
            max = Math.max(curnum,max);
            min = Math.min(curnum,min);
            return;
        }

        for(int i=0; i<4; i++){
            if(operators[i] == 0) continue;
            operators[i] --;
            dfs(operators,cal(curnum,nums[idx],i),idx+1);
            operators[i] ++;
        }
    }

    static public long cal(long x, long y, int oper){
        switch (oper){
            case 0:
                return x+y;
            case 1:
                return x-y;
            case 2:
                return x*y;
            case 3:
                if(x<0) {
                    return -1*(Math.abs(x)/y);
                }else return x/y;
            default: return 0;
        }
    }
}
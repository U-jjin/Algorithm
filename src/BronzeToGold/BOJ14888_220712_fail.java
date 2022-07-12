package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BOJ14888_220712_fail {
    static ArrayList<String> operaters = new ArrayList<>();
    static String operlist ="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());
        int [] nums = new int[n];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operlist += "+".repeat(Integer.parseInt(st.nextToken()));
        operlist += "-".repeat(Integer.parseInt(st.nextToken()));
        operlist += "*".repeat(Integer.parseInt(st.nextToken()));
        operlist += "%".repeat(Integer.parseInt(st.nextToken()));

        perm( new char [n-1],new boolean [n-1],0,n);

        for(String o : operaters){
            long x = nums[0];
            for(int i=1; i< nums.length; i++){
                x = cal(x,nums[i],o.charAt(i-1));
            }
            if(x>max) max=x;
            if(x<min) min =x;
        }

        System.out.print(max+"\n"+min);

    }

    static void perm(char[] output, boolean[] visited, int cnt, int n) {
        if (cnt == n) {
            String result = new String(output);
            if(!operaters.contains(result)) operaters.add(result);
            return;
        }
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            output[cnt] =operlist.charAt(i);
            perm( output, visited, cnt + 1, n);
            visited[i] = false;
        }
    }

    static public long cal(long x, long y, char operator){
        switch (operator){
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '%':
                if(x<0) {
                    return -1*(Math.abs(x)/y);
                }else return x/y;
            default: return 0;
        }
    }
}
package com.practice;

import java.io.*;
import java.util.StringTokenizer;

class baekjoon_2884_strings {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) -45;

        if( m<0){
            h = --h<0? 23: h;
            m +=60;
        }
        System.out.print(h+" "+m);
    }
}

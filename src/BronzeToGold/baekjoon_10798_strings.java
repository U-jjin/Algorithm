package com.practice;

import java.io.*;
import java.util.ArrayList;

class baekjoon_10798_strings {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<char[]> list = new ArrayList<>();
        int max =0;
        for(int i=0; i<5; i++){
            String str = br.readLine();
            list.add(str.toCharArray());
            max = Math.max(max,str.length());
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<max; i++){
            for( int j=0; j<5; j++){
                if( list.get(j).length -1 >= i){
                    sb.append(list.get(j)[i]);
                }else continue;
            }
        }
        System.out.print(sb);
    }
}

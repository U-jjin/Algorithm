package com.practice;

import java.io.*;
import java.util.StringTokenizer;

class baekjoon_2490_strings {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for( int i=0; i<3; i++){
            int check = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                check += Integer.parseInt(st.nextToken());
            }
            if(check == 0) bw.append("D\n");
            else if(check == 1) bw.append("C\n");
            else if(check == 2) bw.append("B\n");
            else if(check == 3) bw.append("A\n");
            else if(check == 4) bw.append("E\n");
        }
        bw.flush();
        bw.close();
    }
}

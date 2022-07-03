package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class kakao_20211009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String [] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        HashMap<Integer,PriorityQueue<Integer>> pops = new HashMap<>();
        ArrayList<Integer> keylist =new ArrayList<>();
        String lang, job, career, food;
        int score;

        int n0, n1, n2, n3;
        for(String i : info){
            st = new StringTokenizer(i);
             lang = st.nextToken();
             job = st.nextToken();
             career = st.nextToken();
             food = st.nextToken();
             score = Integer.parseInt(st.nextToken());

            if(lang == "java") n0 = 1;
            else if(lang=="python") n0= 2;
            else n0 =3;

            if(job=="backend") n1 =1;
            else n1=2;

            if(career=="junior") n2 =1;
            else n2=2;

            if(food=="chicken") n3 =1;
            else n3=2;

            int type =n0+n1*10+n2*100+n3*1000;

            if(!pops.containsKey(type)){
                pops.put(type,new PriorityQueue<Integer>());
            }
            pops.get(type).add(score);
        }

        pops.keySet().toArray();

        for( String q : query){
            st = new StringTokenizer(q);
            lang = st.nextToken();
            job = st.nextToken();
            career = st.nextToken();
            food = st.nextToken();
            score = Integer.parseInt(st.nextToken());

            if(lang == "java") n0 = 1;
            else if(lang=="python") n0= 2;
            else if(lang =="cpp") n0 =3;
            else n0=4;

            if(job=="backend") n1 =1;
            else if(job=="frontend")n1=2;
            else n1=3;

            if(career=="junior") n2 =1;
            else if(career=="senior") n2=2;
            else n2=3;

            if(food=="chicken") n3 =1;
            else if(food=="pizza")n3=2;
            else n3= 3;

            for( int t : pops.keySet()){
            }
        }


    }
}
package BronzeToGold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    봄
       - 나무들이 각자의 나이만큼 양분을 먹는다.
       - 같은 칸에 여러 나무가 있을 경우에 나이가 작은 나무부터 먹는다
       - 나이만큼 못 ㅁ먹으면 죽는다.
   여름
       - 죽은 나무의 나이/2만큼 양뷴이 된다.
   가을
       - 나이가 5의 배수인 나무가 번식하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
   겨울
       - 각 땅에 A[r][c] 만큼 양분이 추가된다.

    K년 후에 땅에 살아 있는 나무의 갯수를 구하라


    1. K만큼 while 문을 돌린다.
            1. 땅을 돌면서 각자리의 나무 list 에 해당하는 만큼 양분을 배분.
                - 죽은 나무의 나이/2를 카운팅한다.
                - 나이가 5의 배수인 나무들을 카운팅한다.(죽으면X)
                - 해당 땅에 죽은 나무의 양분을 넣는다.
                - 번식할 나무의 갯수의 만큼 주면 땅에 나무를 추가해준다.
                - 땅에 양분을 넣어준다.

    2. 땅의 나무의 총 갯수를 센다.



 */

public class BOJ_16235 {
    static int  N,M,K;
    static HashMap<Integer,ArrayList<Integer>> treeMap;
    static int [][] A;
    static int [][] ground;

    static int []dx ={-1,-1,-1,0,0,1,1,1};
    static int []dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());  //땅의 크기
         M = Integer.parseInt(st.nextToken()); //나무의 갯수
         K = Integer.parseInt(st.nextToken());  // 년수
        // x좌표*100+y 값을 key로 해당 queue에 나무 정보 넣기.
        treeMap =new HashMap<>();

       A =new int[N+1][N+1]; ////땅의 추가될 양분 리스트
       ground = new int [N+1][N+1]; // 실제 땅의 양분


        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                ground[i][j] = 5;  //초기호ㅏ
                treeMap.put(i*100+j,new ArrayList<>());
            }
        }

        //나무 초기화 리스트
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            int age =Integer.parseInt(st.nextToken());

            treeMap.get(x*100+y).add(age);
        }

        /*
                1. 땅을 돌면서 각자리의 나무 list 에 해당하는 만큼 양분을 배분.
                - 죽은 나무의 나이/2를 카운팅한다.
                - 나이가 5의 배수인 나무들을 카운팅한다.(죽으면X)
                - 해당 땅에 죽은 나무의 양분을 넣는다.
                - 번식할 나무의 갯수의 만큼 땅에 나무를 추가해준다.
                - 땅에 양분을 넣어준다

        */
        for(int year=0; year<K; year++) {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
//                    System.out.println(r + " " + c + " ground "+ground[r][c]);
                    int key = r * 100 + c;

                    if(treeMap.get(key).isEmpty()) continue;

                    Collections.sort(treeMap.get(key));
                    //봄
                    int energy = Spring(treeMap.get(key), r, c);
//                    System.out.println("add energy: "+energy);

                    //여름
                    ground[r][c] +=energy;
                }
            }

            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    //가을
                    Fall(treeMap.get(r*100+c),r,c);
                    //겨울
                    ground[r][c] +=A[r][c];
                }
            }

        }

        int cnt =0;
        for(int key : treeMap.keySet()){

            cnt += treeMap.get(key).size();
        }

        System.out.println(cnt);


    }

    static public int Spring(ArrayList<Integer> treeList, int r, int c){
        ArrayList<Integer> newTree =new ArrayList<>();
        int energy =0;
        for( int age : treeList){
            if (ground[r][c] < age) {
                energy += age / 2;
                continue;
            }
            ground[r][c] -= age;
            newTree.add(age+1);
//            System.out.println("plus age:"+ (age+1));
        }
        treeMap.remove(r*100+c);
        treeMap.put(r*100+c,newTree);
//        System.out.print("new treeList: ");
//        for( int t : newTree){
//            System.out.print(t+" ");
//        }
//        System.out.println();
//        System.out.println("final spring energy: "+ground[r][c]);
        return energy;
    }

    static public void Fall(ArrayList<Integer> treeList, int r, int c){
        int baby =0;
        for(int age : treeList){
            if(age%5==0){
                baby ++;
            }
        }
//        System.out.println("baby cnt:"+baby);

        for(int i=0; i<8; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            if( nr<1 || nc<1 || nc>N || nr>N) continue;
//            System.out.println(nr+ " "+nc +" plus baby");
            for(int b=0; b<baby; b++){

                treeMap.get(nr*100+nc).add(1);
            }
        }
    }
}

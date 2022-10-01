package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class n2Array {

    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();
        int n =4;
        long  left = 7;
        long right =14;

        int [] answer = new int[(int)(right-left+1)];
        ArrayList<Integer> arrayList = new ArrayList<>();

        //시작 끝 위치 찾기
        int startx, starty;
        if((int)(left+1)%n == 0){
            startx = (int)(left+1)/n;
            starty = n;
        }else{
            startx = (int)(left+1)/n+1;
            starty = (int)left%n;
        }


        int endx, endy;
        if((int)(right+1)%n == 0){
            endx =(int)(right+1)/n;
            endy = n;
        }else{
            endx = (int)(right+1)/n+1;
            endy = (int)right%n;
        }

        System.out.println("("+startx+","+starty+") ("+endx+","+endy+")");


        //첫행 끝행 더해주기
        for(int i = starty ; i<=n ;i++){
            arrayList.add(findNum(startx,i));
        }
        for(int i=startx+1; i<=endx-1; i++){
            for(int j = 1; j<=n; j++){
                arrayList.add(findNum(i,j));
            }
        }
        for(int i=1; i<=endy; i++){
            arrayList.add(findNum(endx,i));
        }


        for(int a : arrayList){
            System.out.print(a+" ");
        }

    }

    static public int findNum(int x, int y){
        if(x>=y) return x;
        else return y;
    }
}

package BronzeToGold;


/*
x가 빙고가 있을 때,
 - o의 빙고 도 있으면 불가능
 - x의 갯수가 o의 갯수보다 1개 많아야 가능

o의 빙고가 있을 때, x의 갯수가 o의 갯수와 같아야 한다.
x의 빙고가 없어야 한다.

1,2,번도 아닐 때는 x+o의 갯수가 9여야 한다.



 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7682 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int xcnt;
        int ocnt;
        while(true){
//            System.out.println();
            String str = br.readLine();
            if( str.equals("end")) break;

            String [] bingo = str.split("");

            xcnt =(int) Arrays.stream(bingo).filter(b -> b.equals("X")).count();
            ocnt =(int) Arrays.stream(bingo).filter(b -> b.equals("O")).count();

            int xBingo = findBingo(bingo,"X");
            int oBingo = findBingo(bingo,"O");

//            System.out.println(xcnt+ " "+ocnt+" "+xBingo+" "+oBingo);

            if(xBingo>0 && oBingo ==0 &&xcnt==ocnt+1){
                System.out.println("valid");
                continue;
            }
            if(xBingo ==0 && oBingo>0 && xcnt == ocnt ){
                System.out.println("valid");
                continue;
            }

            if(xBingo ==0 && oBingo ==0 && xcnt+ocnt == 9 && xcnt >ocnt){
                System.out.println("valid");
                continue;
            }

            System.out.println("invalid");
        }


    }
    public static int findBingo(String[]bingo, String piece ){
        int cnt =0;

        if(bingo[0].equals(piece) && bingo[1].equals(piece) && bingo[2].equals(piece)) cnt++;
        if(bingo[3].equals(piece) && bingo[4].equals(piece) && bingo[5].equals(piece)) cnt++;
        if(bingo[6].equals(piece) && bingo[7].equals(piece) && bingo[8].equals(piece)) cnt++;
        if(bingo[0].equals(piece) && bingo[3].equals(piece) && bingo[6].equals(piece)) cnt++;
        if(bingo[1].equals(piece) && bingo[4].equals(piece) && bingo[7].equals(piece)) cnt++;
        if(bingo[2].equals(piece) && bingo[5].equals(piece) && bingo[8].equals(piece)) cnt++;
        if(bingo[0].equals(piece) && bingo[4].equals(piece)&& bingo[8].equals(piece)) cnt++;
        if(bingo[2].equals(piece) && bingo[4].equals(piece) && bingo[6].equals(piece)) cnt++;

        return cnt;
    }
}

package BronzeToGold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2831 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> upMan =new ArrayList<>();
        ArrayList<Integer> downMan =new ArrayList<>();
        ArrayList<Integer> upWoman =new ArrayList<>();
        ArrayList<Integer> downWoman =new ArrayList<>();

        StringTokenizer  men = new StringTokenizer(br.readLine());
        StringTokenizer  women = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int mheight = Integer.parseInt(men.nextToken());
            int wheight = Integer.parseInt(women.nextToken());

            if(mheight <0)  downMan.add(mheight*-1);
            else upMan.add(mheight);

            if(wheight <0)  downWoman.add(wheight*-1);
            else upWoman.add(wheight);
        }
        Collections.sort(upMan);
        Collections.sort(upWoman);
        Collections.sort(downMan);
        Collections.sort(downWoman);

        //키가 큰 남자와 작은 여자
        int w =0;
        int m = 0;
        int answer = 0;
        while(w<upWoman.size() && m<downMan.size()){
            int man = downMan.get(m);
            int woman = upWoman.get(w);

            if( man <=woman){
                m ++;
                continue;
            }

            answer ++;
            w++;
            m++;
        }

        w=0;
        m=0;

        while(w<downWoman.size() && m<upMan.size()){
            int man = upMan.get(m);
            int woman = downWoman.get(w);

            if( man >= woman){
                w++;
                continue;
            }

            answer ++;
            w++;
            m++;
        }

        System.out.println(answer);


    }


}

package BronzeToGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
     1. 본부에서 출발하여 1번부터 마지막까지 배송
     2. 발신 착신 박스마다 적혀있으며, 갯수도 안다.
     3. 트럭 용량 존재

     트럭은 지나온 마을로 되돌아가지 않는다.


 */
public class BOJ_8980 {
    static class Box implements Comparable<Box>{
        int to;
        int from;
        int capa;

        public Box(int from, int to, int capa){
            this.to =to;
            this.from =from;
            this.capa = capa;
        }
        @Override
        public int compareTo(Box o) {
            if(this.to == o.to){
                if(this.from == o.from) return this.capa-o.capa;
                return  this.from -o.from;
            }
            return this.to -o.to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Set<Box> boxList =new TreeSet<Box>();
        int [] town = new int [N];
        Arrays.fill(town,C);

        for(int i=0; i<M;i ++){
            st =new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int capa = Integer.parseInt(st.nextToken());
            boxList.add(new Box(from,to,capa));
        }

        int answer = 0;
        //해당 박스 도착지까지의 마을의 capa를 줄인다.
        for(Box box : boxList) {
            // 최종목적지까지 갈 수 있는 최대 박스 갯수를 구환다.
            int maxBox = Integer.MAX_VALUE;
            for (int i = box.from; i < box.to; i++) {
                maxBox = Math.min(maxBox, town[i]);
            }

            if (maxBox >= box.capa) {
                for (int i = box.from; i < box.to; i++) {
                    town[i] -= box.capa;
                }
                answer += box.capa;
            } else {
                for (int i = box.from; i < box.to; i++) {
                    town[i] -= maxBox;
                }
                answer += maxBox;
            }
        }


        System.out.println(answer);


    }
}

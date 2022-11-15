package BronzeToGold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
말 위에 다른 말을 올릴 수 있다.
체스판은 각각 흰색 빨간색 파란색중 하나

치스말 위에 말 K개를 놓고 시작
말 -> 1~k번 이동방향 고정
턴당 1~k 말 이동
말 이동할 때 위에 얹힌 말도 같이 이동
말이 4개 이상 쌓이면 종료

흰색 칸 : 엎인 거 위에 엎히기
빨간 칸 : A번 말위의 모든 의 순서를 변경 -> ADFG + ECB  : ECBGFDA
파란 칸 : A번 말의 이동방향 반대로 한칸 이동. 만약 이동한 칸이 파란색인 경우는, 방향만 바꾸기
체스판을 벗어나는 경우는 파란색과 같은 경우우 */
public class BOJ_17780 {

    static public class Piece{
        int x;
        int y;
        int direction;
        public Piece(int x,int y, int direction){
            this.x= x;
            this.y = y;
            this.direction = direction;
        }
    }
    static int [][]board ;
    static ArrayList<Integer>[][] location;
    static ArrayList<Piece> chesses;
    static int n,k;

    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    public static void main(String[] args)throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board =  new int [n][n];
        location = new ArrayList[n][n];

        for(int i=0; i<n; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                location[i][j] = new ArrayList<>();
            }
        }
        chesses = new ArrayList<>();
        chesses.add(new Piece(0,0,0));
        for( int i=1; i<=k; i++){
            st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            chesses.add(new Piece(x,y,d));
            location[x][y].add(i);
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(location[i][j].toString()+"   ");
//            }
//            System.out.println();
//        }

        System.out.println(solution());

    }

    static public int solution(){
        int turn =1;
        while(true){
            if(turn>1000){
                return -1;
            }
            for(int i=1; i <=k ; i++){
                //현재턴 말 꺼내기
                Piece chess =chesses.get(i);
                int x = chess.x;
                int y = chess.y;
                int d = chess.direction;

                //제일 밑의 말이 아니라면 continue
                if(location[x][y].indexOf(i) !=0) continue;

                int nx = x+dx[d];
                int ny = y+dy[d];
                //이동하려는 칸이 막다른 곳일 때,
                if(nx<0 || ny<0 || nx>=n || ny>=n || board[nx][ny] ==2){
                    //방향을 바꾸고, 바꾼 방향으로 이동하려는 위치도 재설정
                    d = reverseDir(d);
                    chesses.get(i).direction = d;
                    nx = x+dx[d];
                    ny = y+dy[d];

                    //방향을 바꾼뒤에도 이동하려는 칸이 파란색 또는 막힌 곳 이라면, 방향만 바꾸고 종료.
                    if(nx<0 || ny<0 || nx>=n || ny>=n || board[nx][ny] ==2){
                        continue;
                    }
                }

                //이동하려는 칸이 빨간색일때 역순정렬 해주기
                if(board[nx][ny] == 1){
                    Collections.reverse(location[x][y]);
                }

                //이동시켜주기
                for(int index : location[x][y]){
                    chesses.get(index).x =nx;
                    chesses.get(index).y = ny;
                }

                location[nx][ny].addAll(location[x][y]);
                location[x][y].clear();

                if(location[nx][ny].size()>=4){
                    return turn;
                }

//                for(int l=0; l<n; l++){
//                    for(int j=0; j<n; j++){
//                        System.out.print(location[l][j].toString()+"   ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }

            turn++;
        }
    }

    static public int reverseDir(int d){
        if( d == 0){
            return 1;
        }else if(d==1){
            return 0;
        }else if(d==2){
            return 3;
        }else{
            return 2;
        }
    }

}

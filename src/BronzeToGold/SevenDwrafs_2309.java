package BronzeToGold;

import java.io.*;
import java.util.*;
//일곱난쟁이
// https://www.acmicpc.net/problem/2309
/*
 9명의 드워프중에서 총 키-100의 합을 가진 두명의 드워프를 찾으면 됨.
 */
public class SevenDwrafs_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> dwarfs  = new ArrayList<>();
        int sum = -100;

        for(int i=0; i<9; i++){
            int n = Integer.parseInt(br.readLine());
            dwarfs.add(n);
            sum +=n;
        }

        Collections.sort(dwarfs);
        // 현재 드워프 d의 몸무게와 같은 다른 드워프를 찾음.
        // 몸무게가 겹쳐서 조회 될 수 있기 때문에 다른 드워프라는 조건을 추가.
        for(int d: dwarfs){
            if(dwarfs.contains(sum - d) && dwarfs.indexOf(d) != dwarfs.lastIndexOf(sum-d)){
                dwarfs.remove(dwarfs.indexOf(d));
                dwarfs.remove(dwarfs.indexOf(sum-d));
                break;
            }
        }

        for(int d:dwarfs){
            bw.write(Integer.toString(d)+'\n');
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
package BronzeToGold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
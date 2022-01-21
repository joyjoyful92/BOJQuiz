package joy.boj.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q3 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            int num = sc.nextInt();
            if ( !arr.contains(num) ) arr.add(num);
        }

        Collections.sort(arr);
        for ( int i = 0; i < arr.size(); i++ ) {
            System.out.print(arr.get(i) + " ");
        }
    }
}

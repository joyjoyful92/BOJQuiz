package joy.boj.test;

import java.util.Scanner;

public class q2 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for ( int i = 0; i < n; i++ ) {
            arr[i] = sc.nextInt();
        }

        int [] list = new int[12];
        list[1] = 1;
        list[2] = 2;
        list[3] = 4;

        for ( int i = 4; i < 12; i++ ) {
            list[i] = list[i - 1] + list[i - 2] + list[i - 3];
        }

        for ( int i = 0; i < n; i++ ) {
            System.out.println(list[arr[i]]);
        }
    }
}

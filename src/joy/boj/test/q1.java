package joy.boj.test;

import java.util.Scanner;

public class q1 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        String strNum = String.valueOf(number);

        int n1 = Integer.parseInt(String.valueOf(strNum.charAt(0)));
        int n2 = Integer.parseInt(String.valueOf(strNum.charAt(1)));
        int n3 = Integer.parseInt(String.valueOf(strNum.charAt(2)));
        int n4 = Integer.parseInt(String.valueOf(strNum.charAt(3)));
        int n5 = Integer.parseInt(String.valueOf(strNum.charAt(4)));

        int result = (int)(Math.pow(n1, 2) + Math.pow(n2, 2) +Math.pow(n3, 2) +Math.pow(n4, 2) +Math.pow(n5, 2));

        System.out.println(result%10);
    }
}

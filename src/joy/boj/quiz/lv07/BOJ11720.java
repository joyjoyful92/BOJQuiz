package joy.boj.quiz.lv07;

/*
<숫자의 합>
문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.
*/

import java.util.Scanner;

public class BOJ11720 {
    Scanner sc;
    int N;
    String str;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
        this.str = sc.next();
    }

    void getResult() {
        int res = 0;
        for ( int i = 0; i < this.N; i++ ) {
            res += Integer.parseInt(String.valueOf(this.str.charAt(i)));
        }

        System.out.println(res);
    }
}
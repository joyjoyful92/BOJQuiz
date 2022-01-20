package joy.boj.quiz.lv02;

/*
<두 수 비교하기>
문제
두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.

출력
첫째 줄에 다음 세 가지 중 하나를 출력한다.

A가 B보다 큰 경우에는 '>'를 출력한다.
A가 B보다 작은 경우에는 '<'를 출력한다.
A와 B가 같은 경우에는 '=='를 출력한다.

제한
-10,000 ≤ A, B ≤ 10,000
*/

import java.util.Scanner;

public class BOJ1330 {
    Scanner sc;
    int A, B;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.A = sc.nextInt();
        this.B = sc.nextInt();
    }

    void getResult() {
        String res = "==";
        if ( this.A < this.B ) {
            res = "<";
        } else if ( this.A > this.B ) {
            res = ">";
        }
        System.out.println(res);
    }
}

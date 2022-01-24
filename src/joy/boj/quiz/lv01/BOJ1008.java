package joy.boj.quiz.lv01;

/*
<A/B>
문제
두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
*/

import java.util.Scanner;

public class BOJ1008 {
    Scanner sc = new Scanner(System.in);
    int a, b;

    public void runQuiz() {
        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.a = sc.nextInt();
        this.b = sc.nextInt();
    }

    void getResult() {
        double result = (double) this.a / (double) this.b;
        System.out.println(result);
    }
}
package joy.boj.quiz.lv01;

/*
<A+B>
문제
두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A-B를 출력한다.
*/

import java.util.Scanner;

public class BOJ1001 {
    int A, B;

    public void runQuiz() {
        dataScan();
        getResult();
    }

    void dataScan() {
        // 입력, 문제에 없는 system.out 은 하지 말것
        Scanner sc = new Scanner(System.in);
        this.A = sc.nextInt();
        this.B = sc.nextInt();
        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void getResult() {
        System.out.println(this.A - this.B);
    }
}

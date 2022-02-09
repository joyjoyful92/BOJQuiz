 package joy.boj.quiz.lv08;

/*
<큰 수 A+B>
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

출력
첫째 줄에 A+B를 출력한다.
*/

import java.math.BigDecimal;
import java.util.Scanner;

public class BOJ10757 {
    Scanner sc;
    String A, B;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.A = sc.next();
        this.B = sc.next();
    }

    void getResult() {
        BigDecimal no1 = new BigDecimal(this.A);
        BigDecimal no2 = new BigDecimal(this.B);

        System.out.println(no1.add(no2));
    }
}
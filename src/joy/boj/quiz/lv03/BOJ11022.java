package joy.boj.quiz.lv03;

/*
<A+B - 8>
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
*/

import java.util.Scanner;

public class BOJ11022 {
    Scanner sc;
    int T, A, B, cnt;

    public void runQuiz() {
        sc = new Scanner(System.in);
        this.T = sc.nextInt();
        this.cnt = 1;

        while (this.T > 0) {
            dataScan();
            getResult();
            this.T--;
        }

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.A = sc.nextInt();
        this.B = sc.nextInt();
    }

    void getResult() {
        System.out.println("Case #" + this.cnt++ + ": " + this.A + " + " + this.B + " = " + (this.A + this.B));
    }
}
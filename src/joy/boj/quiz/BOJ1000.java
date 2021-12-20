package joy.boj.quiz;

import java.util.Scanner;

public class BOJ1000 {
    // A+B
    // 문제
    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    // 입력
    // 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
    // 출력
    // 첫째 줄에 A+B를 출력한다.

    int A, B;

    public void runQuiz() {
        dataScan();
        getResult();
    }

    void dataScan() {
        // 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("값 입력");
        this.A = sc.nextInt();
        this.B = sc.nextInt();
    }

    void getResult() {
        System.out.println(this.A + this.B);
    }
}

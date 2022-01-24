package joy.boj.quiz.lv03;

/*
<별 찍기 - 2>
문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
*/

import java.util.Scanner;

public class BOJ2439 {
    Scanner sc;
    int N;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
    }

    void getResult() {
        for ( int i = 1; i <= this.N; i++ ) {
            for ( int j = 0; j < this.N - i; j++ ) {
                System.out.print(" ");
            }

            for ( int j = 0; j < i; j++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
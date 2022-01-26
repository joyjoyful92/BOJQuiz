package joy.boj.quiz.lv05;

/*
<최소, 최대>
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10818 {
    Scanner sc;
    int N;
    int[] list;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
        this.list = new int[this.N];

        for ( int i = 0; i < this.N; i++ ) {
            this.list[i] = sc.nextInt();
        }
    }

    void getResult() {
        Arrays.sort(this.list);
        System.out.println(this.list[0] + " " + this.list[this.N - 1]);
    }
}
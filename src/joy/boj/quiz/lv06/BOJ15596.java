package joy.boj.quiz.lv06;

/*
<정수 N개의 합>
문제
정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.

작성해야 하는 함수는 다음과 같다.

* Java: long sum(int[] a); (클래스 이름: Test)
a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
리턴값: a에 포함되어 있는 정수 n개의 합
*/

import java.util.Scanner;

public class BOJ15596 {
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
        System.out.println(sum(list));
    }

    long sum(int[] a) {
        long ans = 0;

        for (int j : a) {
            ans += j;
        }

        return ans;
    }
}
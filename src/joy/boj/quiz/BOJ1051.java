package joy.boj.quiz;

// <숫자 정사각형>
// 문제
// N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 이때, 정사각형은 행 또는 열에 평행해야 한다.

// 입력
// 첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.

// 출력
// 첫째 줄에 정답 정사각형의 크기를 출력한다.

import java.util.Scanner;

public class BOJ1051 {
    Scanner sc = new Scanner(System.in);
    int N, M;
    String[] list;

    public void runQuiz() {
        this.N = sc.nextInt();
        this.M = sc.nextInt();

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.list = new String[this.N];
        for ( int i = 0; i < this.N; i++ ) {
            this.list[i] = sc.next();
        }
    }

    void getResult() {
        int maxWeight = Integer.MIN_VALUE;
        for ( int i = 0; i < this.N; i++ ) {
            for ( int j = 0; j < this.M; j++ ) {
                int cur = this.list[i].charAt(j);
                int width;
                int height;
                int weight = 1;

                // 현재 이후 값이 있는지 확인
                if ( j + 1 < this.M ) {
                    for ( int k = j + 1; k < this.M; k++ ) {
                        if ( cur == this.list[i].charAt(k) ) {
                            width = k - j + 1;

                            if ( i + 1 < this.N ) {
                                for ( int l = i + 1; l < this.N; l++ ) {
                                    if ( cur == this.list[l].charAt(j) && cur == this.list[l].charAt(k) ) {
                                        height = l - i + 1;
                                        weight = Math.max(weight, width * height);
                                    }
                                }
                            }
                        }
                    }
                }
                maxWeight = Math.max(maxWeight, weight);
            }
        }

        System.out.println(maxWeight);
    }
}
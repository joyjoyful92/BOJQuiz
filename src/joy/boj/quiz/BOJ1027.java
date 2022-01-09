package joy.boj.quiz;

// <고층 건물>
// 문제
// 세준시에는 고층 빌딩이 많다. 세준시의 서민 김지민은 가장 많은 고층 빌딩이 보이는 고층 빌딩을 찾으려고 한다. 빌딩은 총 N개가 있는데, 빌딩은 선분으로 나타낸다. i번째 빌딩 (1부터 시작)은 (i,0)부터 (i,높이)의 선분으로 나타낼 수 있다. 고층 빌딩 A에서 다른 고층 빌딩 B가 볼 수 있는 빌딩이 되려면, 두 지붕을 잇는 선분이 A와 B를 제외한 다른 고층 빌딩을 지나거나 접하지 않아야 한다. 가장 많은 고층 빌딩이 보이는 빌딩을 구하고, 거기서 보이는 빌딩의 수를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 빌딩의 수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에 1번 빌딩부터 그 높이가 주어진다. 높이는 1,000,000,000보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄에 문제의 정답을 출력한다.

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1027 {
    Scanner sc = new Scanner(System.in);
    int N;
    int[] list, cnt;

    public void runQuiz() {
        this.N = sc.nextInt();

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.list = new int[this.N + 1];
        this.cnt = new int[this.N + 1];
        for ( int i = 1; i <= this.N; i++ ) {
            this.list[i] = sc.nextInt();
        }
    }

    void getResult() {
        for ( int i = 1; i <= this.N; i++ ) {
            double maxSlope = Double.MIN_VALUE;
            // 왼쪽에 보이는 건물 수
            if ( i > 1 ) {
                for ( int j = i - 1; j >= 1; j-- ) {
                    double curSlope = Math.abs((double) ((this.list[i] - this.list[j]) / (i - j)));

                    if ( maxSlope < curSlope ) {
                        maxSlope = curSlope;


                    }
                }
            }

            // 오른쪽에 보이는 건물 수
            if ( i < this.N ) {
                for ( int j = i + 1; j < this.N; j++ ) {

                }
            }
        }

        Arrays.sort(this.cnt);

        System.out.println(this.cnt[this.N]);
    }
}
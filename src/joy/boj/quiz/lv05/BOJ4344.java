package joy.boj.quiz.lv05;

/*
<평균은 넘겠지>
문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
*/

import java.util.Scanner;

public class BOJ4344 {
    Scanner sc;
    int T, N, total;
    double avg;
    int[] list;

    public void runQuiz() {
        sc = new Scanner(System.in);
        this.T = sc.nextInt();

        while (this.T > 0) {
            dataScan();
            getResult();
            this.T--;
        }

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
        this.list = new int[this.N];
        this.total = 0;

        for ( int i = 0; i < this.N; i++ ) {
            this.list[i] = sc.nextInt();
            this.total += this.list[i];
        }

        this.avg = (double) this.total / (double) this.N;
    }

    void getResult() {
        int cnt = 0;
        for ( int i = 0; i < this.N; i++ ) {
            if ( this.avg < this.list[i] ) {
                cnt++;
            }
        }

        double res = (double) cnt / (double) this.N * 100;

        System.out.println(String.format("%.3f", res) + "%");
    }
}
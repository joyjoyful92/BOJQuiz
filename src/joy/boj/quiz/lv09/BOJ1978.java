 package joy.boj.quiz.lv09;

/*
<소수 찾기>
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.
*/

import java.util.Scanner;

public class BOJ1978 {
    Scanner sc;
    int T;
    int[] list;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.T = sc.nextInt();
        this.list = new int[this.T];

        for ( int i = 0; i < this.T; i++ ) {
            this.list[i] = sc.nextInt();
        }
    }

    void getResult() {
        int cnt = 0;
        for ( int i = 0; i < this.T; i++ ) {
            int curNo = this.list[i];

            if ( curNo > 1 ) {
                if ( curNo == 2 || curNo == 3 ) cnt++;
                else {
                    for (int j = 2; j <= curNo / 2; j++) {
                        if (curNo % j == 0)
                            break;

                        if (j == curNo / 2 && curNo % j != 0)
                            cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
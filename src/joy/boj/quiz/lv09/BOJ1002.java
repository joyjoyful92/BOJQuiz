package joy.boj.quiz.lv09;

/*
<터렛>
문제
조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
*/

import java.util.Scanner;

public class BOJ1002 {
    int t;
    int[] x1, y1, r1, x2, y2, r2;

    public void runQuiz() {
        dataScan();
        getResult();
    }

    void dataScan() {
        // 입력, 문제에 없는 system.out 은 하지 말것
        Scanner sc = new Scanner(System.in);
        this.t = sc.nextInt();
        this.x1 = new int[this.t];
        this.y1 = new int[this.t];
        this.r1 = new int[this.t];
        this.x2 = new int[this.t];
        this.y2 = new int[this.t];
        this.r2 = new int[this.t];

        int cnt = 0;
        while (cnt < this.t) {
            this.x1[cnt] = sc.nextInt();
            this.y1[cnt] = sc.nextInt();
            this.r1[cnt] = sc.nextInt();
            this.x2[cnt] = sc.nextInt();
            this.y2[cnt] = sc.nextInt();
            this.r2[cnt] = sc.nextInt();
            cnt++;
        }
        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void getResult() {
        for (int i = 0; i < this.t; i++) {
            // 1. 무한대
            if ( x1[i] == x2[i] && y1[i] == y2[i] && r1[i] == r2[i] ) {
                System.out.println(-1);
                continue;
            }

            // 원의 성질 파악 필요
            // 1. 밖에서 만나지않음 : r1 + r2 < d
            // 2. 밖에서 1점에서 만남 : r1 + r2 = d
            // 3. 2점에서 만남 : |r2 - r1| < d < r1 + r2
            // 4. 안에서 1점에서 만남 : |r2 - r1| = d
            // 5. 안에서 만나지 않음 : |r2 - r1| > d
            double d = Math.sqrt(Math.pow(x2[i] - x1[i], 2) + Math.pow(y2[i] - y1[i], 2));
            int plus = r1[i] + r2[i];
            int minus = Math.abs(r2[i] - r1[i]);

            if ( plus == d || minus == d ) {
                System.out.println(1);
                continue;
            } else if ( minus < d && d < plus ) {
                System.out.println(2);
                continue;
            }

            System.out.println(0);
        }
    }
}

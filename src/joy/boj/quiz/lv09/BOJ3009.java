 package joy.boj.quiz.lv09;

/*
<네 번째 점>
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ3009 {
    Scanner sc;
    Map<Integer, Integer> x = new HashMap<>();
    Map<Integer, Integer> y = new HashMap<>();

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        for ( int i = 0; i < 3; i++ ) {
            int cx = sc.nextInt();
            int cy = sc.nextInt();
            this.x.merge(cx, 1, (k, v) -> v + 1);
            this.y.merge(cy, 1, (k, v) -> v + 1);
        }
    }

    void getResult() {
        for ( Integer n : this.x.keySet() ) {
            if ( this.x.get(n) != 2 ) {
                System.out.print(n + " ");
                break;
            }
        }

        for ( Integer n : this.y.keySet() ) {
            if ( this.y.get(n) != 2 ) {
                System.out.println(n);
                break;
            }
        }
    }
}
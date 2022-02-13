 package joy.boj.quiz.lv09;

/*
<소수 구하기>
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1929 {
    Scanner sc;
    int M, N;
    ArrayList<Integer> list = new ArrayList<>();

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.M = sc.nextInt();
        this.N = sc.nextInt();
    }

    void getResult() {
        while ( this.M <= this.N ) {
            if ( this.M == 2 || this.M == 3 ) {
                System.out.println(this.M);
            } else {
                int root = (int) Math.sqrt(this.M);
                for ( int i = 2; i <= root; i++ ) {
                    if ( this.M % i == 0 )
                        break;

                    if ( i == root && this.M % i != 0 )
                        System.out.println(this.M);
                }
            }

            this.M++;
        }
    }
}
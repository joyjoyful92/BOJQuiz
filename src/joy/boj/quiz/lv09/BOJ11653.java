 package joy.boj.quiz.lv09;

/*
<소인수분해>
문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11653 {
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
        ArrayList<Integer> result = new ArrayList<>();

        if ( this.N > 1 ) {
            int num = 2;
            while ( this.N != num ) {
                if ( this.N % num == 0 ) {
                    result.add(num);
                    this.N = this.N / num;
                } else {
                    num++;
                }
            }

            result.add(this.N);
        }

        for ( Integer n : result ) {
            System.out.println(n);
        }
    }
}
package joy.boj.quiz;

// <분해합>
// 문제
// 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

// 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

// 출력
// 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2231 {
    Scanner sc = new Scanner(System.in);
    int N, min;
    ArrayList<Integer> selected;

    public void runQuiz() {
        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
        this.min = Integer.MAX_VALUE;
    }

    void getResult() {
        for ( int i = String.valueOf(this.N).length(); i > 0; i-- ) {
            this.selected = new ArrayList<>();
            dfs(0, 1, i);
        }

        this.min = this.min == Integer.MAX_VALUE ? 0 : this.min;
        System.out.println(this.min);
    }

    void dfs(int cnt, int idx, int div) {
        if ( cnt >= div ) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (Integer n : this.selected) {
                sum += n;
                sb.append(n);
            }

            int num = Integer.parseInt(sb.toString());

            if ( sum + num == this.N ) {
                this.min = Math.min(this.min, num);
            }
        } else {
            if ( idx < 10 ) {
                this.selected.add(idx);
                dfs(cnt + 1, 0, div);
                this.selected.remove(this.selected.size() - 1);
                dfs(cnt, idx + 1, div);
            }
        }
    }
}
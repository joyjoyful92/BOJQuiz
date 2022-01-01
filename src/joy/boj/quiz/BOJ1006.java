package joy.boj.quiz;

// 문제
// 초라기는 한국의 비밀국방기지(원타곤)를 습격하라는 임무를 받은 특급요원이다. 원타곤의 건물은 도넛 형태이며, 초라기는 효율적인 타격 포인트를 정하기 위해 구역을 아래와 같이 두 개의 원 모양으로 나누었다. (그림의 숫자는 각 구역의 번호이다.)

// 초라기는 각각 W명으로 구성된 특수소대를 다수 출동시켜 모든 구역에 침투시킬 예정이며, 각 구역 별로 적이 몇 명씩 배치되어 있는지는 초라기가 모두 알고 있다. 특수소대를 아래 조건에 따라 침투 시킬 수 있다.

// 한 특수소대는 침투한 구역 외에, 인접한 한 구역 더 침투할 수 있다. (같은 경계를 공유하고 있으면 인접 하다고 한다. 위 그림에서 1구역은 2, 8, 9 구역과 서로 인접한 상태다.) 즉, 한 특수소대는 한 개 혹은 두 개의 구역을 커버할 수 있다.
// 특수소대끼리는 아군인지 적인지 구분을 못 하기 때문에, 각 구역은 하나의 소대로만 커버해야 한다.
// 한 특수소대가 커버하는 구역의 적들의 합은 특수소대원 수 W 보다 작거나 같아야 한다.
// 이때 초라기는 원타곤의 모든 구역을 커버하기 위해 침투 시켜야 할 특수 소대의 최소 개수를 알고 싶어 한다.

// 입력
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성되어있다.
// 첫째 줄에는 (구역의 개수)/2 값 N과 특수 소대원의 수 W가 주어진다. (1 ≤ N ≤ 10000, 1 ≤ W ≤ 10000).
// 둘째 줄에는 1~N번째 구역에 배치된 적의 수가 주어지고, 셋째 줄에는 N+1 ~ 2N번째 구역에 배치된 적의 수가 공백으로 구분되어 주어진다. (1 ≤ 각 구역에 배치된 최대 적의 수 ≤ 10000) 단, 한 구역에서 특수 소대원의 수보다 많은 적이 배치된 구역은 존재하지 않는다. (따라서, 각 구역에 배치된 최대 적의 수 ≤ W)

// 출력
// 각 테스트케이스에 대해서 한 줄에 하나씩 원타곤의 모든 구역을 커버하기 위해 침투 시켜야 할 특수 소대의 최소 개수를 출력하시오.

import java.util.Scanner;

public class BOJ1006 {
    Scanner sc = new Scanner(System.in);
    int N, W; // 구역개수/2, 부대 당 소대원 수
    int[] enemy; // 적군의 수(1~N, N+1~2N) - 최대 적의 수는 소대원 수보다 적거나같음
    boolean[] selected;
    int resultCnt;

    public void runQuiz() {
        int T = sc.nextInt();

        while ( T > 0 ) {
            dataScan();
            getResult();
            T--;
        }

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        // 입력, 문제에 없는 system.out 은 하지 말것
        this.N = sc.nextInt(); // 구역개수/2
        this.W = sc.nextInt(); // 부대 당 소대원 수

        // 적군의 수
        this.enemy = new int[this.N * 2 + 1];
        this.selected = new boolean[this.N * 2 + 1];
        // 1~2N
        for ( int i = 1; i <= this.N * 2; i++ ) {
            this.enemy[i] = sc.nextInt();
        }

        this.resultCnt = 0;
    }

    void getResult() {
        for ( int i = 1; i <= this.N * 2; i++ ) {
            if ( !selected[i] ) {
                this.selected[i] = true; // 담당구역배정 완료

                // 인접구역 index
                int[] nearIdx = {
                        i % this.N == 1 ? ((i / this.N) + 1) * this.N : i - 1,
                        i + this.N,
                        i % this.N == 0 ? ((i / this.N) - 1) * this.N + 1 : i + 1,
                        i - this.N
                }; // left, top, right, bottom

                int curMax = this.enemy[i];
                int addIdx = 0;
                for (int idx : nearIdx) {
                    if (idx >= 1 && idx <= this.N * 2) {
                        int curSum = this.enemy[i] + this.enemy[idx];
                        if (!this.selected[idx] && curSum <= this.W && curMax <= curSum) {
                            curMax = curSum;
                            addIdx = idx;
                        }
                    }
                }

                if ( addIdx != 0 ) {
                    this.selected[addIdx] = true;
                }

                this.resultCnt++;
            }
        }

        System.out.println(this.resultCnt);
    }

    void dfs(int idx) {

    }
}
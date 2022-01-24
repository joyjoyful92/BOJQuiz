package joy.boj.quiz.lv24;

// <DFS와 BFS>
// 문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

import java.util.*;

public class BOJ1260 {
    Scanner sc = new Scanner(System.in);
    int N, M, V;
    ArrayList<Integer>[] graph;
    boolean[] visited;

    public void runQuiz() {
        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
        this.M = sc.nextInt();
        this.V = sc.nextInt();

        this.graph = new ArrayList[this.N + 1];
        // graph 초기화
        for ( int i = 1; i <= this.N; i++ ) {
            this.graph[i] = new ArrayList<>();
        }

        for ( int i = 0; i < this.M; i++ ) {
            int s = sc.nextInt(); // starting point
            int d = sc.nextInt(); // destination
            this.graph[s].add(d);
            this.graph[d].add(s);
        }

        // 정렬 - 작은 번호 순서대로
        for ( int i = 1; i <= this.N; i++ ) {
            ArrayList<Integer> list = this.graph[i];
            Collections.sort(list);
        }
    }

    void getResult() {
        this.visited = new boolean[this.N + 1];
        dfs(this.V);

        System.out.println();

        this.visited = new boolean[this.N + 1];
        bfs(this.V);
    }

    void dfs(int x) {
        this.visited[x] = true;
        System.out.print(x + " ");

        for ( Integer n : this.graph[x] ) {
            if ( visited[n] ) continue;
            dfs(n);
        }
    }

    void bfs(int x) {
        this.visited[x] = true;
        System.out.print(x + " ");

        Queue<Integer> que = new LinkedList<>();
        que.addAll(this.graph[x]); // 초기값 세팅

        while ( !que.isEmpty() ) {
            int n = que.poll();
            this.visited[n] = true;
            System.out.print(n + " ");

            for ( Integer c : this.graph[n] ) {
                if ( this.visited[c] ) continue;

                if ( !que.contains(c) ) {
                    que.add(c);
                }
            }
        }
    }
}
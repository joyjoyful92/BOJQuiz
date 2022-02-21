package joy.boj.quiz.lv10;

/*
<별 찍기 - 10>
문제
재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

입력
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.
*/

import java.util.Scanner;

public class BOJ2447 {
    Scanner sc = new Scanner(System.in);
    int N;
    String[] stars;
    boolean[][] starsFlag;

    public void runQuiz() {
        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.N = sc.nextInt();
//        this.stars = new String[this.N];
//
//        for ( int i = 0; i < this.N; i++ ) {
//            this.stars[i] = "";
//        }

        this.starsFlag = new boolean[this.N][this.N];
    }

    void getResult() {
//        recursive(this.N, true, 0);
//        recursive2(this.N, 0, 0);
//
//        for ( int i = 0; i < this.N; i++ ) {
//            System.out.println(this.stars[i]);
//        }

        getStars();
    }

    // timeout
    void recursive(int n, boolean show, int iIdx) {
        if ( n == 1 ) {
            if ( show )
                this.stars[iIdx] += "*";
            else
                this.stars[iIdx] += " ";
        } else {
            for ( int i = 0; i < 3; i++ ) {
                for ( int j = 0; j < 3; j++ ) {
                    boolean nextShow = false;
                    if ( show )
                        nextShow = i != 1 || j != 1;
                    recursive(n / 3, nextShow, iIdx + (i * (n / 3)));
                }
            }
        }
    }

    // timeout
    void recursive2(int n, int w, int h) {
        if ( n == 1 ) {
            this.stars[w] += "*";
        } else {
            for ( int i = 0; i < 3; i++ ) {
                for ( int j = 0; j < 3; j++ ) {
                    if ( j == 1 && i == 1 )
                        addSpace(n / 3, w + (i * (n / 3)), h + (j * (n / 3)));
                    else
                        recursive2(n / 3, w + (i * (n / 3)), h + (j * (n / 3)));
                }
            }
        }
    }

    void addSpace(int n, int w, int h) {
        for ( int i = w; i < w + n; i++ ) {
            for ( int j = h; j < h + n; j++ ) {
                this.stars[i] += " ";
            }
        }
    }

    // timeout
    void getStars() {
        int len = this.N;
        while ( len > 1 ) {
            for  ( int i = 0; i < this.N; i++ ) {
                for ( int j = 0; j < this.N; j++ ) {
                    if ( !this.starsFlag[i][j]
                            && len / 3 <= i % len && i % len < len / 3 * 2
                            && len / 3 <= j % len && j % len < len / 3 * 2 )
                        this.starsFlag[i][j] = true;
                }
            }

            len /= 3;
        }

        for ( boolean[] stars : this.starsFlag ) {
            for ( int i = 0; i < this.starsFlag.length; i++ ) {
                if ( !stars[i] ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
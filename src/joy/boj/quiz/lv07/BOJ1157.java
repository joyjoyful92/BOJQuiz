package joy.boj.quiz.lv07;

/*
<단어 공부>
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1157 {
    Scanner sc;
    String str;
    Map<Integer, Integer> cnt;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.str = sc.next();
        this.cnt = new HashMap<>();
    }

    void getResult() {
        this.str = this.str.toUpperCase();

        for ( int i = 0; i < this.str.length(); i++ ) {
            int key = this.str.charAt(i);
            this.cnt.merge(key, 1, Integer::sum);
        }

        // max값
        int max = Integer.MIN_VALUE;
        int maxKey = -1;
        for ( Integer key : this.cnt.keySet() ) {
            if ( max < this.cnt.get(key) ) {
                max = this.cnt.get(key);
                maxKey = key;
            }
        }

        for ( Integer key : this.cnt.keySet() ) {
            if ( maxKey != key && max == this.cnt.get(key) ) {
                maxKey = '?';
                break;
            }
        }


        System.out.println((char) maxKey);
    }
}
package joy.boj.quiz.lv07;

/*
<아스키 코드>
문제
알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

입력
알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.

출력
입력으로 주어진 글자의 아스키 코드 값을 출력한다.
*/

import java.util.Scanner;

public class BOJ11654 {
    Scanner sc;
    String c;

    public void runQuiz() {
        sc = new Scanner(System.in);

        dataScan();
        getResult();

        sc.close(); // stream close 필수 -> runtime error 발생시킴
    }

    void dataScan() {
        this.c = sc.nextLine();
    }

    void getResult() {
        System.out.println((int) this.c.charAt(0));
    }
}
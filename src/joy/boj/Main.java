package joy.boj;

// BOJ 제출할 때,
// 1. import copy
// 2. 작성했던 class 는 Main class 안으로 복사
// 3. 내부 class 가 static 인지 확인

// test 했던 class import 는 제외하고 올릴 것

import joy.boj.quiz.BOJ1010;

public class Main {
    public static void main(String[] args) {
        BOJ1010 answer = new BOJ1010();
        answer.runQuiz();
    }
}
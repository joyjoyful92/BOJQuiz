package joy.boj.quiz.lv01;

// <고양이>
// 문제
// 아래 예제와 같이 고양이를 출력하시오.

// 입력
// 없음.

// 출력
// 고양이를 출력한다.

public class BOJ10172 {
    public void runQuiz() {
        getResult();
    }

    void getResult() {
        String sb = "|\\_/|\n" +
                "|q p|   /}\n" +
                "( 0 )\"\"\"\\\n" +
                "|\"^\"`    |\n" +
                "||_/=\\\\__|";

        System.out.println(sb);
    }
}
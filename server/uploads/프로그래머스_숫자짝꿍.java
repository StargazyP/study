import java.util.Arrays;

public class 프로그래머스_숫자짝꿍 {

    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        // X, Y 각각의 숫자 등장 횟수를 카운트
        for (char ch : X.toCharArray()) {
            countX[ch - '0']++;
            
        }
        for(int i = 0; i  < countX.length; i++){
            System.out.println("countX's " + countX[i]);

        }
        for (char ch : Y.toCharArray()) {
            countY[ch - '0']++;
        }
        for(int j = 0; j < countY.length; j++){
            System.out.println("countY's " + countY[j]);
        }

        // 공통으로 있는 숫자들을 큰 숫자부터 조합
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]); // 공통 개수
            for (int j = 0; j < common; j++) {
                sb.append(i);
            }
        }

        // 결과 처리
        if (sb.length() == 0) return "-1";        // 공통 숫자 없음
        if (sb.charAt(0) == '0') return "0";      // 모두 0일 경우 "0"
        return sb.toString();
    }

    public static void main(String[] args) {
        프로그래머스_숫자짝꿍 t = new 프로그래머스_숫자짝꿍();

        System.out.println(t.solution("100", "2345"));    // -1
        // System.out.println(t.solution("100", "203045"));  // 00
        // System.out.println(t.solution("100", "123450"));  // 0
        // System.out.println(t.solution("5525", "1255"));   // 552
    }
}


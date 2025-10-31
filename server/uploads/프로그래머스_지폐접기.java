public class 프로그래머스_지폐접기 {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            // 현재 상태에서 들어가는지 체크 (원래 방향 / 90도 회전)
            boolean fitsNormal = bill[0] <= wallet[0] && bill[1] <= wallet[1];
            System.out.println(fitsNormal);
            boolean fitsRotated = bill[1] <= wallet[0] && bill[0] <= wallet[1];
            System.out.println(fitsRotated);
            if (fitsNormal || fitsRotated) break; // 들어가면 종료
            
            // 긴 쪽을 반으로 접음
            if (bill[0] >= bill[1]) {
                bill[0] /= 2; // 홀수는 자동으로 소수점 버려짐
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }

    // 테스트용 main
    public static void main(String[] args) {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};
        System.out.println(solution(wallet, bill)); // 출력: 1
    }
}

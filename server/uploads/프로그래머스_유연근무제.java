import java.util.ArrayList;

public class 프로그래머스_유연근무제 {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int limitTime = addMinutes(schedules[i], 10);
            boolean allOnTime = true;
            int dayOfWeek = startday; // 이벤트 시작 요일

            for (int day = 0; day < 7; day++) {
                // 토요일(6), 일요일(7)은 체크 안 함
                if (dayOfWeek != 6 && dayOfWeek != 7) {
                    if (timelogs[i][day] > limitTime) {
                        allOnTime = false;
                        break;
                    }
                }
                dayOfWeek = (dayOfWeek % 7) + 1; // 요일 증가
            }

            if (allOnTime) result++;
        }

        return result;
    }
    private static int addMinutes(int time, int minutes){
        int hour = time / 100;
        int minute = time % 100;
        minute += minutes;
        if(minute >= 60){
            hour += minute / 60;
            minute %= 60;
        }
        return hour * 100 + minute;
    }
        

    
    public static void main(String[] args){
                프로그래머스_유연근무제 test = new 프로그래머스_유연근무제();
        int result1 = test.solution(
            new int[]{700, 800, 1100},
            new int[][]{
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
            },
            5
        );
        System.out.println(result1); // 기대값: 3


        
    }
}

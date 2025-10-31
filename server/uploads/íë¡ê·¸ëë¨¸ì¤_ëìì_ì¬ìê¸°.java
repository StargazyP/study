public class 프로그래머스_동영상_재생기 {

    

    private static int timeToSec(String time){
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        System.out.println("timeToSec : " +  min * 60 + sec );
        return min * 60 + sec;
        
    }

    private static String secToTime(int sec){
        int min = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", min, s);
    }

    public static void main(String[] args){
        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};

        int video_len_int = timeToSec(video_len);
        int pos_int = timeToSec(pos);
        int op_start_int = timeToSec(op_start);
        int op_end_int = timeToSec(op_end);

        // prev/next 처리 전에 오프닝 구간이면 op_end로 이동
        if(pos_int >= op_start_int && pos_int <= op_end_int){
            pos_int = op_end_int;
        }

        // 명령 처리
        for(String cmd : commands){
            if(cmd.equals("prev")){
                pos_int -= 10;
                if(pos_int < 0) pos_int = 0;
            } else if(cmd.equals("next")){
                pos_int += 10;
                if(pos_int > video_len_int) pos_int = video_len_int;
            }

            // 매번 명령 후 오프닝 구간이면 op_end로 이동
            if(pos_int >= op_start_int && pos_int <= op_end_int){
                pos_int = op_end_int;
            }
        }

        String result = secToTime(pos_int);
        System.out.println("result is : " + result);
    }
}

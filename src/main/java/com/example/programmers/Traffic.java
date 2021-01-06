package com.example.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 추석 트래픽
 */
public class Traffic {

    public static void main(String[] args) throws ParseException {

        int answer = 0;

        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}; // 1 ≦ lines.length ≦ 2,000

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Calendar begin = Calendar.getInstance(); // 1초 구간 시작시간
        Calendar end = (Calendar) begin.clone(); // 1초 구간 끝시간

        begin.setTime(format.parse("2016-09-15 00:00:00.000"));
        end.setTime(format.parse("2016-09-15 00:00:00.999"));

        List<Schedule> scheduleList = new ArrayList<>();

        for (String line : lines) {

            String[] s = line.split(" ");

            Calendar processBegin = Calendar.getInstance(); // 처리 시작 시간
            Calendar processEnd = Calendar.getInstance(); // 처리 완료 시간

            processBegin.setTime(format.parse(s[0] + " " + s[1]));
            processEnd.setTime(format.parse(s[0] + " " + s[1]));

            double t = Double.parseDouble(s[2].split("s")[0]) * 1000;

            processBegin.add(Calendar.MILLISECOND, -1 * (int) Math.floor(t));
            processBegin.add(Calendar.MILLISECOND, 1);

            scheduleList.add(new Schedule(processBegin, processEnd));

        }

        for (Schedule schedule : scheduleList) {

            // 1 시작 시간에 체크
            if (schedule.getBeginTime().after(begin)) {
                begin.setTime(schedule.getBeginTime().getTime());
                end.setTime(schedule.getBeginTime().getTime());
                end.add(Calendar.MILLISECOND, 999);
            }

            int ans = 0;

            for (Schedule ss : scheduleList) {
                if (begin.compareTo(ss.getEndTime()) <= 0 && end.compareTo(ss.getBeginTime()) >= 0) {
                    ans++;
                }
            }

            answer = ans > answer ? ans : answer;

            // 2 완료 시간에 체크
            begin.setTime(schedule.getEndTime().getTime());
            end.setTime(schedule.getEndTime().getTime());
            end.add(Calendar.MILLISECOND, 999);

            int ans1 = 0;

            for (Schedule ss : scheduleList) {
                if (begin.compareTo(ss.getEndTime()) <= 0 && end.compareTo(ss.getBeginTime()) >= 0) {
                    ans1++;
                }
            }

            answer = ans1 > answer ? ans1 : answer;

        }

        System.out.println("answer : " + answer);
    }

}

class Schedule {

    private Calendar beginTime;

    private Calendar endTime;


    public Schedule(Calendar beginTime, Calendar endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Calendar getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Calendar beginTime) {
        this.beginTime = beginTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }
}

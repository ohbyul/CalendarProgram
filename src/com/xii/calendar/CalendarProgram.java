package com.xii.calendar;



import java.util.Scanner;
import java.util.Calendar;
 
class MakeCalendar{
    private Integer year;
    private Integer month;
    private Integer date;
    private Integer space;
    private Integer lastday;
    
    public void getCalendarData(Integer year, Integer month){
        this.year=year;
        this.month=month;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, 1); // 현재 객체의 년, 월, 일 값을 설정
        date=cal.get(Calendar.DAY_OF_WEEK); // 해당 달의 1일의 요일(일요일은 1, 토요일은 7)
        space=date-1; // 달력 첫 주의 tab 갯수
        lastday=cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 달의 마지막 날짜
    }
    public void print(){
        // 출력
        System.out.println("\t\t"+year+"년\t"+month+"월");
        System.out.println("일\t월\t화\t수\t목\t금\t토\t");
        for(Integer i=0; i<space; i++){
            System.out.print("\t");
        }
        for(Integer i=1; i<lastday+1; i++){
            if(i<10){ // 1~9일은 space 추가
            System.out.print(" "+i+"\t");}
            else{
                System.out.print(i+"\t");
            }
            if((i+space)%7==0){ // 한 주가 지나면 개행
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
}
 
public class CalendarProgram {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        MakeCalendar MC=new MakeCalendar();
        
        System.out.print("년도를 입력  >> ");
        Integer year=sc.nextInt();
        System.out.print("월을 입력[전체 보기: 0] >> ");
        Integer month=sc.nextInt();
        
        if(month==0){
            for(Integer i=1; i<13; i++){
                MC.getCalendarData(year, i);
                MC.print();
            }
        }else{
            MC.getCalendarData(year, month);
            MC.print();
        }
        sc.close();
    }
}
 
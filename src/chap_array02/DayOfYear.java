package chap_array02;

import java.util.Scanner;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/04
 */
public class DayOfYear {
    static int [][] mdays = {
        {31,28,31,30,31,30,31,31,30,31,20,31},
        {31,29,31,30,31,30,31,31,30,31,20,31},
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 ==0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear (int year, int month, int day) {
        int totalDays = day;         // 일 수

        for ( int i = 1; i < month; i++ ) {
            totalDays += mdays[isLeap ( year )][ i - 1 ];
        }
        return totalDays;
    }

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int totalDays = DayOfYear.dayOfYear ( 2021,4,13 );
        System.out.println ("결과: " + totalDays + "번 째 일 입니다.");
    }
}

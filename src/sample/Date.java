package sample;

import javafx.scene.control.DatePicker;
//this is the data class
public class Date {

    private int Day;
    private int Month;
    private int Year;

    public Date(int day, int month, int year) {
        this.Day = day;
        this.Month = check(month);
        this.Year = year;
    }
    public int check(int month){
        if(month<=12 && month>0) {
            return month;
        }else{
            System.out.println("Invalid month");

        }
        return 0;
    }

}

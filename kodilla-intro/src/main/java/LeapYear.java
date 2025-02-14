public class LeapYear {
    public static boolean leapYear(int year) {
        if (year % 4 != 0)
            return false;
        else if (year % 100 != 0)
            return true;
        else return year % 400 == 0;
    }
}





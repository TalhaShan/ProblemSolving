package OneMonthPrepKit;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TimeConversion {


    public static String timeConversion(String s) {
        // Write your code here
//        07:05:45PM
//        19:05:45

        String time[] = s.split(":");
        String meridian = time[2].substring(2);
        //System.out.println(meridian);
        //System.out.println(Arrays.asList(time));
        String result = "";
        if (Integer.parseInt(time[0]) == 12) {
            if (meridian.equalsIgnoreCase("PM")) {
                result = time[0].trim() + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
            } else {
                result = "00" + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
            }
        } else {
            int hrs = 0;
            if (meridian.equalsIgnoreCase("PM")) {
                hrs = Integer.parseInt(time[0]) + 12;
                //  System.out.println(hrs);
                result = hrs + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
            } else {
                result = time[0] + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();

            }
        }
        return result;

    }

    public static void main(String[] args) {
//     timeConversion("07:05:45PM");
//       timeConversion("12:01:00PM");
//       timeConversion("12:01:00AM");
        timeConversion("06:40:03AM");
        timeConversion("04:59:59AM");
    }

//    public static String timeConversion(String s) {
//        // Write your code here
//
//        String time[] = s.split(":");
//        String meridian = time[2].substring(2);
//        //System.out.println(meridian);
//        //System.out.println(Arrays.asList(time));
//        int hrs = 0;
//        String result = "";
//        if (meridian.equalsIgnoreCase("PM")) {
//            hrs = Integer.parseInt(time[0]) + 12;
//            //  System.out.println(hrs);
//            result = hrs + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
//
//        } else {
//            result = time[0] + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
//
//        }
//        if (Integer.parseInt(time[0]) == 12 && meridian.equalsIgnoreCase("PM")) {
//            result = time[0].trim() + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
//        } else if (Integer.parseInt(time[0]) == 12 && meridian.equalsIgnoreCase("AM")) {
//            //Am
//            result = "00" + ":" + time[1].trim() + ":" + time[2].substring(0, 2).trim();
//        }
//        //  System.out.println(result);
//        return result;
//
//
//    }

//}
}

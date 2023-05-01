package SdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


//In order to do max meeting we will pick meeting that has less occupied time
//We will sort it by end time but there is correspondence in both array we will make comparator,
// and then we made a list and insert a/c to end time
// then we have limit onfocus first meeting will hold we start at  i =1
// and if limit means end time of last meeting is less than start time of next meeting then the meeting is useful
//so we insert that meeting only
//else other meeting will be ignored as start time < limit and we have already sorted on the base of end time
//take another array to insert pos or correspondence array to display in end

public class NMeetingsOneRoom {


    static class Meeting {
        int start;
        int end;
        int pos;

        public Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

    }

    static class MeetingComparator implements Comparator<Meeting> {


        @Override
        public int compare(Meeting o1, Meeting o2) {
            if (o1.end < o2.end) {  // o2 me first araha hai element read about comparor
                return -1;
            } else if (o1.end > o2.end) {
                return 1;
            } else if (o1.pos < o2.pos) {
                return -1;
            }
            return 1;
        }
    }

    static void maxMeetings(int start[], int end[], int n) {

        ArrayList<Meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meet.add(new Meeting(start[i], end[i], i + 1));
        }

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meet, mc);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        for(int i = 1; i<n; i++){
            if(meet.get(i).start>limit){
                limit = meet.get(i).end;
                res.add(meet.get(i).pos);
            }
        }
        System.out.println("Meeting will performed In order");
        for(int i = 0 ; i <res.size(); i++){
            System.out.println(res.get(i));
        }

    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);
    }

//    The order in which the meetings will be performed is
//1 2 4 5
//
//    Time Complexity: O(n) to iterate through every position and insert them in a data structure. O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate through the positions and check which meeting can be performed.
//
//    Overall : O(n) +O(n log n) + O(n) ~O(n log n)
//
//    Space Complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.
}

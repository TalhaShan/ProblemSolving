package STRIVER_SHEET.Arrays.GreedyAlgorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NmeetingsRoom {

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

    static class NMeetingComparator implements Comparator<Meeting> {

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

        static void maxMeetings(int start[], int end[], int n) {

            ArrayList<Meeting> meet = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < start.length; i++) {
                meet.add(new Meeting(start[i], end[i], i + 1));
            }
            NMeetingComparator mc = new NMeetingComparator();
            Collections.sort(meet, mc);
            int limit = meet.get(0).end;
            res.add(meet.get(0).pos);
            for (int i = 1; i < start.length; i++) {
                if (meet.get(i).start < limit) {
                    res.add(meet.get(i).pos);
                    limit = meet.get(i).end;
                }
            }
            System.out.println("Meeting will performed In order");
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }

}

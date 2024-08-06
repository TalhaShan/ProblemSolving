package STRIVER_SHEET.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;

public class NMeetingInOneRoom {

    class meetObj {
        int start;
        int end;
        int position;

        meetObj(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    class MeetingComparator implements Comparator<meetObj> {

        @Override
        public int compare(meetObj o1, meetObj o2) {
            if (o1.end < o2.end) {
                return -1;
            } else if (o1.end > o2.end) {
                return 1;
            } else if (o1.position < o2.position) {
                return -1;
            }
            return -1;
        }
    }

    void maxMeetings(int start[], int end[], int n) {
        ArrayList<meetObj> meetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetList.add(new meetObj(start[i], end[i], i + 1));
        }

        MeetingComparator mc = new MeetingComparator();
        meetList.sort(mc);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meetList.get(0).position);
        int limit = meetList.get(0).end;
        for (int i = 1; i < start.length; i++) {
            if (meetList.get(i).end < limit) {
                ans.add(meetList.get(i).position);
                limit = meetList.get(i).end;
            }
        }
    }

}

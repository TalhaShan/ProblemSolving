package SdeSheet;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SonarTest2 {
    public int solution(int[] arr) {
        // Implement your solution here
        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max && i > minIndex) {
                max = arr[i];
                maxIndex = i;
            }

            if (arr[i] < min && i > maxIndex) {
                min = arr[i];
                minIndex = i;
            }
        }
        return Math.abs(arr[maxIndex]-arr[minIndex]);
    }
}


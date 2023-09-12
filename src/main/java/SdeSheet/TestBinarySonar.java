package SdeSheet;


import java.util.Arrays;


public class TestBinarySonar {

    public static int solution(int A, int B) {
        // Implement your solution here

        long res = (long) A * B;
        String binary = Integer.toBinaryString((int) res);
        long count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return (int) count;
    }

    public static void findMaxMinIndex(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max && i < minIndex) {
                max = arr[i];
                maxIndex = i;
            }

            if (arr[i] < min && i > maxIndex) {
                min = arr[i];
                minIndex = i;
            }
        }

        if (maxIndex < minIndex) {
            System.out.println("Maximum value: " + max + ", Index: " + maxIndex);
            System.out.println("Minimum value: " + min + ", Index: " + minIndex);
        } else {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            maxIndex = -1;
            minIndex = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }

                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }

            System.out.println("Maximum value: " + max + ", Index: " + maxIndex);
            System.out.println("Minimum value: " + min + ", Index: " + minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-3, 2, -1, 0, 1, 2, 3, 4, 5};

        findMaxMinIndex(arr);
    }

    }







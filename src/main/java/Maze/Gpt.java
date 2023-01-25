package Maze;

public class Gpt {
    public static void main(String[] args) {
        int x = 4;
        int y = 3;
        while (x > 0 && y > 0) {
            int[] diagonal_left_up = {x-1, y-1};
            System.out.println("Checking: ("+diagonal_left_up[0]+","+diagonal_left_up[1]+")");
            x -= 1;
            y -= 1;
        }
    }

}

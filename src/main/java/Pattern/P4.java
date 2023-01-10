package Pattern;

public class P4 {

    static void patten1() {
        int n = 4;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void patten2() {
        int n = 4;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void patten3() {
        int n = 4;

        for (int row = 0; row < 2 * n; row++) {
            int colInRows = row > n ? 2 * n - row : row;
            for (int col = 0; col < colInRows; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // patten1();
        patten3();
    }
}

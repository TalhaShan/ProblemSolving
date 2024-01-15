package Array;

import java.util.Arrays;

public class FloodFills {
    //
//    Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//    Output: [[2,2,2],[2,2,0],[2,0,1]]
//    Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
//    Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
//    Example 2:
//
//    Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//    Output: [[0,0,0],[0,0,0]]
//    Explanation: The starting pixel is already colored 0, so no changes are made to the image.

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;
        int prevColor = image[sr][sc];
        image[sr][sc] = color;
        moveUpward(image, sr, sc, color, prevColor);
        moveDownward(image, sr, sc, color, prevColor);
        moveLeft(image, sr, sc, color, prevColor);
        moveRight(image, sr, sc, color, prevColor);

        return image;
    }

    private static void moveUpward(int[][] image, int sr, int sc, int color, int prevColor) {
        sr--;

        while (sr >= 0 && prevColor == image[sr][sc]) {
            image[sr][sc] = color;
            moveUpward(image, sr, sc, color, prevColor);
            moveLeft(image, sr, sc, color, prevColor);
            moveRight(image, sr, sc, color, prevColor);
            sr--;
        }
    }

    private static void moveDownward(int[][] image, int sr, int sc, int color, int prevColor) {
        sr++;

        while (sr < image.length && prevColor == image[sr][sc]) {
            image[sr][sc] = color;
            moveDownward(image, sr, sc, color, prevColor);
            moveLeft(image, sr, sc, color, prevColor);
            moveRight(image, sr, sc, color, prevColor);
            sr++;
        }
    }

    private static void moveLeft(int[][] image, int sr, int sc, int color, int prevColor) {
        sc--;

        while (sc >= 0 && prevColor == image[sr][sc]) {
            image[sr][sc] = color;
            moveLeft(image, sr, sc, color, prevColor);
            moveUpward(image, sr, sc, color, prevColor);
            moveDownward(image, sr, sc, color, prevColor);
            sc--;
        }
    }

    private static void moveRight(int[][] image, int sr, int sc, int color, int prevColor) {
        sc++;

        while (sc < image[0].length && prevColor == image[sr][sc]) {
            image[sr][sc] = color;
            moveRight(image, sr, sc, color, prevColor);
            moveUpward(image, sr, sc, color, prevColor);
            moveDownward(image, sr, sc, color, prevColor);
            sc++;
        }
    }

    //Flood Fill optimize solution


    public static int[][] floodFillOptimizeRecursive(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        fillImage(image,image[sr][sc],sr,sc,color);
        return image;
    }

    private static void fillImage(int[][] image, int prevColor, int sr, int sc, int color) {
        if(sr<0 || sc<0 ||sr>=image.length ||sc>=image[0].length || image[sr][sc]!=prevColor) return;

        image[sr][sc] = color;
        fillImage(image,prevColor,sr+1,sc,color);
        fillImage(image,prevColor,sr-1,sc,color);
        fillImage(image,prevColor,sr,sc+1,color);
        fillImage(image,prevColor,sr,sc-1,color);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }
}

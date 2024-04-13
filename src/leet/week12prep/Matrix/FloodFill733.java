package leet.week12prep.Matrix;

import java.util.Arrays;

public class FloodFill733 {
    public static void main(String[] args) {
        int image[][] = {
                {3,3,1},
                {3,3,0},
                {1,0,1}
        };
        int sr = 1;
        int sc = 1;
        int color = 3;
        image = floodFill(image,sr,sc,color);
        System.out.println(Arrays.deepToString(image));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rowLen = image.length;
        int colLen = image[0].length;
        floodFill(image,sr,sc,color,rowLen,colLen,image[sc][sr]);
        return image;
    }

    public static void floodFill(int[][] image, int sr, int sc, int color,int rowLen, int colLen,int initialValue) {
        if (sr < 0 || sc < 0 || sr >= rowLen || sc >= colLen || image[sr][sc] != initialValue)
            return;
//            return image;
        else {
            //check condition and change the value
            if (image[sr][sc] == initialValue)
                image[sr][sc] = color;
            //upside
            floodFill(image,sr-1,sc,color,rowLen,colLen,initialValue);
//            image = floodFill(image,sr-1,sc,color,rowLen,colLen,initialValue);
            //downside
            floodFill(image,sr+1,sc,color,rowLen,colLen,initialValue);
//            image = floodFill(image,sr+1,sc,color,rowLen,colLen,initialValue);
            // right
            floodFill(image,sr,sc+1,color,rowLen,colLen,initialValue);
//            image = floodFill(image,sr,sc+1,color,rowLen,colLen,initialValue);
            //left
            floodFill(image,sr,sc-1,color,rowLen,colLen,initialValue);
//            image = floodFill(image,sr,sc-1,color,rowLen,colLen,initialValue);
//            return image;
        }

    }
}

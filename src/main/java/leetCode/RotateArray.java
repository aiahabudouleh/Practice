package leetCode;

public class RotateArray {

    public static void main(String[] args) {
        int[][] arr = new int [][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
    }

    public static void rotate(int[][] matrix) {

        int len = matrix[0].length;
        int top=0, bottom=len-1, left=0, right=len-1;

        /**
         tl-tr -> tr-br
         tr-br -> br-bl
         br-bl -> bl-tl
         bl-tl -> tl-tr


         tmp  : tr-br
         tr-br= tl-tr
         tl-tr= bl-tl
         bl-tl= br-bl
         br-bl= tmp
         */
        while (top <= bottom && left <= right) {
            int [] tmp = new int[right - left + 1];
            for (int i=left, j =0 ; i<=right ; ++i) {
                tmp[j++] = matrix[top][i];
            }

            //[top][left -> right] = [bottom->top][left]
            for(int i=left , j=bottom ; i<=right && j>=top; ++i, --j) {
                matrix[top][i] = matrix[j][left];
            }


            //[bottom->top][left] = [bottom][right->left]
            for (int i=bottom, j= right ;  i>top && j >= left ; --j , --i) {
                matrix[i][left] = matrix[bottom][j];
            }


            //[bottom][right -> left]= [top -> bottom][right]
            for (int i=right, j=top ; i>left && j<=bottom ; --i, ++j) {
                matrix[bottom][i] = matrix[j][right];
            }


            //[top -> bottom][right]
            int j=0;
            for (int i=top; i<=bottom; ++i) {
                matrix[i][right] = tmp[j++];
            }

            right--; left++; bottom--; top++;


        }



    }
}

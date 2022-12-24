package ch1;

public class Ch1 {

    public static boolean q1(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean [] check = new boolean[128];
        for (int i=0 ; i<str.length() ; ++i) {
            if (check[str.charAt(i)]) {
                return false;
            }

            check[str.charAt(i)] = true;
        }
        return true;
    }

    public static boolean q2(String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] s1Frq = new int[128];
        int[] s2Frq = new int [128];

        for (int i=0; i< s1.length(); ++i) {
            s1Frq[s1.charAt(i)]++;
            s2Frq[s2.charAt(i)]++;
        }

        for (int i=0; i<128 ; ++i) {
            if (s1Frq[i] != s2Frq[i]) {
                return false;
            }
        }

        return true;
    }

    public static String q3 (String str) {
        return str.replaceAll(" ", "%20");
    }

    //[%][2][0][/][0]
    //[a][/][0]
    public static Character[] q3_2(Character[] str, int trueLen){
        int spaceCounter = 0;
        for(int i=0; i< trueLen ; ++i) {
            if (str[i] == ' ') {
                spaceCounter++;
            }
        }

        int idx = trueLen + spaceCounter * 2;

        if (idx + 1 < str.length) {
            str[idx] = '/';
            str[idx + 1] = '0';
        }

        for (int i = trueLen - 1; i >= 0 ; --i) {
            if (str[i] == ' ') {
                str[idx-1] = '0';
                str[idx-2] = '2';
                str[idx-3] = '%';
                idx-=3;
            } else {
                str[idx-1] = str[i];
                idx--;
            }
        }

        return str;
    }

    public static boolean q4(String str) {
        int[] frq = new int [128];
        for (int i=0; i<str.length(); ++i) {
            frq[str.charAt(i)]++;
        }

        int oddCounter = 0;
        for (int i=0; i<128 ; ++i) {
            if (frq[i] % 2 == 1) {
                oddCounter++;
            }
        }

        if ((str.length() % 2 == 1 && oddCounter == 1)
                || (str.length() % 2 == 0 && oddCounter == 0)) {
             return true;
        }
        return false;
    }

    //s1=ara
    //s2=yara
    public static boolean q5(String s1, String s2) {
        if (s1.length() == s2.length() || Math.abs(s1.length() - s2.length()) == 1) {
            return q5_isOneEdit(s1, s2);
        }

        return false;
    }

    private static boolean q5_isOneEdit(String s1, String s2) {
        String shortStr, longStr;
        if (s1.length() < s2.length()) {
            shortStr = s1;
            longStr = s2;
        } else {
            shortStr = s2;
            longStr = s1;
        }

        boolean found = false;
        //i=0, -1, 0
        //j=0, 1
        for (int i=0, j=0 ; i<shortStr.length() && j<longStr.length() ; ++i, ++j) {
            if (shortStr.charAt(i) == longStr.charAt(j)) {
                continue;
            }
            i--;
            if (found) {
                return false;
            }
            found = true;
        }

        return true;
    }

    //aabbc
    public static String q6(String str) {
        if (str.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int counter = 0;

        for (int i=0; i<str.length(); ++i) {
            counter++;

            if (i+1 >= str.length() || (str.charAt(i) != str.charAt(i+1))) {
                compressed.append(str.charAt(i));
                compressed.append(counter);
                counter = 0;
            }
        }

        return str.length() > compressed.length() ? compressed.toString() : str;
    }

    public static int[][] q7(int[][] matrix, int n) {
            int len = matrix[0].length;
            int top=0, bottom=len-1, left=0, right=len-1;
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
            return matrix;

    }

    public static int[][] q8(int [][] matrix, int n, int m) {

        boolean rows[] = new boolean[n];
        boolean cols[] = new boolean [m];

        for (int i=0; i<n ; ++i) {
            for (int j=0; j<m; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                    continue;
                }
            }
        }

        for (int i=0; i<n ; ++i){
            for (int j=0; j<m ; ++j) {
                if (rows[i] == true && cols[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    //ab
    public static boolean q9(String s1, String subS1) {
        String key = s1 + s1;
        return key.contains(subS1);
    }


    public static void main(String[] args) {

    }
}

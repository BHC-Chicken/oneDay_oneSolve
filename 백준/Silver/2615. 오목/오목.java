import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] rowArr = new int[20][20];
    static int[][] colArr = new int[20][20];
    static int[][] leftUpCrossArr = new int[20][20];
    static int[][] leftDownCrossArr = new int[20][20];

    static boolean inRange(int x, int y) {
        return x >= 0 && x <= 19 && y >= 0 && y <= 19;
    }


    static int row(int x, int y) {
        if (rowArr[x][y] == 0) {
            return 0;
        }

        int count = 1;
        int start = rowArr[x][y];

        for (int i = 1; i <= 19; i++) {
            if (inRange(x, y + i) && rowArr[x][y + i] == start) {
                count++;
                rowArr[x][y + i] = 0;
            } else {
                if (count == 5) {
                    return start;
                } else {
                    return 0;
                }
            }
        }

        if (count == 5) {
            return start;
        }

        return 0;
    }

    static int col(int x, int y) {
        if (colArr[x][y] == 0) {
            return 0;
        }

        int count = 1;
        int start = colArr[x][y];

        for (int i = 1; i <= 5; i++) {
            if (inRange(x + i, y) && colArr[x + i][y] == start) {
                count++;
                colArr[x + i][y] = 0;
            } else {
                if (count == 5) {
                    return start;
                } else {
                    return 0;
                }
            }
        }

        if (count == 5) {
            return start;
        }

        return 0;
    }

    static int leftUpCross(int x, int y) {
        if (leftUpCrossArr[x][y] == 0) {
            return 0;
        }

        int count = 1;
        int start = leftUpCrossArr[x][y];

        for (int i = 1; i <= 19; i++) {
            if (inRange(x + i, y + i) && leftUpCrossArr[x + i][y + i] == start) {
                count++;
                leftUpCrossArr[x + i][y + i] = 0;
            } else {
                if (count == 5) {
                    return start;
                } else {
                    return 0;
                }
            }
        }

        if (count == 5) {
            return start;
        }

        return 0;
    }

    static int leftDownCross(int x, int y) {
        if (leftDownCrossArr[x][y] == 0) {
            return 0;
        }

        int count = 1;
        int start = leftDownCrossArr[x][y];

        for (int i = 1; i <= 19; i++) {
            if (inRange(x - i, y + i) && leftDownCrossArr[x - i][y + i] == start) {
                count++;
                leftDownCrossArr[x - i][y + i] = 0;
            } else {
                if (count == 5) {
                    return start;
                } else {
                    return 0;
                }
            }
        }

        if (count == 5) {
            return start;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                int num = Integer.parseInt(st.nextToken());
                rowArr[i][j] = num;
                colArr[i][j] = num;
                leftUpCrossArr[i][j] = num;
                leftDownCrossArr[i][j] = num;
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                int rowResult = row(i, j);
                int colResult = col(i, j);
                int leftUpCrossResult = leftUpCross(i, j);

                if (rowResult > 0) {
                    System.out.println(rowResult);
                    System.out.println(i + " " + j);

                    return;
                }

                if (colResult > 0) {
                    System.out.println(colResult);
                    System.out.println(i + " " + j);

                    return;
                }

                if (leftUpCrossResult > 0) {
                    System.out.println(leftUpCrossResult);
                    System.out.println(i + " " + j);

                    return;
                }
            }
        }

        for (int i = 19; i >= 0; i--){
            for (int j = 19; j >=0; j--) {
                int leftDownCrossResult = leftDownCross(i, j);

                if (leftDownCrossResult > 0) {
                    System.out.println(leftDownCrossResult);
                    System.out.println(i + " " + j);

                    return;
                }
            }
        }

        System.out.println(0);
    }
}

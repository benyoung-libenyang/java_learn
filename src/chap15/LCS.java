package chap15;

public class LCS {
    private static int[][] lscLength(Character[] x, Character[] y){
        int m =x.length;
        int n =y.length;
        int[][] c = new int[m+1][n+1];
        for(int i = 1; i <= m; i++)
            c[i][0] = 0;
        for(int j = 0; j <= n; j++)
            c[0][j] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(x[i-1].compareTo(y[j-1]) == 0)
                    c[i][j] = c[i-1][j-1] + 1;
                else if (c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                }else
                    c[i][j] = c[i][j-1];
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Character[] x = {'a','b','c','b','d','a','b'};
        Character[] y = {'b','d','c','a','b','a'};
        System.out.println(lscLength(x, y)[7][6]);

    }
}

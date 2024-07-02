package test;

import java.util.Scanner;

public class matrix4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();
        long area1 = (long)(x2-x1)*(y2-y1);
        long area2 = (long)(x4-x3)*(y4-y3);
        long overArea = 0;
        long l = Math.min(x2, x4)-Math.max(x1, x3);
        long w = Math.min(y2,y4)-Math.max(y1,y3);
        if(l>=0&&w>=0)
            overArea = l*w;
        System.out.println(area1+area2-overArea);
    }
}

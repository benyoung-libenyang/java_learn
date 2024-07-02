package test;

import java.util.Arrays;
import java.util.Scanner;

public class shuadishu2022_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int a = 0;
        while(true){
            int min = 0;
            int max = 0;
            for(int j = 1; j < n; j++){
                if(arr[0] + a > arr[j])
                    min++;
                else if (arr[0] + a < arr[j]) {
                    max++;
                }
            }
            if(max <= min){
                System.out.print(a);
                break;
            }else
                a++;
        }

        for(int i = 1; i < n; i++){
            int ans = 0;
            while(true){
                int min = 0;
                int max = 0;
                for(int j = 0; j < n; j++){
                    if(j == i)
                        continue;
                    if(arr[i] + ans > arr[j])
                        min++;
                    else if (arr[i] + ans < arr[j]) {
                        max++;
                    }
                }
                if(max <= min){
                    System.out.print(" "+ans);
                    break;
                }else
                    ans++;
            }
        }
    }
}

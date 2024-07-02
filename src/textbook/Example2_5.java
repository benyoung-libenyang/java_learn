package textbook;

import java.util.Scanner;

public class Example2_5 {
    public static void main(String[] args) {
        int start = 0, mid, end;
        int a[] = {12,45,67,89,123,-45,67};
        int N = a.length;
        sort_min(a, N);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数在不在程序中");
        int number = scanner.nextInt();
        int count = 0;
        end = N;
        mid = (start+end)/2;
        while(number!=a[mid]){
            if(number > a[mid]) {
                start = mid;
            }
            if(number < a[mid]){
                end = mid;
            }
            mid = (start+end)/2;
            count++;
//            确保最终如果实在没有找到就退出去。
            if(count > N/2)
                break;
        }
        if (count>N/2)
            System.out.println("no");
        else
            System.out.println("yes");
    }
    private static void sort_min(int [] arr, int N){
        final class test {
            public static int a = 1;
        }
        for (int i = 0 ; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(arr[j] < arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}

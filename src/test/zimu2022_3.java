package test;

import java.util.Scanner;

public class zimu2022_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] ch = s.toCharArray();
        int[] arr = new int[26];
        for(int i=0; i < ch.length; i++){
            arr[ch[i]-'A']++;
        }
        int max = 0;
        for(int i=0; i < 26; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        for(int i=0; i < 26; i++)
            if(arr[i] == max)
                System.out.print(Character.toChars('A' + i));
    }
}

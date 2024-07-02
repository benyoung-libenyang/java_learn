package textbook;

import java.util.Scanner;

public class SortingAlgorithms {
    // 选择排序
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        // 从键盘输入10个数字
        System.out.println("请输入10个数字：");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 使用选择排序排序并输出结果
        int[] selectionSorted = numbers.clone();
        selectionSort(selectionSorted);
        System.out.println("选择排序后的结果：");
        for (int num : selectionSorted) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 使用冒泡排序排序并输出结果
        int[] bubbleSorted = numbers.clone();
        bubbleSort(bubbleSorted);
        System.out.println("冒泡排序后的结果：");
        for (int num : bubbleSorted) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 使用插入排序排序并输出结果
        int[] insertionSorted = numbers.clone();
        insertionSort(insertionSorted);
        System.out.println("插入排序后的结果：");
        for (int num : insertionSorted) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}

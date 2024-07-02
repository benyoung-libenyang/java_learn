package test;

import java.util.*;

public class ThreeForTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = scanner.nextInt();
        System.out.println(minCost(prices));
    }
    private static int minCost(int[] prices){
        Arrays.sort(prices);
        ArrayList<Integer> price = new ArrayList<>();
        for(int i : prices)
            price.add(i);
        int cost = 0;
        while(price.size() > 0){
            if(price.size() > 2){
                Integer temp = price.get(price.size() - 2);
                cost = cost + price.get(price.size()-1) + price.get(price.size()-2);
                price.remove(price.size()-1);
                price.remove(price.size()-1);
                for(int i = price.size() - 1; i >= 0 ; i--){
                    if(price.get(i) <= temp/2){
                        price.remove(i);
                        break;
                    }
                }
            }else{
                for(int i : price)
                    cost += i;
                break;
            }

        }
        return cost;
    }
    /**
     7
     1 4 2 8 5 7 1
     */
}

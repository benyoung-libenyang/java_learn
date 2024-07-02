package test;

public class xingyunshuzi2 {
    public static void main(String[] args) {
        int count = 0;
        long ans = 0;
        while(count < 2023){
            for(long i = ans+1; i <= 1000000000; i++){
                if(BaseConversion(i)){
                    count++;
                    ans = i;
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static boolean BaseConversion(long n){
        int sum = 0;
        long x = n;
        while(x != 0){
            sum += x%10;
            x /= 10;
        }
        if(n%sum != 0)
            return false;

        x = n;
        sum = 0;
        while(x != 0){
            sum += x%2;
            x /= 2;
        }
        if(n%sum != 0)
            return false;

        x = n;
        sum = 0;
        while(x != 0){
            sum += x%8;
            x /= 8;
        }
        if(n%sum != 0)
            return false;

        x = n;
        sum = 0;
        while(x != 0){
            sum += x%16;
            x /= 16;
        }
        if(n%sum != 0)
            return false;

        return true;
    }

}

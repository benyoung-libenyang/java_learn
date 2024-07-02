package test;

public class new2022_2 {
    public static void main(String[] args) {
        int count = 0;
        for(int i = 2022; i <= 2022222022; i++){
            if(func(i))
                count++;
        }
        System.out.println(count);
    }
    private static boolean func(int x){
        String str = String.valueOf(x);
        for(int i=0, j= str.length()-1; i <= j; i++,j--){
            if(str.charAt(i) != str.charAt(j))
                return false;
        }
        for(int i=1; i <= str.length()/2; i++){
            if(str.charAt(i) < str.charAt(i-1))
                return false;
        }
        return true;
    }
}

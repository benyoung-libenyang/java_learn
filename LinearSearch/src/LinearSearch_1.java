// 向Math方法靠近

public class LinearSearch_1 {

    private LinearSearch_1(){}
//  Math.abs(-2), 希望用户不创建对象就可以使方法，构造函数私有就不能创建对象

    public static int search(int[] data, int target){
        for(int i = 0; i < data.length; i++)
            if(data[i] == target)
                return i;
        return -1;
    }
    public static void main(String[] args){
        int[] data = {12, 2, 4, 23, 43, 54};
        /*
        LinearSearch_1 ls = new LinearSearch_1();
        int res = ls.search(data, 4);
        System.out.println(res);
        */
//       思考：LinearSearch是一个动词（面向对象编程），search为一个动词，更希望直接使用一个static方法直接调用
//        而不是每次使用前都要创建一个LinearSearch对象
        int res = LinearSearch_1.search(data, 54);
        System.out.println(res);
//       eg. Math.abs(-2) 类似于这种调用方法
    }
}

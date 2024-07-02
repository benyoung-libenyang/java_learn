//泛型问题

public class LinearSearch_2 {

    private LinearSearch_2(){}

    public static <E> int search(E[] data, E target){
        for(int i = 0; i < data.length; i++)
//            判断两个对象相等
            if(data[i].equals(target))
                return i;
        return -1;
    }

    public static void main(String[] args){
        Integer[] data = {1, 23, 43, 90, 75, 23};
        int res = LinearSearch_2.<Integer>search(data, 23);
//        23:int => E 对象 => 自动转化成类;   类型推断机制
        System.out.println(res);

        Student[] students = {new Student("Alice"),
                            new Student("BObo"),
                            new Student("Benyoung")};
        Student target = new Student("benyoung");
        int res2 = LinearSearch_2.<Student>search(students, target);
        System.out.println(res2);
    }
}

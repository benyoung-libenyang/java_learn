import java.util.Locale;

public class Student {
    private String name;

    public Student(String name){
        this.name = name;
    }

//    进行覆盖， 其中参数的数据类型应该为Object
    @Override
    public boolean equals(Object student) {
        if(this == student)
            return true;
        if(student == null)
            return false;
//        判断两个是不是一个类，如果不是就没有比较的必要了
        if(this.getClass() != student.getClass())
            return false;
//        向下类型转换
        Student another = (Student)student;
        return this.name.toLowerCase().equals(another.name.toLowerCase());

    }
}

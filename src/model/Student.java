package model;

public class Student {
    public int studenId;
    private int studentId;
    private String name;
    public int age;

    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "studentId: " + studentId +
                        ", name: '" + name + '\'' +
                        ", age: " + age;
    }
}

package View;

import model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class View {
    public static void showListStudent(Student[] studentList) {
        System.out.println(Arrays.toString(studentList));
    }
    public static Student[] inputStudent(Student[] studentList){
        Scanner sc = new Scanner(System.in);
        int id = 0;
        if (studentList[0] != null) {
            id = studentList[studentList.length - 1].getStudentId() + 1;
        }
        System.out.print("Input student name: ");
        String studentName = sc.nextLine();
        System.out.print("Input student age: ");
        int age = Integer.parseInt(sc.nextLine());
        Student newStudent = new Student(id, studentName, age);
        if (studentList[0] == null) {
            studentList[0] = newStudent;
        } else {
            Student[] newStudentArr = new Student[studentList.length + 1];
            for (int i = 0; i < studentList.length; i++) {
                newStudentArr[i] = studentList[i];
            }
            newStudentArr[newStudentArr.length - 1] = newStudent;
            studentList = new Student[studentList.length + 1];
            for (int i = 0; i < newStudentArr.length; i++) {
                studentList[i] = newStudentArr[i];
            }
            studentList[studentList.length - 1] = newStudent;
        }
        System.out.println("Them moi hoc sinh thanh cong \n");

        return studentList;
    }
}

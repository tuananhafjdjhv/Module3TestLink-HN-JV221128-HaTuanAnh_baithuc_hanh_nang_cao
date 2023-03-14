package main;

import model.Student;

import java.util.Arrays;
import java.util.Scanner;

import static View.View.inputStudent;
import static View.View.showListStudent;

public class Navbar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] studentArr = new Student[3];
        studentArr[0] = new Student(1, "Nguyễn Văn A", 20);
        studentArr[1] = new Student(2, "Nguyễn Van B", 21);
        studentArr[2] = new Student(3, "Nguyễn Van C", 22);

        Student[] studentList = new Student[1];
        while (true) {
            System.out.println(
                    "------------ | MENU |------------ \n" +
                            "1: Show List Student \n" +
                            "2: Create Student \n" +
                            "3: Update Student \n" +
                            "4: Delete Student \n" +
                            "5: Sort Student By Age ASC \n" +
                            "6: Exit \n"
            );
            int choi = Integer.parseInt(sc.nextLine());
            if (choi != 6) {
                switch (choi) {
                    case 1:
                        System.out.println("List Student: "+ Arrays.toString(studentArr));
                        break;
                    case 2:
                        studentArr = inputStudent(studentArr);
                        break;
                    case 3:
                        if (studentArr[0] != null) {
                            updateStudent(studentArr);
                        } else {
                            System.out.println(" ");
                        }
                        break;
                    case 4:
                        if (studentArr[0] != null) {
                            studentArr = removeStudent(studentArr);
                        } else {
                            System.out.println("");
                        }
                        break;
                    case 5:
                        if (studentArr[0] != null) {
                            sortStudent(studentArr);
                            System.out.println("Mảng mới sau khi sắp xếp: " + Arrays.toString(studentArr));
                        } else {
                            System.out.println("");
                        }
                        break;
                }
            } else {
                System.exit(0);
                return;
            }
        }
    }

   public static void sortStudent(Student[] studentList) {
        Student temp;
        for (int i = 0; i < studentList.length; i++) {
            for (int j = i + 1; j < studentList.length; j++) {
                if (studentList[i].age > studentList[j].age) {
                    temp = studentList[j];
                    studentList[j] = studentList[i];
                    studentList[i] = temp;
                }
            }
        }

    }

    private static Student[] removeStudent(Student[] studentArr) {
        Student[] newArr = new Student[studentArr.length - 1];
        int j = 0;
        for (Student student : studentArr) {
            int delId = 0;
            if (student.studenId == delId) {
                continue;
            }
            newArr[j] = student;
            j++;
        }
        return newArr;

    }

    private static void updateStudent(Student[] studentList) {
        showListStudent(studentList);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id sinh vien can sua: ");
        int studentId = Integer.parseInt(sc.nextLine());
        int editStudentIndex = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getStudentId() == studentId) {
                editStudentIndex = i;
            }
        }
        System.out.println("Sinh vien can sua la :");
        System.out.println(studentList[editStudentIndex]);
        System.out.println("Nhap ten sinh vien: ");
        String newName = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        int newAge = Integer.parseInt(sc.nextLine());
        studentList[editStudentIndex].setName(newName);
        studentList[editStudentIndex].setAge(newAge);
        System.out.println("Update thanh cong");
    }
}

package shinu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================");
        System.out.println("   ЗАДАНИЕ 1   ");
        System.out.println("=================");

        List<Student> studentsClass = new ArrayList<Student>();

        List<Integer> grades1 = new ArrayList<Integer>(List.of(4, 2, 3, 5));
        studentsClass.add(new Student("Qwen", "QAQAQA", 2, grades1));

        List<Integer> grades2 = new ArrayList<Integer>(List.of(2, 2, 2, 5));
        studentsClass.add(new Student("Qweq", "QWAQWAQWA", 2, grades2));

        List<Integer> grades3 = new ArrayList<Integer>(List.of(4, 1, 2, 5));
        studentsClass.add(new Student("Shmek", "AHAHAHA", 2, grades3));

        CourseManager courseManager = new CourseManager();
        courseManager.processStudents(studentsClass);

        printStudents(new HashSet<>(studentsClass), 3);
    }

    public static void printStudents(Set<Student> students, int course) {
        boolean found = false;
        for (Student student : students) {
            if (student.course == course) {
                System.out.println("Студент " + student.name + " обучается на " + course + " курсе");
                found = true;
            }
        }
        if (!found) {
            System.out.println("На " + course + "курсе " + "студентов не найдено.");
        }

        System.out.println("=================");
        System.out.println("   ЗАДАНИЕ 2   ");
        System.out.println("=================");

        Phonebook myBook = new Phonebook();

        myBook.add("Иванов", "89991112233");
        myBook.add("Иванов", "89995556677");
        myBook.add("Петров", "89001234567");
        myBook.add("Сидоров", "89110000000");

        System.out.println("Результаты поиска:");
        myBook.get("Иванов");
        myBook.get("Петров");
        myBook.get("Смирнов");
    }
}
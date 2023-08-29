package algorithm.firstLevel.challenge;

import java.util.HashSet;


public class FirstLevelWork {
    //初始化链表，添加虚拟节点
    public static Student head = new Student("kylin","FullStack");

    public static void main(String[] args) {
        //初始化数据
        Student student1 = new Student("aa","Java");
        Student student2 = new Student("ab","Java");
        Student student3 = new Student("ba","CPP");
        Student student4 = new Student("bb","CPP");
        Student student5 = new Student("ca","Python");
        Student student6 = new Student("cb","Python");
        addStudentEnd(student1);
        addStudentEnd(student2);
        addStudentEnd(student3);
        addStudentEnd(student4);
        addStudentEnd(student5);
        addStudentEnd(student6);
        list();
        System.out.println("#######分隔符#########");
        //测试开始
        Student student7 = new Student("ac","Java");
        Student student8 = new Student("bc","CPP");
        Student student9 = new Student("cc","Python");
        addStudent(student7);
        addStudent(student8);
        addStudent(student9);
        list();
        System.out.println("#######分隔符#########");
        Student student10 = new Student("dd","Python3");
        addStudent(student10);
        list();
    }

    public static void addStudent(Student student){
        String language = student.language;
        if (!checkLanguage(language) || language.equals(getLanguageEnd())){
            addStudentEnd(student);
            return;
        }
        Student temp = head;
        while (temp.next != null){
            if (temp.next.language.equals(language)){
                break;
            }
            temp = temp.next;
        }

        while (temp.next != null){
            if (!temp.next.language.equals(language)){
                student.next = temp.next;
                temp.next = student;
                break;
            }
            temp = temp.next;
        }
    }

    public static void addStudentEnd(Student student){
        Student temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = student;
    }

    public static Boolean checkLanguage(String language){
        HashSet<String> hashSet = new HashSet();
        Student temp = head;
        while (temp != null){
            hashSet.add(temp.language);
            temp = temp.next;
        }
        if (hashSet.contains(language)){
            return true;
        }
        return false;
    }

    public static String getLanguageEnd(){
        Student temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp.language;
    }

    public static void list(){
        Student temp = head.next;
        while (temp.next != null){
            System.out.println(temp.toString() + " ");
            temp = temp.next;
        }
        System.out.println(temp.toString());
    }
}


class Student {
    public String name;
    public String language;
    Student next;

    public Student(String name,String language){
        this.name = name;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
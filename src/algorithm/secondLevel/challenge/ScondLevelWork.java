package algorithm.secondLevel.challenge;



public class ScondLevelWork {
    public static void main(String[] args) {
        Student originalList = new Student(-1);
        Student temp = originalList;
        for (int i = 1; i <= 10; i++) {
            Student student = new Student(i);
            temp.next = student;
            temp = student;
        }
        Student cur = originalList.next;
        Student evenList = new Student(-1);
        Student evenListTemp = evenList;
        Student oddList = new Student(-1);
        Student oddListTemp = oddList;
        while (cur != null) {
            Student student = new Student(cur.id);
            int num = cur.id % 2;
            if (num == 0){
                evenListTemp.next = student;
                evenListTemp = student;
            }else {
                oddListTemp.next = student;
                oddListTemp = student;
            }
            cur = cur.next;
        }
        Student evenReverList = reverseList(evenList.next);
        Student oddReverList = oddList.next;
        Student result = mergeList(evenReverList, oddReverList);
        list(result);
    }

    public static Student mergeList(Student even,Student odd) {
        Student result = new Student(-1);
        Student temp = result;
        while (odd != null){
            Student tmp = odd.next;
            temp.next = odd;
            temp = temp.next;
            temp.next = even;
            temp = temp.next;
            odd = tmp;
            even = even.next;
        }
        return result.next;
    }

    public static Student reverseList(Student head) {
        Student cur = head;
        Student pre = null;
        while (cur != null) {
            Student temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void list(Student student) {
        Student temp = student;
        while (temp.next != null) {
            System.out.print(temp.toString() + " ");
            temp = temp.next;
        }
        System.out.println(temp.toString());
    }
}


class Student {
    int id;
    Student next;

    public Student(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
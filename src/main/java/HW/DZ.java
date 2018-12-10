package HW;

import java.sql.SQLException;

public class DZ {
    public static void main(String[] args) throws SQLException {

        int[] arr1 = {1, 2, 6, 4, 7, 9, 0};
        printArr(arr1);
        int[] res = dz1(arr1);
        printArr(res);
        int[] arr2 = {1, 2, 6, 4, 7, 4, 0};
        printArr(arr2);
        res = dz1(arr2);
        printArr(res);
        int[] arr3 = {4, 2, 6, 6, 7, 9, 9};
        printArr(arr3);
        res = dz1(arr3);
        printArr(res);
        int[] arr4 = {1, 2, 6, 4, 7, 9, 4};
        printArr(arr4);
        res = dz1(arr4);
        printArr(res);
        int[] arr5 = {1, 2, 6, 6, 7, 9, 0};
        printArr(arr5);
        try {
            res = dz1(arr5);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        printArr(res);

        boolean res2 = dz2(arr1);
        System.out.println(res2 ? "true" : "false");
        res2 = dz2(arr2);
        System.out.println(res2 ? "true" : "false");
        res2 = dz2(arr3);
        System.out.println(res2 ? "true" : "false");
        res2 = dz2(arr4);
        System.out.println(res2 ? "true" : "false");
        res2 = dz2(arr5);
        System.out.println(res2 ? "true" : "false");

        SQLService.connect();
        Student student = new Student(6, "Fedorov", 80);
        student.print();
        SQLService.addStudent(student);
        SQLService.addStudent(student);
        student = SQLService.getStudent("Fedorov");
        student.print();
        student.setBall(70);
        student.print();
        SQLService.changeStudent(student);
        student = SQLService.getStudent("Fedorov");
        student.print();
        SQLService.deleteStudent(student);
    }
    public static int[] dz1(int[] arr) {
        int last4 = -1;
        for(int i = 0; i < arr.length; i++) if(arr[i] == 4) last4 = i;
        if(last4 == -1){
            throw new RuntimeException();
        }
        else {
            if(last4 == arr.length -1) return null; // при последней 4  на выходе пустой массив
            else {
                int[] res = new int[arr.length - last4 - 1];
                System.arraycopy(arr, last4 + 1, res, 0, res.length);
                return res;
            }
        }
    }
    public static boolean dz2(int[] arr) {
        boolean one = false;
        boolean four = false;
        for(int i : arr) {
            if(i == 1) four = true;
            if(i == 4) one = true;
            if(one && four) return true;
        }
        return false;
    }
    private  static void printArr (int[] arr) {
        if(arr != null) {
            StringBuilder str = new StringBuilder();
            for (int o : arr) {
                str.append(o);
                str.append(" ");
            }
            System.out.println(str);
        }
    }
}

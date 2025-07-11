import java.io.*;
class Day11_TASK8 {
    public static void main(String args[]) {
        File oldFile = new File("FileName4.txt");
        File newFile = new File("RenamedFile04.txt");
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Rename failed.");
        }

    }
}
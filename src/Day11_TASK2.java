import java.io.*;
public class Day11_TASK2
{
    public static void main(String args[])
    {
        FileInputStream infile = null;
        int b;
        try
        {
            infile = new FileInputStream("FileName1.txt");
            while((b = infile.read()) != -1)
            {
                System.out.println((char)b);
            }
            infile.close();
        }
        catch(IOException e)
        {
            System.out.println("Sorry..!! File Not Found...!!!");
        }
    }
}

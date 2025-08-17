import java.util.*;

public class LinearSearch
{
    public static int linearSearch(int[] arr, int target)
    {
        int n = arr.length;
        for(int i = 0; i<=n; i++)
        {
            if(arr[i]==target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 8, 24, 52, 7, 35};
        int target = 7;
        int index = linearSearch(arr,target);
        System.out.println("Index of the target is : " + index);
    }
}

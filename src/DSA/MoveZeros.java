package DSA;
import java.util.*;

public class MoveZeros
{
    public int[] moveZeroes(int n, int[] arr)
    {
        int j=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                j=i;
                break;
            }
        }
        if(j==-1)
        {
            return arr;
        }
        for(int i=j+1;i<n;i++)
        {
            if(arr[i]!=0)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args)
    {
        MoveZeros mz = new MoveZeros();
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        int n = arr.length;
        mz.moveZeroes(n, arr);
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i] + " ");
        }
        System.out.println(" ");
    }
}

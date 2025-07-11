package DSA;

public class LargestElement
{
    public static int FindLargestElement(int[] arr)
    {
        int max=arr[0];
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        int[] arr={5, 3,2,1,0,9};
        System.out.println(" The Largest Element in an Array is : " + FindLargestElement(arr));
    }
}

public class TASK027
{
    public static int sum (int[] arr)
    {
        int s=0;
        for(int i=0; i<arr.length; i++)
        {
            s+=arr[i];

        }
        System.out.println("Sum of Array is : " + s);
        return s;
    }
    public static void main(String[] args)
    {
        int[] arr = {9,6,2,1};

        sum(arr);
    }
}
package DSA;

public class RemoveDup
{
    public int RemoveDuplicates(int[] arr)
    {
        if(arr.length == 0)
        {
            return 0;
        }
        int i=0;
        for(int j=1;j<arr.length;j++)
        {
            if(arr[j]!=arr[i])
            {
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args)
    {
        int[] arr = {0,1,1,5,5,7};
        RemoveDup RD = new RemoveDup();
        int res = RD.RemoveDuplicates(arr);
        for(int j=0;j<res;j++)
        {
            System.out.println(arr[j]+" ");
        }

    }
}

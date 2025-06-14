public class TASK029 {

    public static void main(String[] args)
    {
        int intArray[] = {1,2,3,4};
        int cloneArray[]= intArray.clone();
        System.out.println(intArray==cloneArray);
        for(int i=0;i<cloneArray.length;i++)
        {
            System.out.println(cloneArray[i]+" ");
        }
        // TODO Auto-generated method stub

    }

}

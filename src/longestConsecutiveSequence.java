import java.util.*;
public class longestConsecutiveSequence
{
    public static int longestConsecutive(int[] a)
    {
        int n = a.length;
        if(n==0) return 0;
        int longest = 1;
        Set<Integer> s= new HashSet<>();
        for(int i=0; i<n; i++)
        {
            s.add(a[i]);
        }
        for(int it : s)
        {
            if(!s.contains(it-1))
            {
                int cnt=1;
                int x=it;
                while(s.contains(x+1))
                {
                    x=x+1;
                    cnt=cnt+1;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a = {100,200,1,2,3,4};
        int ans = longestConsecutive(a);
        System.out.println(ans);
    }
}

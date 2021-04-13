package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1715 {
    /*Description
    *Given an array A of 0 and 1, divide the array into 3 non-empty parts
    * such that all of these parts represent the same binary value.
    * If it is possible, return any [i, j] with i+1 < j, such that:
    * A[0], A[1], ..., A[i] is the first part
    * A[i+1], A[i+2], ..., A[j-1] is the second part, and
    * A[j], A[j+1], ..., A[A.length - 1] is the third part.
    * All three parts have equal binary value.
    * If it is not possible, return [-1, -1].
    * Note that the entire part is used when considering what binary value it represents.
    * For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed,
    * so [0,1,1] and [1,1] represent the same value.
    * */

    public int[] threeEqualParts(int[] A) {
        int[] result=new int[]{-1,-1};
        int sum=0;
        for(int cur:A)
            sum+=cur;
        if(sum%3!=0)
            return result;
        if(sum==0)
            return new int[]{0,A.length-1};
        sum/=3;
        int i1=0,i2=0,i3=0,j1=0,j2=0,j3=0;
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==1){
                count++;
                if(count==1)
                    i1=i;
                if(count==sum)
                    j1=i;
                if(count==sum+1)
                    i2=i;
                if(count==2*sum)
                    j2=i;
                if(count==2*sum+1)
                    i3=i;
                if(count==3*sum)
                    j3=i;
            }
        }
        int[] part1= Arrays.copyOfRange(A,i1,j1);
        int[] part2= Arrays.copyOfRange(A,i2,j2);
        int[] part3= Arrays.copyOfRange(A,i3,j3);
        if(!Arrays.equals(part1,part2)||!Arrays.equals(part1,part3))
            return result;
        int left=A.length-j3-1;
        if(i3-j2<=left||i2-j1<=left)
            return result;
        return new int[]{j1+left,j2+left};
        //
    }
}

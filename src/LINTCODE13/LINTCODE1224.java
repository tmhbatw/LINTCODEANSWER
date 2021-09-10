package LINTCODE13;

public class LINTCODE1224 {
    /*Description
    *
    * */

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int length1=s1.length();
        int length2=s2.length();
        int index=0;
        int count=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<length1;j++){
                if(c1[j]==c2[index]){
                    index++;
                    if(index==length2){
                        count++;
                        index=0;
                    }
                }
            }
        }
        return count/n2;
        // Write your code here
    }
}

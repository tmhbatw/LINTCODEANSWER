package LINTCODE5;

public class LINTCODE445 {

    /*Description
    * 余弦相似性是内积空间的两个矢量之间的相似性的度量，其测量它们之间的角度的余弦。 0° 的余弦为 1，对于任何其他角度，余弦小于 1。
    *
    * */

    /*Solution
    * 根据公式进行计算即可
    * */

    public double cosineSimilarity(int[] A, int[] B) {
        double result=0.0;
        double a=0.0;
        double b=0.0;
        for(int i=0;i<A.length;i++){
            result+=A[i]*B[i];
            a+=A[i]*A[i];
            b+=B[i]*B[i];
        }
        if(a==0||b==0)
            return 2.0000;
        return result/(Math.sqrt(a)*Math.sqrt(b));
        // write your code here
    }
}

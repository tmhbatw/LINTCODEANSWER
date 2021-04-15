package LINTCODE10;

public class LINTCODE963 {
    /*Description
    * 题目难度分为“简单题”、“中等题”、“难题”三个等级。评委们已经出好了
    * E 道简单题，
    * M 道中等题，
    * H 道难题。然后评委们又出了
    * EM道“简中”题和
    * MH 道“中难”题。
    * 所谓的“简中题”是指该类型的题既可以归类为“简单题”也可以归类为“中等题”。所谓的“中难题”是指该类型的题既可以归类为“中等题”也可以归类为“难题”。
    * 评委们规定：一场比赛必须包含 3 道题，其中 1 题是“简单题”， 1 题是“中等题”， 1 题是“难题”。每道题目至多只能出现在一场比赛中。
    * 现在，评委们最多可以组织多少场比赛？
    * */

    //二分法，真是特么赖皮啊
    public long theNumberOfContests(long E, long EM, long M, long MH, long H) {
        long left=0,right=(E+EM+M+MH+H)/3;
        System.out.println(left+" "+right);
        while(left<=right){
            long mid=left+(right-left)/2;

            boolean match=isMatch(E,EM,M,MH,H,mid);
            if(match&&!isMatch(E,EM,M,MH,H,mid+1))
                return mid;
            if(match)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
        // write your code here.
    }

    private boolean isMatch(long E,long EM,long M,long MH,long H,long mid){
        if(E<mid){
            if(EM<mid-E)
                return false;
            EM-=mid-E;
        }
        if(H<mid){
            if(MH<mid-H)
                return false;
            MH-=mid-H;
        }
        if(M+EM+MH<mid)
            return false;
        return true;
    }

}

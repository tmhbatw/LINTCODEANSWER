package LINTCODE11;

import datastructure.Square;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1077 {
    /*Description
    * 在x轴上，按指定顺序放下给定的方块。第i个方块（position[i] = (left, side_length))
    * 是一个最左端点在positions[i][0]而且边长为positions[i][1]的方块。方块放置时底边与x轴平行，
    * 且要叠于底边有重叠的方块之上。在下一方块放入前须放入之前所有方块。彼此侧边相邻的方块不会叠放。
    * 返回高度列表，其中高度ans[i]表示在放入第0块，第1块，...，第i块方块后当前最高高度。
    * */

    class Square{
        int left;
        int right;
        int height;
        public Square(int left, int right, int height){
            this.left=left;
            this.right=right;
            this.height=height;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result=new ArrayList<>();
        List<Square> list=new ArrayList<>();
        for(int[] cur:positions){
            int height=0;
            int l=cur[0];
            int r=cur[0]+cur[1];
            int res=0;
            for(Square s:list){
                res=Math.max(res,s.height);
                if(l>=s.right||r<=s.left)
                    continue;
                height=Math.max(height,s.height);
            }
            height+=cur[1];
            list.add(new Square(l,r,height));
            res=Math.max(res,height);
            result.add(res);
        }
        return result;
        // write your code here
    }
}

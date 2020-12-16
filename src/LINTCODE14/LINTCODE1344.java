package LINTCODE14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LINTCODE1344 {
    /*Description
    * 给定一个n * m的矩阵，你可以通过副对角线方向循环遍历的方式得到(n + m) - 1 个列表，返回一个排好序的列表集合
    * */
    public List<List<String>> CounterDiagonalSort(List<List<String>> grids) {
        int length=grids.size();
        int number=grids.get(0).size();
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<length;i++){
            List<String> res=new ArrayList<>();
            int index=i;
            int j=0;
            while(index>=0&&j<number){
                res.add(grids.get(index--).get(j++));
            }
            fill(res,Math.min(length,number));
            result.add(res);
        }
        for(int j=1;j<number;j++){
            List<String> res=new ArrayList<>();
            int i=length-1,jj=j;
            while(i>=0&&jj<number){
                res.add(grids.get(i--).get(jj++));
            }
            fill(res,Math.min(length,number));
            result.add(res);
        }
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                for(int i=0;i<o1.size()&&i<o2.size();i++){
                    char c1=o1.get(i).charAt(0);
                    char c2=o2.get(i).charAt(0);
                    if(c1<c2)
                        return -1;
                    if(c1>c2)
                        return 1;
                }
                return 0;
            }
        });
        return result;
        // write your code here
    }

    public void fill(List<String> list,int length){
        int lack=length-list.size();
        for(int i=0;i<lack;i++)
            list.add(list.get(i));
    }
}

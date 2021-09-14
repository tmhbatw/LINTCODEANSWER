package LINTCODE11;

import java.util.HashMap;
import java.util.TreeMap;

public class LINTCODE1074 {
    /*Description
    * 范围模块是跟踪数字范围的模块。 您的任务是以有效的方式设计和实现以下接口。
    * addRange(int left，int right): 添加左闭右开[left，right)的区间，
    * 跟踪区间中的每个实数。 如果添加的区间里与已经跟踪的实数部分重合，那么就把区间内没有跟踪的实数也加进去。
    * queryRange(int left，int right): 当且仅当当前[left，right)中的每个实数都被跟踪时，返回true。
    * removeRange(int left，int right): 停止跟踪[left，right)区间内当前已经跟踪的每个实数。
    * */

    class Solution {

        TreeMap<Integer,Boolean> map;

        public Solution() {
            this.map=new TreeMap<>();
        }

        public void addRange(int left, int right) {
            boolean pre=false;

            if(map.floorKey(left)==null||!map.get(map.floorKey(left))){
                map.put(left,true);
            }else{
                pre=true;
            }

            Integer start=left;
            while(true){
                start=map.ceilingKey(start+1);
                if(start==null){
                    map.put(right,false);
                    break;
                }
                if(start<right){
                    pre=map.get(start);
                    map.remove(start);
                }
                else if(start==right){
                    if(map.get(start)){
                        map.remove(start);
                    }
                    break;
                }else{
                    if(!pre)
                        map.put(right,false);
                    break;
                }
            }
            //write your code here
        }

        public boolean queryRange(int left, int right) {
            //System.out.println(map+" "+left+" "+right);
            if(map.floorKey(left)==null||!map.get(map.floorKey(left)))
                return false;
            return map.ceilingKey(left+1)>= right;
            //write your code here
        }

        public void removeRange(int left, int right) {
            boolean pre=true;
            if(map.containsKey(left)&&map.get(left))
                map.remove(left);
            else if(map.floorKey(left)!=null&&map.get(map.floorKey(left))){
                map.put(left,false);
            }else{
                pre=false;
            }
            Integer start=left;
            while(true){
                start=map.ceilingKey(start+1);
                if(start==null){
                    break;
                }
                if(start<right){
                    pre=map.get(start);

                    map.remove(start);
                }
                else{
                    if(start==right&&!map.get(start)){
                        break;
                    }
                    if(pre)
                        map.put(right,true);
                    break;
                }
            }
            //write your code here
        }
    }
}

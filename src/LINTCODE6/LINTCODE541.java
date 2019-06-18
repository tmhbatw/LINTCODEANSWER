package LINTCODE6;

import java.util.List;

public class LINTCODE541 {

    List<List<Integer>> vec;
    int size=0;
    int curr=0;
    int index=0;
    public LINTCODE541 (List<List<Integer>> vecs) {
        this.vec=vecs;
        for(List<Integer> list:vec){
            size+=list.size();
        }
        // do intialization if necessary
    }

    /*
     * @return: An integer
     */
    public int next() {

        while(index>=vec.get(curr).size()){
            if(curr==vec.size()-1){
                index++;
                curr=0;
            }else{
                curr++;
            }
        }
        size--;
        if(curr==vec.size()-1){
            curr=0;
            index++;
            return vec.get(vec.size()-1).get(index-1);
        }
        curr++;
        return vec.get(curr-1).get(index);
        // write your code here
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return size>0;
        // write your code here
    }
}

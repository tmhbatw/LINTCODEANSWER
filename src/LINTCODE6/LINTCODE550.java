package LINTCODE6;


import java.util.*;

public class LINTCODE550 {

    /*Description
    * 在实时数据流中找到最常使用的k个单词.
    * 实现TopK类中的三个方法:
    * TopK(k), 构造方法
    * add(word), 增加一个新单词
    * topk(), 得到当前最常使用的k个单词.
    * */

    /*Solution
    *
    * */

    class Point{
        String word;
        int val;
        public Point(String word,int val){
            this.word=word;
            this.val=val;
        }
    }

    int k;
    PriorityQueue<Point> queue=new PriorityQueue<>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.val==o2.val){
                return o2.word.compareTo(o1.word);
            }
            return o1.val-o2.val;
        }
    });
    HashMap<String,Integer> map=new HashMap<>();

    public LINTCODE550(int k) {
        this.k=k;
        // do intialization if necessary
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        if(map.containsKey(word)){
            Iterator<Point> i=queue.iterator();
            while(i.hasNext()){
                Point curr=i.next();
                if(curr.word.equals(word)) {
                    i.remove();
                    break;
                }
            }
            map.put(word,map.get(word)+1);
            queue.add(new Point(word,map.get(word)));
        }else{
            map.put(word,1);
            queue.add(new Point(word,1));
        }
        if(queue.size()==k+1)
            queue.poll();
        // write your code here
    }

    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        
        List<Point> result=new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(0,  queue.poll());
        }
        queue.addAll(result);
        List<String> res=new ArrayList<>();
        for(Point curr:result){
            res.add(curr.word);
        }
        return res;
        // write your code here
    }


}

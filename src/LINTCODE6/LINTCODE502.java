package LINTCODE6;

import java.util.*;

public class LINTCODE502 {
    /*Description
    * Cassandra是一个NoSQL数据库（又称键值存储）。Cassandra中的一个单独数据条目由3部分构成：
    * row_key (相当于散列密钥、分区密钥或分片密钥)column_key、value
    * row_key 用于哈希，不支持范围查询。我们将其简化为字符串。
    * column_key 已排序并支持范围查询。我们将其简化为整数。
    * value 是一个字符串。你可以将任何数据序列化为字符串并将其存储在值中。
    * 现在要实现下面两个方法：
    * insert(row_key, column_key, value)
    * query(row_key, column_start, column_end) 返回条目列表
    * */

    public class Column {
        public int key;
        public String value;
        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public class MiniCassandra {
        Map<String,TreeMap<Integer,String>> map;
        public MiniCassandra() {
            this.map=new HashMap<>();
            // do intialization if necessary
        }

        /*
         * @param raw_key: a string
         * @param column_key: An integer
         * @param column_value: a string
         * @return: nothing
         */
        public void insert(String row_key, int column_key, String value) {
            if(!map.containsKey(row_key))
                map.put(row_key,new TreeMap<>());
            TreeMap<Integer,String> cur=map.get(row_key);
            cur.put(column_key,value);
            // write your code here
        }

        /*
         * @param row_key: a string
         * @param column_start: An integer
         * @param column_end: An integer
         * @return: a list of Columns
         */
        public List<Column> query(String row_key, int column_start, int column_end) {
            List<Column> result=new ArrayList<>();
            TreeMap<Integer,String> cur=map.getOrDefault(row_key,new TreeMap<>());
            column_start--;
            while(cur.higherKey(column_start)!=null){
                column_start=cur.higherKey(column_start);
                if(column_start>column_end)
                    break;
                result.add(new Column(column_start,cur.get(column_start)));
            }
            return result;
            // write your code here
        }
    }


    public static void main(String[] args){
        TreeMap<Integer,String> map=new TreeMap<>();
        map.put(1,"111");
        map.put(2,"222");
        map.put(3,"333");
        int start=1,end=2;
        start--;
        while(map.higherKey(start)!=null) {
            start = map.higherKey(start);
            if (start > end)
                break;
            System.out.println(map.get(start));

        }
    }
}

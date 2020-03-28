package LINTCODE10;

import java.util.*;

public class LINTCODE997 {
    /*Description
    *按员工姓名，上一级姓名，职位，年份给出一系列企业中员工的关系，输出企业成员组织结构图。
    * */

    class Person{
        String name;
        int relationshipIndex;
        private Person(String name,int relationshipIndex){
            this.name=name;
            this.relationshipIndex=relationshipIndex;
        }
    }

    public List<String> getOrganization(List<List<String>> relationship) {
        Comparator<Person> comparator=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String oo1=o1.name;
                String oo2=o2.name;
                return oo1.compareTo(oo2);
            }
        };
        Map<String, PriorityQueue<Person>> map=new HashMap<>();
        int relationshipNumber=relationship.size();
        int boss=0;
        for(int i=0;i<relationshipNumber;i++){
            List<String> cur=relationship.get(i);
            String curBoss=cur.get(1);
            if(!curBoss.equals("NULL")) {
                PriorityQueue<Person> list = map.getOrDefault(curBoss,new PriorityQueue<Person>(comparator));
                list.add(new Person(cur.get(0),i));
                map.put(curBoss,list);
            }else{
                boss=i;
            }
        }
        List<String> result=new ArrayList<>();
        result.add(getMessage(boss,relationship,""));
        getResult(boss,relationship,map,"-",result);
        return result;
        // Write your code here
    }

    private void getResult(int index,List<List<String>> relationship,Map<String,PriorityQueue<Person>> map,String prefix,List<String> result){
        PriorityQueue subordinate= map.getOrDefault(relationship.get(index).get(0),new PriorityQueue<Person>());
        while(!subordinate.isEmpty()){
            Person cur= (Person) subordinate.poll();
            result.add(getMessage(cur.relationshipIndex,relationship,prefix));
            getResult(cur.relationshipIndex,relationship,map,prefix+"-",result);
        }

    }

    private String getMessage(int index,List<List<String>> relationship,String prefix){
        List<String> target=relationship.get(index);
        return prefix+target.get(0)+" ("+target.get(2)+") "+target.get(3);
    }
}

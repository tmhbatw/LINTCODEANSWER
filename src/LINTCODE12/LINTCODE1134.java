package LINTCODE12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1134 {
    /*Description
    * 给定一个目录信息列表（包含目录路径），以及该目录中包含内容的所有文件，你需要根据路径查找文件系统中所有重复文件组。
    * 一组重复文件包含至少两个具有相同内容的文件。
    * 输入信息列表中的单个目录信息字符串具有如下格式：
    * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
    * 这代表在目录root/d1/d2/.../dm中有 n 个文件 (f1.txt, f2.txt ... fn.txt，内容分别为 f1_content, f2_content ... fn_content). 注意n >= 1 并且 m >= 0。 如果 m = 0， 这意味着这个目录正好是根目录。
    * 输出一个包含重复文件路径的列表。对于每一个组，包含所有的具有相同内容的文件路径。一个文件路径是一个具有以下格式的字符串 A file
    * "directory_path/file_name.txt"
    * */

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        for(String cur:paths){
            String[] curr=cur.split(" ");
            for(int i=1;i<curr.length;i++){
                String[] getContent=curr[i].split("\\(");
                String content=getContent[1].substring(0,getContent[1].length()-1);
                String path=curr[0]+"/"+getContent[0];
                List<String> list=map.getOrDefault(content,new ArrayList<>());
                list.add(path);
                map.put(content,list);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(HashMap.Entry entry:map.entrySet()){
            List<String> list= (List<String>) entry.getValue();
            if(list.size()>1)
                result.add(list);
        }
        return result;
        // Write your code here
    }
}

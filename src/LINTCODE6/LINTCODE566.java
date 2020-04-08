package LINTCODE6;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE566 {
    /*Description
    * 为GFS(Google文件系统)实现一个简单的客户端，提供一下功能：
    * 1.read(文件名)，通过文件名从GFS中读取文件。
    * 2.write(文件名，内容)，通过文件名和内容写入GFS中。
    * 现在有两种已经在基础类中实现的方法：
    * 1.readChunk(文件名，块索引)，从GFS中读取一个块。
    * 2.writeChunk(文件名，块索引，块数据)，向GFS中写入一个块。
    * 为了简化这个问题，我们可以假设块大小为 chunkSize 位的(在真实的文件系统中，是64M)，GFS客户端的任务是将一个文件分为若干块
    * (如果需要的话)并且保存在远端的GFS服务器上，chunkSize会在构造函数中给出，你需要的是实现read和write这两个private方法。
    * */

     class BaseGFSClient {
          private Map<String, String> chunk_list;
          public BaseGFSClient() {}
          public String readChunk(String filename, int chunkIndex) {
              System.out.println("I have read!");
              return "hello world";
              // Read a chunk from GFS
          }
          public void writeChunk(String filename, int chunkIndex,
                                 String content) {
              System.out.println("I have written");
              // Write a chunk to GFS
          }
     }

        class GFSClient extends BaseGFSClient {
            /*
             * @param chunkSize: An integer
             */
            int chunkSize;
            Map<String,Integer> chunkNum;
            public GFSClient(int chunkSize) {
                this.chunkSize=chunkSize;
                chunkNum=new HashMap<>();
                // do intialization if necessary
            }

            /*
             * @param filename: a file name
             * @return: conetent of the file given from GFS
             */
            public String read(String filename) {
                if(!chunkNum.containsKey(filename))
                    return null;
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<chunkNum.get(filename);i++)
                    sb.append(readChunk(filename,i));
                return sb.toString();
                // write your code here
            }

            /*
             * @param filename: a file name
             * @param content: a string
             * @return: nothing
             */
            public void write(String filename, String content) {
                int length=content.length();
                int num=(length-1)/chunkSize+1;
                chunkNum.put(filename,num);
                for(int i=0;i<num;i++){
                    int start=i*chunkSize;
                    int end=Math.min(length,(i+1)*chunkSize);
                    writeChunk(filename,i,content.substring(start,end));
                }
                // write your code here
            }
        }
}

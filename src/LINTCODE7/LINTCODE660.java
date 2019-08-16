package LINTCODE7;

public class LINTCODE660 {

    /*Description
    * 接口：int read4(char * buf)一次从文件中读取 4 个字符。
    * 返回值是实际读取的字符数。 例如，如果文件中只剩下 3 个字符，则返回 3。
    * 通过使用read4 接口，实现从文件读取 n 个字符的函数int read(char * buf，int n)。
    * */
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */


    int read4(char[] buf){
        return 0;
    }

    char[] buffer=new char[4];
    int lastindex=0;
    int lastNumber=0;
    boolean exist=true;
    public int read(char[] buf, int n) {
        if(!exist)
            return 0;
        int index=0;
        while(index<n){
            if(lastindex==lastNumber){
                read();
            }
            if(!exist){
                return index;
            }
            buf[index++]=buffer[lastindex++];
        }
        return index;
        // Write your code here
    }

    private void read(){
        lastNumber=read4(buffer);
        lastindex=0;
        if(lastNumber==0)
            exist=false;
        System.out.println(new String(buffer));
    }
}

package LINTCODE8;

public class LINTCODE748 {
    /*Description
    *Design Kindle, which can support 3 type of book format: PDF, MOBI and EPUB.
    * Consider using ENUM for book format.
    * Consider using simple factory to create reader for each format.
    * */

    public class Kindle {

        EBookReaderFactory factory;

        public Kindle() {
            this.factory=new EBookReaderFactory();
            //write your code here
        }

        public String readBook(Book book) throws Exception {
            EBookReader reader= factory.createReader(book);
            return reader.readBook();
            //write your code here
        }

        public void downloadBook(Book b) {
            //write your code here
        }

        public void uploadBook(Book b) {
            //write your code here
        }

        public void deleteBook(Book b) {
            //write your code here
        }
    }

    enum Format {
        EPUB("epub"), PDF("pdf"), MOBI("mobi");

        private String content;

        Format(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    class Book {
        private Format format;

        public Book(Format format) {
            this.format = format;
        }

        public Format getFormat() {
            return format;
        }
    }

    abstract class EBookReader {

        protected Book book;

        public EBookReader(Book b){
            this.book = b;
        }

        public abstract String readBook();
        public abstract String displayReaderType();
    }

    class EBookReaderFactory {

        public EBookReader createReader(Book b) {
            Format bookFormat=b.getFormat();
            if(bookFormat==Format.EPUB){
                return new EpubReader(b);
            }else if(bookFormat==Format.MOBI)
                return new MobiReader(b);
            else
                return new PdfReader(b);
            //write your code here
        }
    }

    class EpubReader extends EBookReader{

        public EpubReader(Book b) {
            super(b);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String readBook() {
            return "Using EPUB reader, book content is: epub";
            //write your code here
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using EPUB reader";
        }
    }

    class MobiReader extends EBookReader {

        public MobiReader(Book b) {
            super(b);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String readBook() {
            return "Using MOBI reader, book content is: mobi";
            //write your code here
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using MOBI reader";
        }

    }
    class PdfReader extends EBookReader{

        public PdfReader(Book b) {
            super(b);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String readBook() {
            return "Using PDF reader, book content is: pdf";
            //write your code here
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using PDF reader";
        }
    }
}

public class LibraryDriver{
    public static void main(String[]args){
	Book b = new Book("author", "title", 1234);
	b.setAuthor("real Author");
	System.out.println(b.toString());
    }
}

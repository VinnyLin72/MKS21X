public class Book{
    private String author, title;
    private int ISBN;

    public Book(){
    }

    public Book(String a, String t, int i){
	author = a;
	title = t;
	ISBN = i;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public int getISBN(){
	return ISBN;
    }

    public void setAuthor(String new){
	author = new;
    }

    public void setTitle(String new){
	title = new;
    }

    public void setISBN(int new){
	ISBN = new;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }
}

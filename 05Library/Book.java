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

    public void setAuthor(String n){
	author = n;
    }

    public void setTitle(String n){
	title = n;
    }

    public void setISBN(int n){
	ISBN = n;
    }

    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN();
    }
}

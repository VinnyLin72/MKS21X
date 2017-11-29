public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String a, String t, int i, String c){
	super();
	callNumber = c;
    }

    public void getCallNum(){
	return callNumber;
    }

    public void setCallNum(String n){
	callNumber = n;
    }

    public abstract void checkout(String patron, String due){

    }

    public abstract void returned(){

    }

    public abstract String circulationStatus(){

    }
}

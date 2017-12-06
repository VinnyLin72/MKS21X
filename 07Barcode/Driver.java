public class Driver{
    public static void main (String[]args){
	Barcode x = new Barcode("12345");
	Barcode y = new Barcode("00000");
	System.out.println(x.toString());
	System.out.println(x.toZip(y.getCode()));
	System.out.println("" + y.compareTo(x));
    }
}

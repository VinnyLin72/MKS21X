public class Barcode implements Comparable<Barcode>{
    private String barcode;
    private String zipcode;

    public Barcode(String zip){
	zipcode = zip;
	if (zipcode.length() != 5){
	    throw new IllegalArgumentException();
	}
	try{
	    for (int i = 0; i < zip.length(); i ++){
		Integer.parseInt(zip.substring(i, i + 1));
	    }
	}
	catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	barcode = toCode(zipcode);
    }

    public String toString(){
	return barcode + "(" + zipcode + ")";
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public static String toCode(String zip){
	String[] nums = new String[10];
	nums[0] = "||:::";
	nums[1] = ":::||";
	nums[2] = "::|:|";
	nums[3] = "::||:";
	nums[4] = ":|::|";
	nums[5] = ":|:|:";
	nums[6] = ":||::";
	nums[7] = "|:::|";
	nums[8] = "|::|:";
	nums[9] = "|:|::";
	try{
	    int zipsum = 0;
	    String newBar = "";
	    for (int i = 0; i < zip.length(); i ++){
		newBar += nums[Integer.parseInt((zip.charAt(i)))];
		zipsum += (Integer.parseInt(zip.charAt(i)));
	    }
	    newBar = "|" + newBar + nums[zipsum % 10] + "|";
	    return newBar;
	}
	catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
    }

    public static String toZip(String code){
	String[] nums = new String[10];
	nums[0] = "||:::";
	nums[1] = ":::||";
	nums[2] = "::|:|";
	nums[3] = "::||:";
	nums[4] = ":|::|";
	nums[5] = ":|:|:";
	nums[6] = ":||::";
	nums[7] = "|:::|";
	nums[8] = "|::|:";
	nums[9] = "|:|::";
	if (code.length() != 32 || !(code.charAt(0) == '|') || !(code.charAt(code.length() - 1) == '|')){
	    throw new IllegalArgumentException();
	}
	String codenums = "";
	for (int i = 1; i < code.length() - 5; i += 5){
	    String codeNum = code.substring(i, i + 5);
	    for (int n = 0; n < 10 ; n ++){
		if (nums[n].equals(codeNum)) codenums += n;
	    }
	}
	if (codenums.length() != 6) throw new IllegalArgumentException();
	int sumcode = 0;
	for (int i = 0; i < 5; i ++){
	    sumcode += Integer.parseInt((codenums.charAt(i)));
	}
	if (sumcode % 10 != -48 + codenums.charAt(codenums.length() - 1)) throw new IllegalArgumentException();
	return codenums.substring(0, codenums.length() - 1);
    }

    public String getCode(){
	return barcode;
    }

    public String getZip(){
	return zipcode;
    }
}

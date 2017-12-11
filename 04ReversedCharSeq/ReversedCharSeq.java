public class ReversedCharSeq{
    private String Seq;

    public ReversedCharSeq(String s) {
	String temp = "";
	for (int i = s.length() - 1; i >= 0; i --){
	    temp += s.charAt(i);
	}
        Seq = temp;
    }

    public char charAt(int i){
	return Seq.charAt(i);
    }

    public int length(){
	return Seq.length();
    }

    public ReversedCharSeq subSequence(int start, int end){
	String temp = "";
	for (int i = end - 1; i >= start; i --){
	    temp += Seq.charAt(i);    
	}
	ReversedCharSeq sub = new  ReversedCharSeq(temp);
	return sub;
    }

    public String toString(){
	return Seq;
    }

}

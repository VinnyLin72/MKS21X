public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int startcap){
	super(startcap);
    }
    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int i = 0; i < ary.length; i ++){
	    add(ary[i]);
	}
    }
    public void add(int index, String thing){
	super.add(thing);
    }
    public String set(int index, String thing){
	throw new UnsupportedOperationException();
    }
    public boolean add(String thing){
	super.add();
    }

    public int indexOfBinary(String element){
       	int start = 0, end = size();
	while (start != end){
	    if (get((start + end)/2).compareTo(element) > 0){
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2).equals(element)){
		if (start == 0 || !(get((start + end) / 2 - 1).equals(element))){
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	if (get(start) != element){
	    return -1;
	}
	return start;
    }

    public int lastIndexOfBinary(String element){
	int start = indexOfBinary(element), end = size();
	while (start != end){
	    if (get((start + end)/2).compareTo(element) > 0){
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2).equals(element)){
		if (start == size() - 1 || !(get((start + end) / 2 + 1).equals(element))){
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	if (get(start) != element){
	    return -1;
	}
	return start;
    }

}


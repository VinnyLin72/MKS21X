public class SuperArray{
    private String[] data;
    private int size;
    public SuperArray(String[] stuff){
        size = stuff.length;
        data = stuff;
    }
    public void clear(){
	data = new String[size];
    }
    public int size(){
        return this.size;
    }
    public boolean add(String thing){
        resize();
        data[size-1] = thing;
        return true;
    }
    public String toString(){
        String output = "";
	for (int i = 0; i < data.length; i ++){
            output += data[i] + ", ";
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    public String get(int i){
        if (i < size && i > 0)return data[i];
        return "Error: Index out of range";
    }
    public String set(int i, String s){
        String out = data[i];
        if (i < size && i > 0)data[i] = s;
        return out;
    }
    public boolean isEmpty(){
        for (int i = 0; i < data.length; i ++){
            if (data[i] != null) return false;
        }
        return true;
    }
    private void resize(){
	size ++;
        String[] newdata = new String[size];
        System.arraycopy(data, 0 , newdata, 0, size - 1);
        data = newdata;
    }
    public boolean contains(String thing){
	for (int i = 0; i < size; i ++){
	    if (data[i] == thing) return true;
	}
	return false;
    }
    public int indexOf(String thing){
	for (int i = 0; i < size; i ++){
	    if (data[i] == thing) return i;
	}
	return -1;
    }
    public int lastindexOf(String thing){
	for (int i = size; i > 0; i --){
	    if (data[i] == thing) return i;
	}
	return -1;
    }
    public void add(int i, String thing){
	if (i < 0 || i > size)System.out.println("Error: Index out of range");
	else{
	    resize();
	    for (int in = size-1; in > i; in --){
		data[in]=data[in - 1];
	    }
	    data[i] = thing;
	}
    }
    public String remove(int i){
	if (i < 0 || i > size)return "Error: Index out of range";
	String ans = data[i];
	int place = i;
	for (int in = i+1; in < size; in ++){
	    data[place] = data[in];
	    place ++;
	}
	String[] newdata = new String[size-1];
        System.arraycopy(data, 0 , newdata, 0, size - 1);
        data = newdata;
	return ans;
    }
    public boolean remove(String thing){
	int i = indexOf(thing);
	if (remove(i) != "Error: Index out of range"){
	return true;
	}
	return false;
    }
}

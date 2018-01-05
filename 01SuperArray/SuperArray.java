public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
        size = 0;
    }

    public SuperArray(int capacity){
	data = new String[capacity];
	size = 0;
    }

    public void clear(){
	data = new String[size];
	size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean add(String thing){
        add(size, thing);
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
        throw new IndexOutOfBoundsException();
    }

    public String set(int i, String s){
        String out = data[i];
        if (i < size && i > 0)data[i] = s;
        return out;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    private void resize(){
	size ++;
        String[] newdata = new String[2 * size + 1];
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
	if (i < 0 || i > size) throw new IndexOutOfBoundsException();
	else{
	    if (size == data.length) resize();
	    for (int in = size-1; in > i; in --){
		data[in]=data[in - 1];
	    }
	    data[i] = thing;
	    size ++;
	}
    }

    public String remove(int i){
	if (i < 0 || i > size)throw new IndexOutOfBoundsException();
	String ans = data[i];
	int place = i;
	for (int in = i+1; in < size; in ++){
	    data[place] = data[in];
	    place ++;
	}
	size --;
	return ans;
    }
    public boolean remove(String thing){
	int index = indexOf(thing);
       	for (int i = 0; i < size; i ++){
	    if (i == index){
		remove(i);
		return true;
	    }
	}
	return false;
    }
}

import java.util.Arrays;

public class ArrayListJaka<Type> {
    private Type data[];

    private int size;
    
    private int capacity;
    
    public ArrayListJaka(int capacity) {
        this.data = (Type[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    
    public int getSize() {
        return size;
    }

    public void add(Type data) {
        if(size >= capacity){
            resize();
        }
        this.data[size++] = data;
    }

    private void resize() {
        Type temp[] = (Type[]) new Object[capacity * 2];
        for(int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        capacity *= 2;
    }

    public void remove(int index)   {  
        if(index >= 0 && index < size) {
            for(int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size--;
        }
    }   

    public void remove(Type data) {
        boolean found = false;
        for(int i = 0; i < size; i++) {
            if(data.equals(this.data[i])) {
                remove(i);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Element not found");
        }
    }

    public Type get(int index) {
        if(index >= 0 && index < size) {
            return data[index];
        }
        return null;
    }
}

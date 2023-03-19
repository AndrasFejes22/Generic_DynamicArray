package dynamicArray;

public class DynamicArray<T> {
    int size;
    int capacity = 10;
    T[] array;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DynamicArray() {
        this.array = (T[]) new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public void add(T data){
        if(size >= capacity){
            grow();
            System.out.println("grow() called");
        }
        array[size] = data;
        size++;

    }

    public void insert(int index, T data){
        if(size >= capacity){
            grow();
        }
        for(int i = size; i > index; i--){
            array[i] = array[i - 1]; // shift to the RIGHT
        }
        array[index] = data;
        size++;
    }

    public void delete(T data){
        for(int i = 0; i < size; i++){
            if(array[i] == data){
                for(int j = 0; j < (size - i - 1); j++){
                    array[j+1] = array[i +j + 1]; // need to shift all the element to the LEFT
                }
                array[size - 1] = null;
                size--;
                if(size <= (capacity/3)){
                    shrink();
                }
                break;
            }
        }
    }

    public int search(T data){
        for(int i = 0; i < size; i++){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }
    public Object get(int index){
        for(int i = 0; i < size; i++){
            if(i == index){
                return array[i];
            }
        }
        throw new IndexOutOfBoundsException("Get operation is not possible because index: " + index + ", but size: " + this.size);
    }


    // expand the size of array:

    private void grow(){
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.out.println("cap: " + capacity);
        // copy:
        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;

    }

    // decrease the size of array:

    private void shrink(){
        int newCapacity = capacity / 2;
        T[] newArray = (T[]) new Object[newCapacity];
        // copy:
        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        String string = "";
        for(int i = 0; i < size; i++){
            //for(int i = 0; i < capacity; i++){ // pl.: [A, A, A, null, null, null, null, null, null, null] (size: 3, cap.: 10)
            string += array[i] + ", ";
        }
        if(string != ""){
            string = "[" + string.substring(0, string.length() - 2) + "]"; // levágluk az idolsó(felesleges) space-t és , -öt.
        } else {
            string ="[]";
        }
        return string;
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        this.size = 0;
    }

    public void addFirst(T data){
        insert(0, data);
    }

    public void addLast(T data){
        insert(size, data);
    }

    public void swap (T oldValue, T newValue){
        for(int i = 0; i < size; i++){
            if(array[i] == oldValue){
                array[i] = newValue;
            }
        }

    }
}

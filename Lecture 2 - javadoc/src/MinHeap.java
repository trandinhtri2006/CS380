
/**
 * An implementation of a MinHeap.
 * <p>
 * Uses an array to store the keys.
 * @author User
 *
 */
public class MinHeap {

	 // - - - - Private Variables - - - -
	
	/**
	 * An integer array that will hold the keys.
	 */
    private int[] keys = null;
    
    
    /**
     *A field which will store the size of the heap.
     */
    private int size = 0;

    
    

    // - - - - Constructors - - - -
    
    /**
     * Initializes an empty heap with the specified capacity.
     * @param capacity Capacity of the heap.
     */
    public MinHeap(int capacity){
        keys = new int[capacity];
    }
    
    /**
     * Initializes a heap with given keys.
     * @param keys Keys to be stored in the heap.
     */
    public MinHeap(int[] keys){
        this.keys = keys;
        size = keys.length;

        for (int i = keys.length / 2 - 1; i >= 0; i--){
            heapify(i);
        }
    }


    // - - - - Getter Functions - - - -
    /**
     * A getter method that returns the capacity of the heap.
     * @return the length of the keys array.
     */
    public int getCapacity(){
        return keys.length;
    }
    
    /**
     * A getter method that returns the size of the heap. 
     * The number of elements stored in the heap.
     * @return the size of the heap.
     */
    public int getSize(){
        return size;
    }


    // - - - - Public Heap-Operations - - - -

    /**
     * Appends the specified element to the end of this list.
     * @param key
     */
    public void add(int key){
        if (getSize() >= getCapacity()){
            System.out.println("* * * Error: Heap is already full! * * *");
            return;
        }

        keys[size] = key;
        size++;

        moveUp(size - 1);
    }

    /**
     *  A method that return the minimum value
     * @return minimum number
     */
    public int getMin(){
        return keys[0];
    }

    /**
     * Remove the minimum value
     * @return mininum number
     */
    public int removeMin(){
        int min = keys[0];

        size--;

        keys[0] = keys[size];
        heapify(0);

        return min;
    }

    /**
     * Returns a string representation of this collection
     * @return a string
     */
    public String toString(){
      String str = "";
      
      for(int i : keys){
         str += i+", ";      
      }
      
      return str;
    }
       


    // - - - - Private Heap-Operations - - - -

    /**
     * A method that restores the heap property by percolating a node downwards from the given index.
     * @param index
     */
    private void heapify(int index){
        while (true){
            int l = left(index);
            int r = right(index);

            if (l >= getSize()){
                break;
            }

            int smallest = l;
            if (r < getSize() && keys[r] < keys[l]){
                smallest = r;
            }

            if (keys[smallest] >= keys[index]){
                break;
            }

            swapKeys(smallest, index);
            index = smallest;
        }
    }

    /**
     * Moves the element at the given index upward in the heap until the
     * min heap property is restored
     * @param index
     */
    private void moveUp(int index){
        while (index > 0){
            int parInd = parent(index);

            if (keys[parInd] <= keys[index]){
                return;
            }

            swapKeys(parInd, index);
            index = parInd;
        }
    }


    // - - - - Helper Functions - - - -

    private int left(int index){
        return 2 * index + 1;
    }

    private int right(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private void swapKeys(int ind1, int ind2){
        int tmp = keys[ind1];
        keys[ind1] = keys[ind2];
        keys[ind2] = tmp;
    }

}

package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  public EntryPair[] getHeap() { 
    return this.array;
  }

public void insert(EntryPair entry) {
		//move up:
	int start = ++size;
	for(array[0] = entry; entry.getPriority() < array[start/2].getPriority(); start /= 2)
		array[start] = array[start/2];
	array[start] = entry;
}

public void delMin() {
	
	if(size != 0){
		array[1] = array[size--];
		moveDown(1);
	}
}

public EntryPair getMin() {
	if(size == 0)
		return null;
	else
		return array[1];
}


public int size() {
	return size;
}

public void build(EntryPair[] entries) {
				//feed in an array, then construct the BTree from it.
				//Higher numbers are always at the tops
				//'entries' is unsorted, 'array' is final product
				
	
				//constructs actual tree:
	int i = 1;
	for(EntryPair x: entries){
		array[i] = x;
		i++;
	}
	
	size = entries.length;	
	
				//bubbles down to set the correct order:
	for(int t = size/2; t > 0; t--){
		moveDown(t);
	}
			
}
				//helper method:
private void moveDown( int start){
	
	int kid;
	EntryPair pH = array[start];
	
	for( ; (start * 2) <= size; start = kid ){
		kid = start *2;
		
		if( kid != size &&				
			array[kid + 1].getPriority() < array[kid].getPriority() )

				kid++;
		
		if( array[kid].getPriority() < pH.getPriority() )
				
				array[start] = array[kid];
		
		else
				break;
	}
	
	array[start] = pH;
	
}

}

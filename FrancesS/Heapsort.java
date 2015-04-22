//Frances Shapiro
//Pd 8
//HW42
//5-21-14

public class Heapsort {


    /* private ALHeap heap = new ALHeap();
    private Integer[] retArr = new Integer[0];

      public Integer[] sort(Integer[] data) {
	 retArr = new Integer[data.length];

	for(int i = 0; i < data.length; i++) 
	    heap.add(data[i]);
	for(int j = 0; j < data.length; j++)
	    retArr[j] = heap.removeMin();

	return retArr; 
	}*/

    public Integer[] sort(Integer[] data) {

	heapify(data);
	int part = data.length - 1;
	for(int i = 0; i < part; i++) {

	if ( data.length == 0 ) 
	    return null;

	Integer retVal = peekMin(data);

	Integer foo = data[ data.length - 1];

	swap( 0, data.length - 1, data );

	int pos = 0;
	int minChildPos;

	data[part] = retVal;

	while( pos < part ) {

	    minChildPos = minChildPos(pos, data);

	    if ( minChildPos == -1 ) 
		break;
	    else if ( foo.compareTo( data.get(minChildPos) ) <= 0 ) 
		break;
	    else {
		swap( pos, minChildPos, data );
		pos = minChildPos;
	    }
	}
	part++;
	}
	

	return data;

    }

    public Integer[] heapify(Integer[] data) {
	for(int i = 1; i < data.length; i++) {
	int rc = 2*i +1;
	int lc = 2*i +2;
	int parent = (i - 1)/2;
	if(data[i] < data[parent]) {
	    swap(i, parent, data);
	}
	}
	return data;
    }

  public Integer peekMin(Integer[] _heap) { 
	if ( _heap.length < 1 )
	    return null;
	else
	    return _heap[0]; 
    } //O(1)

  private Integer minOf( Integer a, Integer b ) {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
  private void swap( int pos1, int pos2, Integer[] _heap ) {
      Integer temp = _heap[pos1];
      _heap[pos1] = _heap[pos2];
      _heap[pos2] = temp;
    }




   



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
  private int minChildPos( int pos, Integer[] _heap ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= _heap.length || lc >= _heap.length )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= _heap.length )
	    retVal = lc;
	//have 2 children, so compare to find least 
	else if ( _heap[lc].compareTo(_heap[rc]) < 0 )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)



     public String toString() {
	String ret = "";

	if (!(retArr.length == 0)) {
	for(int i = 0; i < retArr.length; i++){

	   ret += retArr[i] + " ";
	}
	}
	   return ret;

	   }

    public static void main(String[] args) {
	Integer[] dataset1 = {5,8,6,1,3,0,2,4,7,9};
	Heapsort test1 = new Heapsort();
	test1.sort(dataset1);
	System.out.println(test1);
    }
}

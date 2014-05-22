//Justin Strauss
//HW42
//pd08
//2014-05-21

/*****************************************************
1. heapify the array from left to right by adding elements one by one and sifting up if the element is less than its parent
2. sort the array from right to left by swapping the min with the partition, then sifting down the root by swapping it with its min child if applicable
 *****************************************************/

public class Heapsort {

    private static int[] _heap;

    public static int[] sort( int[] input ) {
	_heap = input;
	for (int i = 1; i<_heap.length; i++) {
	    int parent = (i-1)/2;
	    int currentPos = i;
	    while (_heap[currentPos] < _heap[parent]) {
		swap(currentPos,parent);
		currentPos = parent;
		parent = (currentPos-1)/2;
	    }
	}
	for (int i = _heap.length-2; i>=0; i--) {
	    swap(0,i+1);
	    int lc = 1;
	    int rc = 2;
	    int currentPos = 0;
	    while (currentPos < i && (_heap[currentPos] > _heap[lc] || _heap[currentPos] > _heap[rc])) {
		if (_heap[lc] > _heap[rc] && rc<i) {
		    swap(currentPos,rc);
		    currentPos = rc;
		}
		else {
		    swap(currentPos,lc);
		    currentPos = lc;
		}
		lc = (currentPos*2)+1;
		rc = (currentPos*2)+2;
		if (lc >= i || rc >= i)
		    break;
	    }
	}
	return _heap;
    }

    private static void swap( int pos1, int pos2 ) {
	int tmp = _heap[pos1];
	_heap[pos1] = _heap[pos2];
	_heap[pos2] = tmp;
    }

    public static void main (String[] args) {
	int[] dataset = {5,8,6,1,3,0,2,4,7,9};
	sort(dataset);
	String retStr = "[";
	for (int i = 0; i < _heap.length; i++)
	    retStr += _heap[i] + " ";
	System.out.println(retStr + "]");
    }

}

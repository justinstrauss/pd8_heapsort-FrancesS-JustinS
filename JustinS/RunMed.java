//Justin Strauss
//Pair programmed with: Vincent Ou
//HW43
//pd08
//2014-05-22

/*****************************************************
 * class RunMed
 * Implements an online algorithm to track the median of a growing dataset
 * Maintains 2 heaps: minheap for upper half of dataset, maxheap for lower half
 * Median will always be one of these:
 *  - max of left heap  (lower range)
 *  - min of right heap (upper range)
 *  - mean of top of each heap

Summary of Approach:
The max heap will be a representation of the "left half" of the growing dataset, so the root (min element) will be closest to the middle. Likewise, the min heap will be a representation of the "right half" of the growing dataset, so the root (max element) will also be closest to the middle.
 *****************************************************/

public class RunMed {

    //instance vars
    private ALMaxHeap leftHeap;
    private ALMinHeap rightHeap;


    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public RunMed() 
    { 
        leftHeap = new ALMaxHeap();
	rightHeap = new ALMinHeap();
    }//O(1)



    /*****************************************************
     * int getMedian()  ---  returns median of dataset
     *****************************************************/
    public int getMedian() 
    {
 	if (leftHeap.getSize() == rightHeap.getSize())
	    return (leftHeap.peekMax() + rightHeap.peekMin())/2;
	else if (leftHeap.getSize() > rightHeap.getSize())
	    return leftHeap.peekMax();
	else
	    return rightHeap.peekMin();
    }//O(1)



    /*****************************************************
     * insert(int)  ---  adds a new element to the dataset
     * postcondition: dataset is maintained such that 
     *                getMedian() can run in constant time
     *****************************************************/
    public void insert( int addVal )
    {
     	if (isEmpty())
	    leftHeap.add(addVal);
	else if (leftHeap.getSize() > rightHeap.getSize())
	    rightHeap.add(addVal);
	else if (leftHeap.getSize() < rightHeap.getSize())
	    leftHeap.add(addVal);
	else if(addVal > getMedian()){

	    rightHeap.add(addVal);
	    leftHeap.add(rightHeap.removeMin());
	}
	else{
	    leftHeap.add(addVal);
	    rightHeap.add(leftHeap.removeMax());
	}
     }//O(logn)

    

    /*****************************************************
     * boolean isEmpty()  ---  tells whether a median may be calculated
     * postcondition: dataset structure unchanged
     *****************************************************/
    public boolean isEmpty() 
    {
        return leftHeap.isEmpty() && rightHeap.isEmpty();
    }//O(1)

    public String toString(){
	return "left:" + leftHeap.toString() +"\n"+ "right:" + rightHeap.toString();
    }

    //main method for testing
    public static void main( String[] args ) {



        RunMed med = new RunMed();

        med.insert(1);
	//System.out.println(med);
	System.out.println( med.getMedian() ); //1

        med.insert(3);
	//System.out.println(med);
	System.out.println( med.getMedian() ); //2

        med.insert(5);
	//System.out.println(med);
	System.out.println( med.getMedian() ); //3

        med.insert(7);
	//System.out.println(med);
	System.out.println( med.getMedian() ); //4

        med.insert(9);
	//System.out.println(med);
	System.out.println( med.getMedian() ); //5


    }//end main()

}//end class RunMed

package Lab1;

/**
 * 
 * @author Group 5
 
 * @object A typical IntQueue object is c={x1,...,xn}, where x1,...,xn are
 *   elements.
 * 
 *   for all x in elements. x is integer /\
 *    optional(elements) = false /\ 
 *  
 */
public  class IntQueue{
	private static int front, rear, capacity; 
    private static int queue[]; 
    
   /**public static int size = 0;
   public  IntNode head, tail;
   */
   IntQueue(int size){
	   front = rear = 0; 
       capacity = size; 
       queue = new int[capacity]; 
   }
   */
   /**
    * Add int element at the end of the queue
    * @param element int to add to the queue
    */
//add element at end of queue
   static void Enq(int x)  { 
       // check if the queue is full
       if (capacity == rear) { 
           System.out.printf("\nQueue is full\n"); 
           return; 
       } 
  
       // insert element at the rear 
       else { 
           queue[rear] = x; 
           rear++; 
       } 
       return; 
   } 
    /**
     * Return and remove first element
     * @throws IllegalStateException when the queue is empty
     */
    static void Deq() throws IllegalStateException{ 
        // check if queue is empty 
        if (front == rear) { 
        	throw new IllegalStateException("Empty Queue");
            
        } 
   
        // shift elements to the right by one place uptil rear 
        else { 
            for (int i = 0; i < rear - 1; i++) { 
                queue[i] = queue[i + 1]; 
            } 
   
       
      // set queue[rear] to 0
            if (rear < capacity) 
                queue[rear] = 0; 
   
            // decrement rear 
            rear--; 
        } 
        return; 
    } 

   
    }



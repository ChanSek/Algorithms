import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * This class is demonstrating the stack implementation. For practice it is impelemnted for integer data
 * type, but in future we can make it to support all data types. For this we need to use Generic type.
 * 
 * @author chansek
 *
 */
public class Stack {

	private int capacity; // Capacity of the stack. Initially its 10 when the stack got created.
	private int[] arr;
	private int size = 0; // Size of the stack at any instance of time.

	public Stack() {
		capacity = 10;
		arr = new int[capacity];
	}

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	// Main method is written here to test the methods written here.
	public static void main (String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.pop();
		System.out.println(s.size());
	}

	public void push (int val) {
		if (size < capacity) {
			arr[size++] = val; // Pushed to the top and size got updated.
		} else {
			// Stack is full.  So to expand it more, we need to create a new array and copy the
			// old content first, then push the new element to the newly created array
			capacity *= 2;
			int[] newArr = Arrays.copyOf(arr, capacity);
			arr = newArr;
			push(val);
		}
	}

	public int pop () throws EmptyStackException {
		if (size > 0) return arr[--size];
		else throw new EmptyStackException();
	}

	public int size() {
		return size;
	}
}

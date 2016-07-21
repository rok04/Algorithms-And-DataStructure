public class MinHeap {
	public int size;
	public int[] mHeap;
	public int position;

	public MinHeap(int size) {
		this.size = size;
		mHeap = new int[size + 1];
		position = 0;
	}

	public void createHeap(int[] arrA) {
		if (arrA.length > 0) {
			for (int i = 0; i < arrA.length; i++) {
				insert(arrA[i]);
			}
		}
	}

	public void display() {
		for (int i = 1; i < mHeap.length; i++) {
			System.out.print(" " + mHeap[i]);
		}
		System.out.println("");
	}

	public void insert(int x) {
		// If position is 0 then add it at first position // 1 based indexing
		if (position == 0) {
			mHeap[position + 1] = x;
			position = 2;
		} else {
			mHeap[position++] = x;
			shiftUp(position - 1);
		}
	}

	private void shiftUp(int pos) {
		if (pos < 1) {
			return;
		}
		// Signed half
		int parent = pos >>> 1;
		while (mHeap[parent] > mHeap[pos]) { // Minimum is down .. get it up
			// swap parent and child and then change child index to parent
			int y = mHeap[pos];
			mHeap[pos] = mHeap[parent];
			mHeap[parent] = y;
			pos = parent;
			parent = pos >>> 1;

		}
	}

	public int extractMin() {
		int min = mHeap[1];

		mHeap[1] = mHeap[position - 1]; // swap with last no in heap

		mHeap[position - 1] = 0; // make it null
		position--;

		shiftDown(1);

		return min;
	}

	/**
	 * @author rohit
	 * @param k
	 *            Shift an element from top to bottom In miniheap shift it to
	 *            minimum value child
	 */
	private void shiftDown(int k) {
		int a = mHeap[k];
		while (true) {
			int smallest = k;
			if (2 * k < position && mHeap[smallest] > mHeap[2 * k]) {
				smallest = 2 * k;
			}
			if (2 * k + 1 < position && mHeap[smallest] > mHeap[2 * k + 1]) {
				smallest = 2 * k + 1;
			}
			if (smallest != k) {
				swap(k, smallest);
			} else
				break;
		}

	}

	private void swap(int a, int b) {
		int temp = mHeap[a];
		mHeap[a] = mHeap[b];
		mHeap[b] = temp;
	}

	public static void main(String args[]) {
		int arrA[] = { 3, 2, 8, 4, 10, 16, 12 };

		System.out.print("Original Array : ");
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + arrA[i]);
		}
		
		// Creating MiniMum Heap with initial Capacity
		MinHeap m = new MinHeap(arrA.length);
		m.createHeap(arrA);

		System.out.print("\nMin-Heap : ");
		m.display();

		System.out.print("Extract Min :");
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + m.extractMin());
		}

	}
}

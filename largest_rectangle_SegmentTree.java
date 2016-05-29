/**
There are N buildings in a certain two-dimensional landscape. Each building has a height given by h[i] . 
If you join adjacent buildings, they will form a solid rectangle of area .

Given buildings, find the greatest such solid area formed by consecutive buildings. 
*/
import java.util.Scanner;

// solving using Segment tree start index =1
// Complexity Nlog(N)
public class Solution {
	private static final int INT_MIN = -1000000000;
	private static final int MAX_INT = 1000000000;
	static int[] seg = new int[2000000];
	static int n;
	static int arr[] = new int[1000000 + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int test = 0; test < n; test++) {
			arr[test] = sc.nextInt();
		}
		solve(arr, n);
		sc.close();
	}

	public static void solve(int arr[], int n) {
		buildTree(arr, n);
		// get minimum of full array and then do divide and conquer attack on array
		// find maximum area of left of minimim index and right of minimum index
		// and then involve that index too
		// solver will solve this problem
		System.out.println(solver(arr, n, 0, n - 1));
	}

	public static int solver(int arr[], int n, int start, int last) {

		if (start > last)
			return INT_MIN;
		else if (start == last)
			return arr[start];
		else {
             // get minimum in array 
			int min = RMQ(arr, seg, n, start, last);
			//System.out.println(min);
            /** Findout minimum of left and right without including minimum element and than 
            include that element in solution and see which is maximum*/
			return Math.max(
					Math.max(solver(arr, n, start, min - 1),
							 solver(arr, n, min + 1, last)), 
							(last - start + 1)* (arr[min]));
		}
	}

	public static void buildTree(int arr[], int n) {

		int level = (int) Math.ceil((Math.log(n) / Math.log(2)));
		int startLeave = 0;
		startLeave = (2 * (int) Math.pow(2, level)) - 1;
		healperBuildTree(arr, seg, 0, n - 1, 0);
	}

	public static int healperBuildTree(int arr[], int seg[], int start,
			int last, int index) {
		if (start == last)
			return (seg[index] = start);
		else {
			int mid = (start + last) / 2;
			seg[index] = getmini(arr,
					healperBuildTree(arr, seg, start, mid, 2 * index + 1),
					healperBuildTree(arr, seg, mid + 1, last, 2 * index + 2));
			return seg[index];
		}
	}

	public static int RMQ(int arr[], int seg[], int n, int start, int last) {
		return RMQHelper(arr, seg,n, start, last, 0, n - 1, 0);
	}

	public static int RMQHelper(int arr[], int seg[],int n, int start, int last, int startIndexOfTree,int lastIndexOftree, int index) {

		int mid = (startIndexOfTree + lastIndexOftree) / 2;

		if (startIndexOfTree > last || start > lastIndexOftree) {
			return -1;
		} else if (startIndexOfTree >= start && last >= lastIndexOftree)
			return seg[index];
		else {
			return getmini(arr,	RMQHelper(arr, seg, n, start, last, startIndexOfTree, mid, 2*index+1),
								RMQHelper(arr, seg, n, start, last, mid+1, lastIndexOftree, 2*index+2));

		}
	}

	static int getmini(int arr[], int i, int j) {
		if (i == -1)
			return j;
		if (j == -1)
			return i;
		else {
			if (arr[i] > arr[j])
				return j;
			else
				return i;

		}
	}
}

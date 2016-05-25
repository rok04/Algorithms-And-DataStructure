/**
https://leetcode.com/problems/range-sum-query-mutable/
*/

/**
 * 1 index based segment tree
 * 
 * @author rok04
 *
 */
public class Segment_Tree {
	static int seg[] = new int[2000002];
	static int N;
	static int startleaveIndex = 0;

	public static void main(String[] args) {
		int[] nums = new int[3];
		nums[0] = 1;
		nums[1] = 3;
		nums[2] = 5;
		new Segment_Tree().NumArray(nums);
		System.out.println(new Segment_Tree().sumRange(0, 2));
		new Segment_Tree().update(1, 2);
		System.out.println(new Segment_Tree().sumRange(0, 2));
	}

	public void NumArray(int[] nums) {
		N = nums.length;
		int level = (int) (Math.log(N) / Math.log(2));
		startleaveIndex += Math.pow(2, level + 1);
		for (int i = startleaveIndex; i < (1 << startleaveIndex); i++)
			seg[i] = 0;

		for (int i = 0; i < nums.length; i++) {
			seg[startleaveIndex + i] = nums[i];
		}
		for (int i = startleaveIndex - 1; i >= 0; --i) {
			seg[i] = seg[2 * i] + seg[2 * i + 1];
		}
	}

	public void update(int index, int val) {
		int diff = val - seg[startleaveIndex + index];
		seg[startleaveIndex + index] = val;
		for (int j = (startleaveIndex + index) / 2; j >= 0; j /= 2) {
			seg[j] = seg[j] + diff;
			if (j == 0)
				break;
		}
	}

	public int sumRange(int start, int last) {

		return SolveSumRange(1, start, last, 0, startleaveIndex - 1);

	}

	public int SolveSumRange(int node, int start, int last, int segmentTreeIndexStart, int segmentTreeIndexEnd) {

		if (start > segmentTreeIndexEnd || last < segmentTreeIndexStart) {
			return 0;
		} else if (segmentTreeIndexStart >= start && segmentTreeIndexEnd <= last) {
			return seg[node];
		}

		else {
			int mid = (segmentTreeIndexEnd + segmentTreeIndexStart) / 2;
			int left = SolveSumRange(2 * node, start, last, segmentTreeIndexStart, mid);
			int right = SolveSumRange(2 * node + 1, start, last, mid + 1, segmentTreeIndexEnd);
			return left + right;
		}

	}
}



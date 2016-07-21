
public class StringPermutation {

	public static void main(String[] args) {
		String A = "ABC";
		char a[] = A.toCharArray();
		char result[] = new char[a.length];
		int hash[] = new int[26];
		for (int i = 0; i < a.length; i++) {
			hash[a[i] - 'A'] += 1;
		}
		solve(hash, result, a.length);

	}

	static int curr;

	public static void solve(int input[], char result[], int len) {

		if (curr == len) {
			System.out.println(result);
		}

		for (int i = 0; i < 26; i++) {
			if (input[i] > 0) {
				result[curr++] = (char) (i + 'A');
				input[i]--;
				solve(input, result, len);
				curr--;
				input[i]++;
			}
		}

	}

}

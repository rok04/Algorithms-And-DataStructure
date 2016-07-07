
import java.util.HashMap;
import java.util.Map;
import java.lang.instrument.Instrumentation;

public class Trie {
	private static Instrumentation instrumentation;
	public Node root;

	public Trie() {
		root = new Node();
	}

	class Node {
		boolean isLeaf;
		Map<Character, Node> children;

		public Node() {
			children = new HashMap<>();
			isLeaf = false;
		}

	}

	public void insertWord(String ss, Node root1) {
		Node root = root1;
		if (root == null) {
			System.out.println("Root has not been created ");
			return;
		}
		for (int i = 0; i < ss.length(); i++) {
			char c = ss.charAt(i);
			if (!root.children.containsKey(c)) {
				Node lastNode = new Node();
				lastNode.isLeaf = false;
				root.children.put(c, lastNode);
			}
			root = root.children.get(c);

		}
		root.isLeaf = true;

	}

	public boolean searchWord(String ss, Node root1) {
		Node root = root1;
		for (int i = 0; i < ss.length(); i++) {
			if (root.children.containsKey(ss.charAt(i))) {
				root = root.children.get(ss.charAt(i));
			} else
				return false;
		}
		return true;
	}

	public void deleteWord(String ss) {

	}

	public static void premain(String args, Instrumentation inst) {
		instrumentation = inst;
	}

	public static void main(String[] args) {
		String[] words = { "hello", "hdll", "abcde", "abdef", "a", "abe" };

		// Root has been created here
		Trie trie = new Trie();

		for (int i = 0; i < words.length; i++) {
			trie.insertWord(words[i], trie.root);
		}
		System.out.println(trie.searchWord("hdlll", trie.root) + " " + trie.searchWord("a", trie.root));

	}
}

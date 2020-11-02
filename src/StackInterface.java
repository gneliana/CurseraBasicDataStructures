import java.util.*;
import java.io.*;

public class StackInterface {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int max = Integer.MIN_VALUE;
		int queries = scanner.nextInt();
		Stack<StackNode> stack = new Stack<StackNode>();
		for (int qi = 0; qi < queries; ++qi) {
			String operation = scanner.next();
			if ("push".equals(operation)) {
				int value = scanner.nextInt();
				max = Math.max(value, max);
				stack.push(new StackNode(value, max));
			} else if ("pop".equals(operation)) {
				stack.pop();
				if (stack.isEmpty())
					max = Integer.MIN_VALUE;
				else
					max = stack.peek().curMax;
			} else if ("max".equals(operation)) {
				System.out.println(stack.peek().curMax);
			}
		}
	}

	private static class StackNode {
		int val;
		int curMax;

		public StackNode(int val, int curMax) {
			this.val = val;
			this.curMax = curMax;
		}

		public String toString() {
			return val + " [" + curMax + "]";
		}
	}

	static public void main(String[] args) throws IOException {
		new StackInterface().solve();
	}
}

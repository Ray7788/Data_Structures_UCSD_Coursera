import java.util.*;
import java.io.*;

public class tree_height {
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

	public class TreeHeight {
		int n;
		int parent[];
		// new
		int root;
		List<Integer>[] adj;
		// 

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			adj = new ArrayList[n];
			parent = new int[n];

			for (int i = 0; i < n; i++) {
            	adj[i] = new ArrayList<Integer>();
        	}

			for (int child = 0; child < n; child++) {
				int parent = in.nextInt();
				if (parent == -1)
					root = child;
				else
					adj[parent].add(child);
			}
		}

		int computeHeight() {
            // Replace this code with a faster implementation
			int maxHeight = 0;
			// use the queue
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(root);
			while (!q.isEmpty()) {
				int pop = q.remove();
				for (int v : adj[pop]) {
					heights[v] = heights[pop] + 1;
					q.add(v);
				}
				maxHeight = heights[pop] + 1;
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            tree_height tree = new tree_height();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}

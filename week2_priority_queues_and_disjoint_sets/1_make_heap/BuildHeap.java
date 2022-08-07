import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private int N;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        this.N = n;
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void shiftDown(int m){
      while (2 * m + 1  < N){
        int j = 2 * m + 1;

        if (j < N - 1 && data[j] > data[j + 1])
            j++;
        if (data[m] <= data[j])
            break;
        exchange(m, j);
        m = j; 
      }
    }

    // IMPORTANT!!!
    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
      // Now has been solved

      // for (int i = 0; i < data.length; ++i) {
      //   for (int j = i + 1; j < data.length; ++j) {
      //     if (data[i] > data[j]) {
      //       swaps.add(new Swap(i, j));
      //       int tmp = data[i];
      //       data[i] = data[j];
      //       data[j] = tmp;
      //     }
      //   }
      // }

      // learned from  lectures
      for (int i = N/2; i >=0; i--){
        shiftDown(i);
      }  
    }

    private void exchange(int k, int j) {
      swaps.add(new Swap(k, j));
      int temp = data[k];
      data[k] = data[j];
      data[j] = temp;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

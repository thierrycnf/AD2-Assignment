import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Part1 {
    public static void main(String[] args) throws IOException {
        int[] dutch = readNumbersIntoArray("Dutch.txt");
        int[] intBig = readNumbersIntoArray("intBig.txt");

        quicksort_median3(dutch, 0, dutch.length - 1);
        quicksort_median3(intBig, 0, intBig.length - 1);
        System.out.println(Arrays.toString(dutch));
    }


    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void three_way_quicksort(int[] A, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = A[lo];
        int lt = lo;
        int gt = hi;
        int i = lo + 1;

        while (i <= gt) {
            if (A[i] < pivot) {
                swap(A, lt, i);
                lt++;
                i++;
            }
            else if(A[i] > pivot) {
                swap(A, i, gt);
                gt--;
            }
            else {i++;}
        }

        three_way_quicksort(A, lo, lt - 1);
        three_way_quicksort(A, gt + 1, hi);
    }

    public static int partition(int[] A, int p, int r) {
        int pivot = A[r]; //pick last element as pivot
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);//every element at an index before i is <= pivot
            }
        }
        swap(A, i+1, r);
        return i+1;
    }

    public static int median_of_three(int A[], int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (A[lo] > A[mid]) {swap(A, lo, mid);}
        if (A[mid] > A[hi]) {swap(A, mid, hi);}
        if (A[lo] > A[mid]) {swap(A, lo, hi);}
        return mid;
    }

    public static void quicksort_median3(int[] A, int lo, int hi) {
        if (lo >= hi) {return;}
        int mid = median_of_three(A, lo, hi);
        swap(A, mid, hi);
        int p = partition(A, lo, hi);
        quicksort_median3(A, lo, p - 1);
        quicksort_median3(A, p + 1, hi);

    }

    public static int[] quicksort_median3_killer(int n) {
        int[] A = new int[n];
        int k = 0;
        A[k++] = 0;

        for (int v = 1; v < n; v += 2) {
            A[k++] = v;
        }

        for (int v = 2; v < n; v += 2) {
            A[k++] = v;
        }

        return A;
    }
    public static int[] readNumbersIntoArray(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        int count = 0;
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();

        reader = new BufferedReader(new FileReader(filename));

        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            String line = reader.readLine();
            numbers[i] = Integer.parseInt(line);
        }

        reader.close();

        return numbers;
    }

}
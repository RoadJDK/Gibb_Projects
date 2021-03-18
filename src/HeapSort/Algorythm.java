package HeapSort;

public class Algorythm {
    private int[] arr = {0,9,4,6,2,8,5,1,7,3};
    Stopwatch stopwatch;

    public void Run() {
        stopwatch = new Stopwatch();
        sort(); print();
    }

    private void sort()
    {
        var n = arr.length;
         for (var i = n / 2 - 1; i >= 0; i--)
             heapify(arr, n, i);
         for (var i = n - 1; i > 0; i--) {
             var temp = arr[0];
             arr[0] = arr[i];
             arr[i] = temp;
             heapify(arr, i, 0);
         }
    }

    private void heapify(int arr[], int n, int i)
    {
        var largest = i;
        var left = 2 * i + 1;
        var right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            var temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    private void print()
    {
        for (var i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
        System.out.println("that took: " + stopwatch.stop() + "ms");
    }
}

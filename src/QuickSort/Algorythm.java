package QuickSort;

public class Algorythm {
    private int[] arr = {0,9,4,6,2,8,5,1,7,3};
    Stopwatch stopwatch;

    public void Run() {
        stopwatch = new Stopwatch();
        sort(0,9); stopwatch.stop(); print();
    }

    private void sort(int begin, int end) {

        if (begin < end) {
            var partitionIndex = partition(arr, begin, end);

            sort(begin, partitionIndex-1);
            sort(partitionIndex+1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (var j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                var swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        var swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    void print()
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
        System.out.println("that took: " + stopwatch.stop() + "ms");
    }
}

package InsertionSort;

public class Algorythm {
    private int[] arr = {0,9,4,6,2,8,5,1,7,3};

    public void Run() {
        sort(); print();
    }

    private void sort() {

        for (var i = 1; i < arr.length; ++i) {
            var key = arr[i];
            var before = i - 1;

            while (before >= 0 && arr[before] > key) {
                arr[before + 1] = arr[before];
                before = before - 1;
            }
            arr[before + 1] = key;
        }
    }

    void print()
    {
        for (var i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}

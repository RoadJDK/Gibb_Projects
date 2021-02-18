package BubbleSort;

public class Algorythm {
    private int[] arr = {0,9,4,6,2,8,5,1,7,3};

    public void Run() {
        sort(); print();
    }

    private void sort() {

        var n = arr.length;
        for (var i = 0; i < n-1; i++)
            for (var j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    var temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    void print()
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}

package HeatSort;

public class Program {
    public static void main(String args[])
    {
        int arr[] = new int[]{12, 11, 13, 5, 6, 7};
        var n = arr.length;

        var algorythm = new Algorythm();
        algorythm.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    static void printArray(int arr[])
    {
        var n = arr.length;
        for (var i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

package LBV2_PreperationTest;

public class Parker_Peter {
    public static int nachbarn(int[][] welt) {
        if (welt.length != 3) { return -1; }
        var count = 0;

        for (var i = 0; i < welt.length; i++) {
            if (!(welt[i].length == 3)) { return -1; }

            for (var j = 0; j < welt.length; j++) {
                if (welt[i][j] == 1) {
                    if(i == 1 && j == 1) { count--; }
                    count++;
                }
            }
        }
        return count;
    }

    public static void bubblesort(int[] liste) {
        int temp;
        int index;

        for (var i = 0; i < liste.length; i++) {
            if (i+1 >= liste.length) { break; }
            index = 0;

            for (var j = 0; j < liste.length; j++) {
                if (j+1 >= liste.length) { break; }

                if (liste[index] > liste[index+1]) {
                    temp = liste[index];
                    liste[index] = liste[index+1];
                    liste[index+1] = temp;
                    i--;
                }
                index++;
            }
        }
    }

    public static int binom(int n, int k) {
        if (k == 0) { return 1; }

        if (2*k > n) { return binom(n, n-k); }

        return (int) ((0.0+n+1-k)/k*binom(n,k-1));
    }

    public static boolean isMaxHeap(int[] array) {

        for (var i = 0; i <= (array.length - 2) / 2; i++) {
            if (array[2 * i + 1] > array[i]) {
                return false;
            }

            if (2 * i + 2 < array.length && array[2 * i + 2] > array[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("LB2-Uebung M411");
        System.out.println("Nachbarn w1: " + nachbarn(welt_1));
        System.out.println("Nachbarn w2: " + nachbarn(welt_2));
        bubblesort(feld);
        printArray(feld);
        System.out.println("Bubble: " + feld[3] + feld[4]);
        System.out.println("Binom: " + binom(5, 2));
        System.out.println("Binom: " + binom(4, 2));
        System.out.println("h1: " + isMaxHeap(h_1));
        System.out.println("h2: " + isMaxHeap(h_2));
    }
    private static int[][] welt_1 = {{1, 0, 0}, {1, 0, 1}, {0, 0, 1}};
    private static int[][] welt_2 = {{0, 0, 0}, {0, 0, 0}};
    private static int[] feld = {60, 12, 1, 88, 100, 34, 6, 99, 2};
    private static int[] h_1 = {20, 8, 11, 8, 9, 9, 10, 2};
    private static int[] h_2 = {20, 8, 11, 8};

    public static void printArray(int[] array) {
        for (var i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }
}

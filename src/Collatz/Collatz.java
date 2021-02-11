package Collatz;

import java.util.ArrayList;
import java.util.Scanner;

public class Collatz {
    int startzahl;

    public void Run() {
        System.out.println("Bitte Startzahl eingeben:");
        var scanner = new Scanner(System.in);

        while (true) {
            try {
                startzahl = Integer.parseInt(scanner.nextLine());
                if (startzahl <= 0) { throw new Exception(); }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input!");
            };
        }

        var list = algorythm(startzahl);

        for(var i = 0; i < list.size();i++) {
            System.out.print(list.get(i) + " ");
            if((i+1) % 9 == 0) {
                System.out.println("");
            }
        }
    }

    private ArrayList<Integer> algorythm(int n) {
        var list = new ArrayList<Integer>();

        while(n != 1) {
            if(n % 2 == 0) {
                list.add(n);
                n = n/2;
            } else {
                list.add(n);
                n = 3*n+1;
            }
        }
        list.add(n);

        return list;
    }
}

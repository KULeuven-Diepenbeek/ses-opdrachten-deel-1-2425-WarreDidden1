package be.ses;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Iterable<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        
        System.out.println(CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 5));
    }
}
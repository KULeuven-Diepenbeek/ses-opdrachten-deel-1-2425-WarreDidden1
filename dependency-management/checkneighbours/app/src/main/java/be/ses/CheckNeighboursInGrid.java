package be.ses;

import java.util.ArrayList;
import java.util.List;

public class CheckNeighboursInGrid {
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        // Zet Iterable om naar een List voor betere index-opvragingen
        List<Integer> gridList = new ArrayList<>();
        for (int value : grid) {
            gridList.add(value);
        }

        List<Integer> result = new ArrayList<>();
        int valueToCheck = gridList.get(indexToCheck);
        int row = indexToCheck / width;
        int col = indexToCheck % width;

        System.out.println("Index to check: " + indexToCheck + " (Value: " + valueToCheck + ")");

        // Check boven
        if (row > 0) {
            int topIndex = indexToCheck - width;
            System.out.println("Boven: index " + topIndex + " (Value: " + gridList.get(topIndex) + ")");
            if (gridList.get(topIndex).equals(valueToCheck)) {
                result.add(topIndex);
            }
        }

        // Check onder
        if (row < height - 1) {
            int bottomIndex = indexToCheck + width;
            System.out.println("Onder: index " + bottomIndex + " (Value: " + gridList.get(bottomIndex) + ")");
            if (gridList.get(bottomIndex).equals(valueToCheck)) {
                result.add(bottomIndex);
            }
        }

        // Check links
        if (col > 0) {
            int leftIndex = indexToCheck - 1;
            System.out.println("Links: index " + leftIndex + " (Value: " + gridList.get(leftIndex) + ")");
            if (gridList.get(leftIndex).equals(valueToCheck)) {
                result.add(leftIndex);
            }
        }

        // Check rechts
        if (col < width - 1) {
            int rightIndex = indexToCheck + 1;
            System.out.println("Rechts: index " + rightIndex + " (Value: " + gridList.get(rightIndex) + ")");
            if (gridList.get(rightIndex).equals(valueToCheck)) {
                result.add(rightIndex);
            }
        }

        return result;
    }
}

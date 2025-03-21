package be.ses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGrid {
    public static Iterable<Integer> getSameNeighboursIds(int width, int height, String indexToCheckStr) {
        int indexToCheck;
        try {
            indexToCheck = Integer.parseInt(indexToCheckStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("For input string: \"" + indexToCheckStr + "\"");
        }

        return getSameNeighboursIds(width, height, indexToCheck);
    }

    public static Iterable<Integer> getSameNeighboursIds(int width, int height, int indexToCheck) {
       
        // Zet Iterable om naar een List voor betere index-opvragingen
        Iterable<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        
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

        // Check diagonaal links-boven
        if (row > 0 && col > 0) {
            int topLeftIndex = indexToCheck - width - 1;
            System.out.println("Links-boven: index " + topLeftIndex + " (Value: " + gridList.get(topLeftIndex) + ")");
            if (gridList.get(topLeftIndex).equals(valueToCheck)) {
                result.add(topLeftIndex);
            }
        }

        // Check diagonaal rechts-boven
        if (row > 0 && col < width - 1) {
            int topRightIndex = indexToCheck - width + 1;
            System.out.println("Rechts-boven: index " + topRightIndex + " (Value: " + gridList.get(topRightIndex) + ")");
            if (gridList.get(topRightIndex).equals(valueToCheck)) {
                result.add(topRightIndex);
            }
        }

        // Check diagonaal links-onder
        if (row < height - 1 && col > 0) {
            int bottomLeftIndex = indexToCheck + width - 1;
            System.out.println("Links-onder: index " + bottomLeftIndex + " (Value: " + gridList.get(bottomLeftIndex) + ")");
            if (gridList.get(bottomLeftIndex).equals(valueToCheck)) {
                result.add(bottomLeftIndex);
            }
        }

        // Check diagonaal rechts-onder
        if (row < height - 1 && col < width - 1) {
            int bottomRightIndex = indexToCheck + width + 1;
            System.out.println("Rechts-onder: index " + bottomRightIndex + " (Value: " + gridList.get(bottomRightIndex) + ")");
            if (gridList.get(bottomRightIndex).equals(valueToCheck)) {
                result.add(bottomRightIndex);
            }
        }
        if (result.size() == 0) { //anders error bij geen buren
            result.add(0);
            System.out.println("Geen buren gevonden.");
        }
        return result;
    }
}
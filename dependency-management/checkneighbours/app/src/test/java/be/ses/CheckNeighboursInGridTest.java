package be.ses;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class CheckNeighboursInGridTest {
    @Test 
    public void gegevenIndex5_dan2en4en10() {

      // 1. Arrange
      var checkn = new CheckNeighboursInGrid();
  
      // 2. Act
      Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, 5);
      System.out.println(result);
  
      // 3. Assert
      assertThat(result).containsOnly(2, 4, 10); //containsONLY ipv exact want volgorde maakt niet uit
    }

    @Test //rechtsbovenhoekje
    public void gegevenIndex3_dan6() {

      // 1. Arrange
      var checkn = new CheckNeighboursInGrid();
  
      // 2. Act
      Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, 3);
      System.out.println(result);
  
      // 3. Assert
      assertThat(result).containsExactly(6);
    }
    @Test //linkerrand
    public void gegevenIndex8_dan0() {

      // 1. Arrange
      var checkn = new CheckNeighboursInGrid();
  
      // 2. Act
      Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, 8);
      System.out.println(result);
  
      // 3. Assert
      assertThat(result).containsExactly(0);
    }
    @Test //te grote index (buiten de grid)
    public void gegevenIndex21_danOutOfBoundsException() {
      
      // Arrange
      var checkn = new CheckNeighboursInGrid();
  
      // Act
      Throwable thrown = catchThrowable(() -> {
        Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, 21);
      });
  
      // Assert
      assertThat(thrown)
          .isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index 21 out of bounds for length 16"); //de exact verwachte zin
  }

  @Test //onderrand
    public void gegevenIndex14_dan10En13En15() {
      // 1. Arrange
      var checkn = new CheckNeighboursInGrid();
  
      // 2. Act
      Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, 14);
      System.out.println(result);
  
      // 3. Assert
      assertThat(result).containsOnly(10, 13, 15);

  }
  
  @Test //rechterrand
  public void gegevenIndex7_dan0() {
    // 1. Arrange
    var checkn = new CheckNeighboursInGrid();

    // 2. Act
    Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, 7);
    System.out.println(result);

    // 3. Assert
    assertThat(result).containsOnly(0);
  }

    @Test //negatieve index
    public void gegevenIndexMin1_danOutOfBoundsException() {
      
      // Arrange
      var checkn = new CheckNeighboursInGrid();
  
      // Act
      Throwable thrown = catchThrowable(() -> {
        Iterable<Integer> result = checkn.getSameNeighboursIds(4, 4, -1);
      });
  
      // Assert
      assertThat(thrown)
          .isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index -1 out of bounds for length 16"); //de exact verwachte zin
  }
}


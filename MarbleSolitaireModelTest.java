package cs5004.marblesolitaire.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelTest {

  @Test
  public void testNoParameterConstructorAndGetGameState() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(32, obj.getScore());
  }

  @Test
  public void testCustomEmptySlotConstructor() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(1, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(32, obj.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCustomEmptySlotConstructor_1() {
    new MarbleSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCustomEmptySlotConstructor_2() {
    new MarbleSolitaireModelImpl(1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCustomEmptySlotConstructor_3() {
    new MarbleSolitaireModelImpl(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCustomEmptySlotConstructor_4() {
    new MarbleSolitaireModelImpl(5, 5);
  }

  @Test
  public void testArmThicknessConstructor_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(32, obj.getScore());
  }

  @Test
  public void testArmThicknessConstructor_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", obj.getGameState());
    assertEquals(104, obj.getScore());
  }

  @Test
  public void testArmThicknessConstructor_3() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(7);
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", obj.getGameState());
    assertEquals(216, obj.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessConstructor() {
    new MarbleSolitaireModelImpl(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessConstructor_2() {
    new MarbleSolitaireModelImpl(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessConstructor_3() {
    new MarbleSolitaireModelImpl(-8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessConstructor_4() {
    new MarbleSolitaireModelImpl(0);
  }

  @Test
  public void testArmThicknessAndCustomEmptySlotConstructor_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 1, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(32, obj.getScore());
  }

  @Test
  public void testArmThicknessAndCustomEmptySlotConstructor_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5, 6, 3);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", obj.getGameState());
    assertEquals(104, obj.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessAndCustomEmptySlotConstructor_1() {
    new MarbleSolitaireModelImpl(-5, 6, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessAndCustomEmptySlotConstructor_2() {
    new MarbleSolitaireModelImpl(-2, 6, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessAndCustomEmptySlotConstructor_3() {
    new MarbleSolitaireModelImpl(0, 6, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessAndCustomEmptySlotConstructor_4() {
    new MarbleSolitaireModelImpl(2, 6, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessAndCustomEmptySlotConstructor_5() {
    new MarbleSolitaireModelImpl(10, 6, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidArmThicknessAndCustomEmptySlotConstructor_6() {
    new MarbleSolitaireModelImpl(5, 16, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_InvalidFromRow() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(-1, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_InvalidFromCol() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(3, -2, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_InvalidToRow() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(3, -2, -42, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_InvalidToCol() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(3, 0, 0, -43);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_FromRowColIsNotMarble() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(1, 2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_ToRowColIsNotEmpty() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(0, 5, 2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_FromRowColIsNotMarbleANDToRowColIsNotEmpty() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(1, 5, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_FromRowColIsNotMarbleANDToRowColIsNotEmpty_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(3, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_FromRowColIsNotMarbleANDToRowColIsNotEmpty_3() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl();
    obj.move(1, 5, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_DiagonalMove2Spaces_BottomRight() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    obj.move(4, 3, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_DiagonalMove2Spaces_UpperRight() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    obj.move(8, 4, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_DiagonalMove2Spaces_BottomLeft() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    obj.move(4, 3, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_DiagonalMove2Spaces_UpperLeft() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    obj.move(4, 8, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_DiagonalMove4Spaces() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    obj.move(4, 3, 8, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_DiagonalMove5Spaces() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(5);
    obj.move(8, 8, 9, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove1Space_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(1, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove1Space_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(4, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove5Spaces() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(0, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove3Spaces() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(3, 6, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove2Spaces_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(0, 3, 0, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove2Spaces_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(3, 0, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove2Spaces_3() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(1, 0, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_HorizontalMove2Spaces_4() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(1, 3, 1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_VerticalMove1Space_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(4, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_VerticalMove1Space_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(3, 1, 2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_VerticalMove5Spaces() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(0, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_VerticalMove3Spaces() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(5, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_VerticalMove2Spaces_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(5, 2, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_VerticalMove2Spaces_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(2, 0, 4, 0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove_SpaceOnePositionAwayIsNotMarble() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    obj.move(0, 3, 3, 3);
  }


  @Test
  public void SingleValidMove_1() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(31, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void SingleValidMove_2() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(3, 5, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(31, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void SingleValidMove_3() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O", obj.getGameState());
    assertEquals(31, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void SingleValidMove_4() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3);
    obj.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(31, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void SingleValidMove_5() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", obj.getGameState());
    assertEquals(31, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void testGameOverFalseMultipleMoves() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    obj.move(2, 1, 2, 3);
    obj.move(4, 1, 2, 1);
    obj.move(4, 3, 4, 1);
    obj.move(6, 2, 4, 2);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O _ O O O\n" +
            "    _ O O\n" +
            "    _ O O", obj.getGameState());
    assertEquals(27, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void testGameOverFalseAFewValidMovesLeft() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    obj.move(2, 1, 2, 3);
    obj.move(4, 1, 2, 1);
    obj.move(4, 3, 4, 1);
    obj.move(6, 2, 4, 2);
    obj.move(6, 4, 6, 2);
    obj.move(5, 4, 5, 2);
    obj.move(4, 5, 4, 3);
    obj.move(3, 3, 5, 3);
    obj.move(5, 2, 5, 4);
    obj.move(4, 1, 4, 3);
    obj.move(2, 0, 2, 2);
    obj.move(2, 3, 2, 1);
    obj.move(4, 0, 2, 0);
    obj.move(2, 0, 2, 2);
    obj.move(2, 2, 4, 2);
    obj.move(4, 3, 4, 1);
    obj.move(2, 5, 2, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ _ _ _ O O O\n" +
            "_ O _ _ _ _ O\n" +
            "    _ _ O\n" +
            "    O _ _", obj.getGameState());
    assertEquals(14, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void testGameOverFalseOneValidMoveLeft() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    obj.move(2, 1, 2, 3);
    obj.move(4, 1, 2, 1);
    obj.move(4, 3, 4, 1);
    obj.move(6, 2, 4, 2);
    obj.move(6, 4, 6, 2);
    obj.move(5, 4, 5, 2);
    obj.move(4, 5, 4, 3);
    obj.move(3, 3, 5, 3);
    obj.move(5, 2, 5, 4);
    obj.move(4, 1, 4, 3);
    obj.move(2, 0, 2, 2);
    obj.move(2, 3, 2, 1);
    obj.move(4, 0, 2, 0);
    obj.move(2, 0, 2, 2);
    obj.move(2, 2, 4, 2);
    obj.move(4, 3, 4, 1);
    obj.move(2, 5, 2, 3);
    obj.move(0, 2, 2, 2);
    obj.move(0, 4, 0, 2);
    obj.move(2, 2, 2, 4);
    obj.move(2, 4, 0, 4);
    assertEquals("    O _ O\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ _ O O O\n" +
            "_ O _ _ _ _ O\n" +
            "    _ _ O\n" +
            "    O _ _", obj.getGameState());
    assertEquals(10, obj.getScore());
    assertFalse(obj.isGameOver());
  }

  @Test
  public void testGameOverTrueNoValidMoveLeft() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    obj.move(2, 1, 2, 3);
    obj.move(4, 1, 2, 1);
    obj.move(4, 3, 4, 1);
    obj.move(6, 2, 4, 2);
    obj.move(6, 4, 6, 2);
    obj.move(5, 4, 5, 2);
    obj.move(4, 5, 4, 3);
    obj.move(3, 3, 5, 3);
    obj.move(5, 2, 5, 4);
    obj.move(4, 1, 4, 3);
    obj.move(2, 0, 2, 2);
    obj.move(2, 3, 2, 1);
    obj.move(4, 0, 2, 0);
    obj.move(2, 0, 2, 2);
    obj.move(2, 2, 4, 2);
    obj.move(4, 3, 4, 1);
    obj.move(2, 5, 2, 3);
    obj.move(0, 2, 2, 2);
    obj.move(0, 4, 0, 2);
    obj.move(2, 2, 2, 4);
    obj.move(2, 4, 0, 4);
    obj.move(3, 5, 3, 3);
    assertEquals("    O _ O\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ O _ _ _ _ O\n" +
            "    _ _ O\n" +
            "    O _ _", obj.getGameState());
    assertEquals(9, obj.getScore());
    assertTrue(obj.isGameOver());
  }

  @Test
  public void testMoveAfterGameOver() {
    MarbleSolitaireModel obj = new MarbleSolitaireModelImpl(3, 0, 3);
    obj.move(2, 3, 0, 3);
    obj.move(2, 1, 2, 3);
    obj.move(4, 1, 2, 1);
    obj.move(4, 3, 4, 1);
    obj.move(6, 2, 4, 2);
    obj.move(6, 4, 6, 2);
    obj.move(5, 4, 5, 2);
    obj.move(4, 5, 4, 3);
    obj.move(3, 3, 5, 3);
    obj.move(5, 2, 5, 4);
    obj.move(4, 1, 4, 3);
    obj.move(2, 0, 2, 2);
    obj.move(2, 3, 2, 1);
    obj.move(4, 0, 2, 0);
    obj.move(2, 0, 2, 2);
    obj.move(2, 2, 4, 2);
    obj.move(4, 3, 4, 1);
    obj.move(2, 5, 2, 3);
    obj.move(0, 2, 2, 2);
    obj.move(0, 4, 0, 2);
    obj.move(2, 2, 2, 4);
    obj.move(2, 4, 0, 4);
    obj.move(3, 5, 3, 3);
    obj.move(3, 3, 2, 2); //move after game over
    assertEquals("    O _ O\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O _ _ O\n" +
            "_ O _ _ _ _ O\n" +
            "    _ _ O\n" +
            "    O _ _", obj.getGameState());
    assertEquals(9, obj.getScore());
    assertTrue(obj.isGameOver());
  }
}

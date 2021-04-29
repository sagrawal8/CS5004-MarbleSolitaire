package cs5004.marblesolitaire.model;

/**
 * Implementation of MarbleSolitaireModel Interface.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  //Solitaire Board
  private Character[][] board;
  //Thickness of Arm
  private int armThickness;
  //Size of Row
  private int rowSize;

  /**
   * Sets board[row][col] to '_'.
   *
   * @param row row.
   * @param col column.
   */
  private void setToEmpty(int row, int col) {
    board[row][col] = '_';
  }

  /**
   * Creates board of armThickness 3 with all indexes as 'O'.
   *
   * @param armThickness Thickness of arm.
   */
  private void defaultBoard(int armThickness) {
    this.armThickness = armThickness;
    rowSize = armThickness * 3 - 2;
    board = new Character[rowSize][rowSize];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i < armThickness - 1 || i >= 2 * armThickness - 1) {
          if (j < armThickness - 1 || j >= 2 * armThickness - 1) {
            board[i][j] = ' ';
          } else {
            board[i][j] = 'O';
          }
        } else {
          board[i][j] = 'O';
        }
      }
    }
  }

  /**
   * Public constructor that creates board of thickness 3 and empty spot at
   * middle of board.
   */
  public MarbleSolitaireModelImpl() {
    defaultBoard(3);
    setToEmpty((rowSize - 1) / 2, (rowSize - 1) / 2);
  }

  /**
   * Constructor that creates a board of thickness 3 and empty spot at row and
   * column specified in arguments.
   *
   * @param sRow row.
   * @param sCol column.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    defaultBoard(3);
    try {
      if (board[sRow][sCol] == ' ') {
        throw new IndexOutOfBoundsException();
      }
      setToEmpty(sRow, sCol);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + sRow + "," + sCol + ")");
    }
  }

  /**
   * Constructor that creates a board of thickness specified and empty spot at
   * the middle of the board.
   *
   * @param armThickness thickness of arm.
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    if (armThickness < 1) {
      throw new IllegalArgumentException("Arm thickness is not positive.");
    }
    if (armThickness % 2 != 1) {
      throw new IllegalArgumentException("Arm thickness is not odd.");
    }
    defaultBoard(armThickness);
    setToEmpty((rowSize - 1) / 2, (rowSize - 1) / 2);
  }

  /**
   * Constructor that creates a board of thickness specified and empty spot at
   * the row and column specified.
   *
   * @param armThickness Thickness of arm
   * @param row          Row.
   * @param col          Column.
   */
  public MarbleSolitaireModelImpl(int armThickness, int row, int col) {
    if (armThickness < 1) {
      throw new IllegalArgumentException("Arm thickness is not positive.");
    }
    if (armThickness % 2 != 1) {
      throw new IllegalArgumentException("Arm thickness is not odd.");
    }
    defaultBoard(armThickness);
    try {
      if (board[row][col] == ' ') {
        throw new IndexOutOfBoundsException();
      }
      setToEmpty(row, col);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + row + "," + col + ")");
    }
  }

  private int checkValidMove(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    try {
      if (board[fromRow][fromCol] == 'O' && board[toRow][toCol] == '_') {
        if (fromRow == toRow) {
          if (toCol - fromCol == 2) {
            if (board[fromRow][fromCol + 1] == 'O') {
              return 1;
            }
          } else if (fromCol - toCol == 2) {
            if (board[fromRow][toCol + 1] == 'O') {
              return 2;
            }
          }
        } else if (fromCol == toCol) {
          if (fromRow - toRow == 2) {
            if (board[toRow + 1][fromCol] == 'O') {
              return 3;
            }
          } else if (toRow - fromRow == 2) {
            if (board[fromRow + 1][toCol] == 'O') {
              return 4;
            }
          }
        }
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (isGameOver()) {
      return;
    }
    int check = checkValidMove(fromRow, fromCol, toRow, toCol);
    boolean flag = false;
    try {
      if (check == 1) {
        board[fromRow][fromCol] = '_';
        board[fromRow][fromCol + 1] = '_';
        board[toRow][toCol] = 'O';
        flag = true;
      } else if (check == 2) {
        board[fromRow][fromCol] = '_';
        board[fromRow][toCol + 1] = '_';
        board[toRow][toCol] = 'O';
        flag = true;
      } else if (check == 3) {
        board[fromRow][fromCol] = '_';
        board[toRow + 1][fromCol] = '_';
        board[toRow][toCol] = 'O';
        flag = true;
      } else if (check == 4) {
        board[fromRow][fromCol] = '_';
        board[fromRow + 1][toCol] = '_';
        board[toRow][toCol] = 'O';
        flag = true;
      }
      if (!flag) {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid Move");
    }
  }

  @Override
  public boolean isGameOver() {
    if (getScore() == 1) {
      return true;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          if (checkValidMove(i, j, i + 2, j) != -1
                  || checkValidMove(i, j, i - 2, j) != -1
                  || checkValidMove(i, j, i, j + 2) != -1
                  || checkValidMove(i, j, i, j - 2) != -1) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == ' ') {
          if (j < armThickness - 1) {
            str.append(" ");
          } else {
            break;
          }
        } else if (board[i][j] == 'O') {
          str.append("O");
        } else {
          str.append("_");
        }
        if (j != board.length - 1) {
          try {
            if (j < armThickness - 1 || board[i][j + 1] != ' ') {
              str.append(" ");
            }
          } catch (IndexOutOfBoundsException e) {
            continue;
          }
        }
      }
      if (i < board.length - 1) {
        str.append("\n");
      }
    }
    return str.toString();
  }

  @Override
  public int getScore() {
    int count = 0;
    for (Character[] characters : board) {
      for (int j = 0; j < board[0].length; j++) {
        if (characters[j] == 'O') {
          count++;
        }
      }
    }
    return count;
  }

}

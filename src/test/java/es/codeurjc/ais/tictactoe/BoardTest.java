package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;

import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

import org.junit.Test;


public class BoardTest {
	private Board board = new Board();
	

	@Test
	public void testGetCellsIfWinFirst() {
		int[] firstPositions ={ 6, 4, 2 };
		int[] secondPosition = { 1, 7, 8 };
		marcarCeldas(firstPositions,secondPosition,6);
		int[] winner = board.getCellsIfWinner("X");
		for (int i = 0;i < firstPositions.length; i++) {		
			assertEquals(firstPositions[i],winner[i]);			
		}
	}
	@Test
	public void testGetCellsIfWinSecond() {
		int[] secondPosition ={ 6, 4, 2 };
		int[] firstPositions = { 1, 7, 8 };
		marcarCeldas(firstPositions,secondPosition,6);
		int[] winner = board.getCellsIfWinner("O");
		for (int i = 0;i < firstPositions.length; i++) {		
			assertEquals(secondPosition[i],winner[i]);			
		}
	}

	@Test
	public void testCheckDraw() {
		int[] firstPositions ={0, 1, 3, 4, 7 };
		int[] secondPosition = { 2, 5, 6 , 8 };
		marcarCeldas(firstPositions,secondPosition,9);
		assertTrue(board.checkDraw());
	}
	
private void marcarCeldas(int[] posX, int[] posY, int nMarks) {
		Cell aux;
		for (int i = 0; i < nMarks; i++) {			
			if ((i % 2) == 0){
				aux = board.getCell(posX[i/2]);
					aux.value = "X";
			} else {
				aux = board.getCell(posY[(i-1)/2]);

					aux.value = "O";
			}
		}

	}
}

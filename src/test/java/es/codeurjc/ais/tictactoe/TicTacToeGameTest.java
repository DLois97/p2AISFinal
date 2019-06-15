package es.codeurjc.ais.tictactoe;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.hamcrest.MockitoHamcrest.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import es.codeurjc.ais.tictactoe.TicTacToeGame.CellMarkedValue;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerResult;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;

public class TicTacToeGameTest {
	TicTacToeGame game;
	Connection conection1;
	Connection conection2;
	@Before
	 public void setUp() {
		this.game = new TicTacToeGame();
		conection1 = mock(Connection.class);
		conection2 = mock(Connection.class);
		this.game.addConnection(conection1);
		this.game.addConnection(conection2);
	}
	@Test
	public void testIfWinFirst() {
		Player p1 = new Player(1,"X","Player1");
		Player p2 = new Player(2,"O","Player2");
		this.game.addPlayer(p1);
		this.game.addPlayer(p2);
		verify(conection1,times(2)).sendEvent(eq(EventType.JOIN_GAME),  argThat(hasItems(p1, p2)));
		verify(conection2,times(2)).sendEvent(eq(EventType.JOIN_GAME),  argThat(hasItems(p1, p2)));
		verify(conection1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(conection2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(conection1);reset(conection2);
		this.game.mark(6);
		verify(conection1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(conection2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		this.game.mark(1);
		this.game.mark(4);
		this.game.mark(7);	
		reset(conection1);
		reset(conection2);
		this.game.mark(2);
		ArgumentCaptor<WinnerValue> argument =	ArgumentCaptor.forClass(WinnerValue.class);
		verify(conection1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		WinnerValue winner = (WinnerValue)argument.getValue();
		verify(conection2).sendEvent(eq(EventType.GAME_OVER),argument.capture());
		WinnerValue winner2 = (WinnerValue)argument.getValue();
		assertEquals(p1.getId(),winner.player.getId());
		assertEquals(p1.getId(),winner2.player.getId());

	}
	@Test
	public void testIfWinSecond() {
		Player p1 = new Player(1,"X","Player1");
		Player p2 = new Player(2,"O","Player2");
		this.game.addPlayer(p1);
		this.game.addPlayer(p2);
		verify(conection1,times(2)).sendEvent(eq(EventType.JOIN_GAME),  argThat(hasItems(p1, p2)));
		verify(conection2,times(2)).sendEvent(eq(EventType.JOIN_GAME),  argThat(hasItems(p1, p2)));
		verify(conection1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(conection2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(conection1);reset(conection2);
		this.game.mark(1);
		verify(conection1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(conection2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		this.game.mark(6);
		this.game.mark(7);
		this.game.mark(4);	
		this.game.mark(8);
		reset(conection1);
		reset(conection2);
		this.game.mark(2);	
		ArgumentCaptor<WinnerValue> argument =	ArgumentCaptor.forClass(WinnerValue.class);
		verify(conection1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		WinnerValue winner = (WinnerValue)argument.getValue();
		verify(conection2).sendEvent(eq(EventType.GAME_OVER),argument.capture());
		WinnerValue winner2 = (WinnerValue)argument.getValue();
		assertEquals(p2.getId(),winner.player.getId());
		assertEquals(p2.getId(),winner2.player.getId());
	}
	@Test
	public void testCheckDraw() {
		Player p1 = new Player(1,"X","Player1");
		Player p2 = new Player(2,"O","Player2");
		this.game.addPlayer(p1);
		this.game.addPlayer(p2);
		verify(conection1,times(2)).sendEvent(eq(EventType.JOIN_GAME),  argThat(hasItems(p1, p2)));
		verify(conection2,times(2)).sendEvent(eq(EventType.JOIN_GAME),  argThat(hasItems(p1, p2)));
		verify(conection1).sendEvent(eq(EventType.SET_TURN),eq(p1));
		verify(conection2).sendEvent(eq(EventType.SET_TURN),eq(p1));
		reset(conection1);reset(conection2);
		this.game.mark(0);
		verify(conection1).sendEvent(eq(EventType.SET_TURN),eq(p2));
		verify(conection2).sendEvent(eq(EventType.SET_TURN),eq(p2));
		this.game.mark(1);
		this.game.mark(2);
		this.game.mark(3);	
		this.game.mark(4);
		this.game.mark(8);
		this.game.mark(5);
		this.game.mark(6);
		reset(conection1);
		reset(conection2);
		this.game.mark(7);	
		ArgumentCaptor<WinnerValue> argument =	ArgumentCaptor.forClass(WinnerValue.class);
		verify(conection1).sendEvent(eq(EventType.GAME_OVER),argument.capture());
		Object event = argument.getValue();
		verify(conection2).sendEvent(eq(EventType.GAME_OVER),argument.capture());
		Object event2 = argument.getValue();
		assertEquals(null,event);
		assertEquals(null,event2);
//		assertEquals(null,event);
	}
	private void clearMocks(Connection c1, Connection c2) {
		reset(c1);
		reset(c2);
	}
	
}


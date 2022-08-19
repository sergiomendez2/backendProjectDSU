package com.example.backendproject.model;

public class TTTTurn {
	private int id_turn;
	private boolean finished;
	private Player id_playerX;
	private Player id_playerO;
	private Player winner;
	private boolean isDraw;
	private int movements_playerX;
	private int movements_playerO;

	public int getId_turn() {
		return id_turn;
	}

	public void setId_turn(int id_turn) {
		this.id_turn = id_turn;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Player getId_playerX() {
		return id_playerX;
	}

	public void setId_playerX(Player id_playerX) {
		this.id_playerX = id_playerX;
	}

	public Player getId_playerO() {
		return id_playerO;
	}

	public void setId_playerO(Player id_playerO) {
		this.id_playerO = id_playerO;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDraw(boolean draw) {
		isDraw = draw;
	}

	public int getMovements_playerX() {
		return movements_playerX;
	}

	public void setMovements_playerX(int movements_playerX) {
		this.movements_playerX = movements_playerX;
	}

	public int getMovements_playerO() {
		return movements_playerO;
	}

	public void setMovements_playerO(int movements_playerO) {
		this.movements_playerO = movements_playerO;
	}
}

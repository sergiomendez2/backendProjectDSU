package com.example.backendproject.model;

public class Statistic {
	private int idStatistic;
	private Player Winner;
	private Player Loser;
	private TypeGame TypeGame;
	private int id_tttTurn;
	private int id_hangmanTurn;

	public int getIdStatistic() {
		return idStatistic;
	}

	public void setIdStatistic(int idStatistic) {
		this.idStatistic = idStatistic;
	}

	public Player getWinner() {
		return Winner;
	}

	public void setWinner(Player winner) {
		Winner = winner;
	}

	public Player getLoser() {
		return Loser;
	}

	public void setLoser(Player loser) {
		Loser = loser;
	}

	public com.example.backendproject.model.TypeGame getTypeGame() {
		return TypeGame;
	}

	public void setTypeGame(com.example.backendproject.model.TypeGame typeGame) {
		TypeGame = typeGame;
	}

	public int getId_tttTurn() {
		return id_tttTurn;
	}

	public void setId_tttTurn(int id_tttTurn) {
		this.id_tttTurn = id_tttTurn;
	}

	public int getId_hangmanTurn() {
		return id_hangmanTurn;
	}

	public void setId_hangmanTurn(int id_hangmanTurn) {
		this.id_hangmanTurn = id_hangmanTurn;
	}

	@Override
	public String toString() {
		return "Statistics{" +
				"Id Statistic: " + idStatistic +
				", Winner: " + Winner.getName() +
				", Loser: " + Loser.getName() +
				", TypeGame: " + TypeGame +
				'}';
	}
}

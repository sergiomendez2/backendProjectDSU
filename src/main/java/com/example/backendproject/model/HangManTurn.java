package com.example.backendproject.model;

public class HangManTurn {
	private int id_turn;
	private boolean finished;
	private Player playerGuesser;
	private Player playerGiver;
	private boolean isHangedMan;

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

	public Player getPlayerGuesser() {
		return playerGuesser;
	}

	public void setPlayerGuesser(Player playerGuesser) {
		this.playerGuesser = playerGuesser;
	}

	public Player getPlayerGiver() {
		return playerGiver;
	}

	public void setPlayerGiver(Player playerGiver) {
		this.playerGiver = playerGiver;
	}

	public boolean isHangedMan() {
		return isHangedMan;
	}

	public void setHangedMan(boolean hangedMan) {
		isHangedMan = hangedMan;
	}
}

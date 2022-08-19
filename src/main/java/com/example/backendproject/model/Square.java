package com.example.backendproject.model;

public class Square {
	private int id_turn;
	private int column;
	private int row;
	private Piece piece;

	public int getId_turn() {
		return id_turn;
	}

	public void setId_turn(int id_turn) {
		this.id_turn = id_turn;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}

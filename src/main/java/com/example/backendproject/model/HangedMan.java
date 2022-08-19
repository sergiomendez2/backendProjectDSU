package com.example.backendproject.model;

public class HangedMan {
	private int id_hangMan;
	private String secreteWord;
	private int triesLeft;
	private String lettersUsed;
	private int id_hangManTurn;

	public int getId_hangMan() {
		return id_hangMan;
	}

	public void setId_hangMan(int id_hangMan) {
		this.id_hangMan = id_hangMan;
	}

	public String getSecreteWord() {
		return secreteWord;
	}

	public void setSecreteWord(String secreteWord) {
		this.secreteWord = secreteWord;
	}

	public int getTriesLeft() {
		return triesLeft;
	}

	public void setTriesLeft(int triesLeft) {
		this.triesLeft = triesLeft;
	}

	public String getLettersUsed() {
		return lettersUsed;
	}

	public void setLettersUsed(String lettersUsed) {
		this.lettersUsed = lettersUsed;
	}

	public int getId_hangManTurn() {
		return id_hangManTurn;
	}

	public void setId_hangManTurn(int id_hangManTurn) {
		this.id_hangManTurn = id_hangManTurn;
	}
}

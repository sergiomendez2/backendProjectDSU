package com.example.backendproject.model;

public class Player {
	private int id;
    private String name;
	private TypePlayer typePlayer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypePlayer getTypePlayer() {
		return typePlayer;
	}

	public void setTypePlayer(TypePlayer typePlayer) {
		this.typePlayer = typePlayer;
	}
}

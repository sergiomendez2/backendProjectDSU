package com.example.backendproject.model;

import java.util.ArrayList;
import java.util.List;

public class TypePlayer {
	private int id;
	private String name;
	public static List<TypePlayer> listOfTypesPlayer = new ArrayList<>();




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


}

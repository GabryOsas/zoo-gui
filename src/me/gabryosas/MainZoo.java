package me.gabryosas;

import java.util.ArrayList;

public class MainZoo {
	public static ArrayList<Animali> animaliList = new ArrayList<Animali>();

	public static void main(String[] args) {
		CreateAnimal frame = new CreateAnimal();
		frame.setVisible(true);
	}
	
}

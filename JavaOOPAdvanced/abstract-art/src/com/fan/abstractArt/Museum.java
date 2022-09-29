package com.fan.abstractArt;

import java.util.ArrayList;
import java.util.Collections;

import com.fan.abstractArt.abstracts.Art;
import com.fan.abstractArt.models.Painting;
import com.fan.abstractArt.models.Sculpture;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Art> museum = new ArrayList<Art>();
		Painting p1 = new Painting("Mona Lisa", "Leonardo da Vinci", " half-length portrait painting", "Oil");
		Painting p2 = new Painting("Painting2", "Artist1", "a beautiful painting", "Oil");
		Painting p3 = new Painting("Painting3", "Artist1", "A not so good painting", "Oil");
		Painting p4 = new Painting("Painting4", "Artist2", "A sketch", "Graphite");
		Sculpture s1 = new Sculpture("Cat","Alberto Giacometti","passed just like a ray of light", "Bronze");
		Sculpture s2 = new Sculpture("Sculp2","Artist1","Is this a banana taped on wall?", "banana, tape");
		Sculpture s3 = new Sculpture("Sculp3","Artist3","THIS IS ART!", "Paper");
		Sculpture s4 = new Sculpture("Sculp4","Artist4","Bird", "Bronze");
		
		Collections.addAll(museum, p1,p2,p3,p4,s1,s2,s3,s4);
		for (Art art : museum) {
			art.viewArt();
		}
		System.out.println("*****************************");
		Collections.shuffle(museum);
		for (Art art : museum) {
			art.viewArt();
		}
	}

}

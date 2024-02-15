package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */

	Node<TrainCar> head;
	HashMap<String, Integer> info = new HashMap<String, Integer>();

	String findIntel(LinkedList<TrainCar> train, String[] clues) {

		String name = "";
		int sus = 0;
		head = train.getHead();
		while (head != null) {
			String currentName = head.getValue().questionPassenger().split(" ")[13];
			System.out.println(currentName);
			System.out.println(info.toString());
			for (int j = 0; j < clues.length; j++) {
				System.out.println(clues[j] + " - " + getClues(head.getValue().questionPassenger()));
    			if (clues[j].equals(getClues(head.getValue().questionPassenger()))){
    				if (info.containsKey(currentName)) {
    					int biggerSus = info.get(currentName) + 1;
    					if (biggerSus > sus) {
    						sus = biggerSus;
    						name = currentName;
    					}
    					info.put(currentName, biggerSus);
    				} else {
    					info.put(currentName, 0);
    				}
    				
    			}
    		}
			head = head.getNext();
		}
		
		

		System.out.println(name);
		return name;

	}

	String getClues(String v) {
		String[] vArr = v.split(" ");
		String clues = "";
		for (int i = 0; i < vArr.length; i++) {
			if (i >= 14) {
				clues += vArr[i] + " ";
			}
		}
		StringBuilder s = new StringBuilder(clues);
		return s.deleteCharAt(s.indexOf(".")).toString().trim();
	}

}

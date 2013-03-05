package org.etmk.listsegsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PersonRepository {

	private List<Person> peeps;

	public List<Person> getPeople() {
		if (peeps == null) {
			peeps = new ArrayList<Person>();

			Random r1 = new Random();
			Random r2 = new Random();

			for (int i = 0; i < 150; i++) {
				Person p = new Person();
				p.setFirstName(givenNames[Math.abs(r1.nextInt()) % givenNames.length]);
				p.setLastName(surnames[Math.abs(r2.nextInt()) % surnames.length]);
				peeps.add(p);
			}
			Collections.sort(peeps, new Comparator<Person>() {

				@Override
				public int compare(Person lhs, Person rhs) {
					return lhs.getLastName().compareToIgnoreCase(rhs.getLastName());
				}
			});
		}
		return peeps;
	}

	private String[] surnames = new String[] { "Alexander", "Anderson", "Black", "Bigsby", 
			"Cartwright", "Catz", "Cervantes", "Dufenschmirtz", "Delaney", "Dorn", "Eno","Endres", "Fulco", "Filbert", "Gregory", 
			"Herzog", "Ilian", "Jackson", "Killian", "Love", "Morgan", "Merz", "Michelson",
			"Neiman", "OMalley","Oppenheimer", "Pope", "Querenius", "Roche", "Smith",
			"Tino", "Urino", "Victor", "Walsh", "Xenophobe", "Yellen", "Zebra"

	};

	private String[] givenNames = new String[] { "Alice", "Albert", "Bob",
			"Barry", "Chris", "Dave", "David", "Ellen", "Erin", "Fred",
			"Frank", "George", "Greg", "Hilda", "Irene", "Jacob", "John",
			"Jim", "Kelly", "Robert", "Steve", "Tim", "Terry", "Tommy", "Frida" };
}

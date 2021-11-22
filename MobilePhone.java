package labwork_1;

import utils.*;

enum Color {
	RED('R'),
	ORANGE('O'),
	YELLOW('Y'),
	BLACK('B'),
	PURPLE('P');

	char color;
	
	Color(char c) {
		this.color = c;
	}
}
public class MobilePhone {
	
	@DomainConstraint(type = "String", mutable = false, optional = false, length = 30)
	private String manName;
	@DomainConstraint(type = "String", mutable = false, optional = false, length = 9)
	private String model;
	@DomainConstraint(type = "Character", mutable = true, optional = false, length = 1)
	private Color color;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1970, max = 2021)
	private int year;
	@DomainConstraint(type = "Boolean", mutable = true, optional = false)
	private boolean guaranteed;
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("name")
	public boolean setName(String name) {
		if (validateName(name)) {
			this.manName = name;
			return true;
		} else {
			return false;
		}
	}
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("model")
	public boolean setModel(String model) {
		if (validateModel(model)) {
			this.model = model;
			return true;
		} else {
			return false;
		}
	}
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("color")
	public boolean setColor(char c) {
		if (validateColor(c)) {
			this.color.color = c;
			return true;
		} else {
			return false;
		}
	}
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("year")
	public boolean setYear(int year) {
		if (validateYear(year)) {
			this.year = year;
			return true;
		} else {
			return false;
		}
	}
	
	private boolean validateName(String name) {
		String[] words = name.split(" ");
		int count = words.length;
		return (name != null && 
				name.length() > 0 && 
				name.length() <= 30 &&
				count >= 2);
	}
	
	private boolean validateModel(String model) {
		return (model != null && 
				model.length() > 0 && 
				model.length() <= 9 &&
				model.charAt(0) == 'M' &&
				model.charAt(1) == '-' &&
				model.charAt(5) == '-' &&
				!Character.isDigit(model.charAt(2)) &&
				!Character.isDigit(model.charAt(3)) &&
				!Character.isDigit(model.charAt(4)) &&
				Character.isDigit(model.charAt(6)) &&
				Character.isDigit(model.charAt(7)) &&
				Character.isDigit(model.charAt(8)));
	}
	
	private boolean validateColor(char color) {
		return (color == 'R' ||
				color == 'O' ||
				color == 'Y' ||
				color == 'B' ||
				color == 'P');
	}
	
	private boolean validateYear(int year) {
		return (year >= 1970 &&
				year <= 2021);
	}
	
}

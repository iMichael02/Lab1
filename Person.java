package labwork_1;

import utils.*;

public class Person {
	
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
	private int id;
	@DomainConstraint(type = "String", optional = false, length = 30)
	private String name;
	@DomainConstraint(type = "MobilePhone")
	private MobilePhone phone;
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("id")
	public boolean setID(int id) {
		if (validateID(id)) {
			this.id = id;
			return true;
		} else {
			return false;
		}
	}
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("name")
	public boolean setName(String name) {
		if (validateName(name)) {
			this.name = name;
			return true;
		} else {
			return false;
		}
	}
	
	@DOpt(type=OptType.Mutator) 
	@AttrRef("phone")
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}
	
	private boolean validateID(int id) {
		return id >= 1;
	}
	
	private boolean validateName(String name) {
		return (name != null && 
				name.length() > 0 && 
				name.length() <= 30);
	}
	
	public void greet() {
		System.out.println("Bonjour, monsier!");
	}
}

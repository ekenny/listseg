package org.etmk.listsegsample.complex;

public class Category {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
	}

	@Override
	public boolean equals(Object o) {

		if (o == null)
		{
			return false;
		}
		if (!(o instanceof Category))
		{
			return false;
		}
		Category that = (Category) o;
		if (that.name == null)
		{
			return this.name == null;
		}
		return that.name.equalsIgnoreCase(this.name);
	}
	
	@Override
	public int hashCode() {
		return name == null ? 0 : name.hashCode();
	}
}

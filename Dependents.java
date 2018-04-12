

//Author: Abhilash

public class Dependents {

	private String mother;
	private String father;
	private Integer child;
	
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother=mother;
	}
	
	public String getFather() {
		return father;
	}
	
	public void setFather(String father) {
		this.father=father;		
	}
	
	public Integer getChild() {
		return child;
	}
	public void setChild(Integer child) {
		this.child=child;
	}
	
	@Override
	public String toString() {
		return "Dependents [Mother="+mother+",Father="+father+",Child="+child+"]";
	}
}

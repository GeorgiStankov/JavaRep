package week10;

public class Type {

	String name;
	String takes;
	String returns;

	Type(String name,String tak,String ret) {
     this.name=name;
     this.takes=tak;
     this.returns=ret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTakes() {
		return takes;
	}

	public void setTakes(String takes) {
		this.takes = takes;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}

	

}

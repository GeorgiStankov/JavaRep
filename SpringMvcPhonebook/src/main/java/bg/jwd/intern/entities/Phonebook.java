package bg.jwd.intern.entities;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRY")
public class Phonebook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393672004773752156L;

	@Id
	@Column
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "number")
	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirstLetters(String number) {
		Pattern pat = Pattern.compile("(^(\\+359)|^(0)|^(00359))((87)|(88)|(89))[^0-1]{1}[0-9]{6}$");
		Matcher matcher = pat.matcher(number);
		if (matcher.find()) {
			if (number.substring(0, 5).equals("00359")) {
				number = number.replace("00359", "+359");
			} else if (number.charAt(0) == '0') {
				number = number.replace("0", "+359");
			}

			return number;

		}
		return null;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return this.name + " " + this.number;
	}

	public boolean equals(Phonebook phonebook) {
		if (!(phonebook instanceof Phonebook)) {
			return false;
		}

		Phonebook that = (Phonebook) phonebook;

		// Custom equality check here.
		return this.name.equals(that.name) && this.number.equals(that.number);
	}

}

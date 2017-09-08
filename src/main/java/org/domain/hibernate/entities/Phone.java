package org.domain.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name="Phone")
public class Phone {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		if (id != null ? !id.equals(phone.id) : phone.id != null) return false;
		return number != null ? number.equals(phone.number) : phone.number == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (number != null ? number.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"id=" + id +
				", number='" + number + '\'' +
				'}';
	}
}
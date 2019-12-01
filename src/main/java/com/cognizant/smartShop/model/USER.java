package com.cognizant.smartShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class USER {

	@Override
	public String toString() {
		return "USER [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", age=" + age + ", contact=" + contact + ", role=" + role + ", status="
				+ status + ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3
				+ ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@NotNull
	@Size(min = 3)
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "firstname")
	private String firstname;
	
	@NotNull
	@Column(name = "lastname")
	private String lastname;
	
	@NotNull
	@Size(min = 2)
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "age")
	private int age;
	
	@NotNull
	@Size(min = 10)
	@Column(name = "contact")
	private String contact;
	
	@NotNull
	@Size(max = 1)
	@Column(name = "user_type")
	private String role;
	
	@NotNull
	@Size(max = 1)
	@Column(name = "status")
	private String status;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "question1")
	private String question1;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "question2")
	private String question2;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "question3")
	private String question3;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "answer1")
	private String answer1;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "answer2")
	private String answer2;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "answer3")
	private String answer3;
	
	@Column(name = "gender")
	private String gender;
	
	public USER(){
		
	}
	
	
	public USER(@NotNull @Size(min = 3) String username, @NotNull String firstname, @NotNull String lastname,
			@NotNull @Size(min = 2) String password, @NotNull int age, @NotNull @Size(min = 10) String contact,
			@NotNull @Size(max = 1) String role, @NotNull @Size(max = 1) String status,
			@NotNull @Size(max = 50) String question1, @NotNull @Size(max = 50) String question2,
			@NotNull @Size(max = 50) String question3, @NotNull @Size(max = 50) String answer1,
			@NotNull @Size(max = 50) String answer2, @NotNull @Size(max = 50) String answer3, String gender) {
		
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.age = age;
		this.contact = contact;
		this.role = role;
		this.status = status;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

//	public List<Role> getRoleList() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((answer1 == null) ? 0 : answer1.hashCode());
		result = prime * result + ((answer2 == null) ? 0 : answer2.hashCode());
		result = prime * result + ((answer3 == null) ? 0 : answer3.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((question1 == null) ? 0 : question1.hashCode());
		result = prime * result + ((question2 == null) ? 0 : question2.hashCode());
		result = prime * result + ((question3 == null) ? 0 : question3.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		USER other = (USER) obj;
		if (age != other.age)
			return false;
		if (answer1 == null) {
			if (other.answer1 != null)
				return false;
		} else if (!answer1.equals(other.answer1))
			return false;
		if (answer2 == null) {
			if (other.answer2 != null)
				return false;
		} else if (!answer2.equals(other.answer2))
			return false;
		if (answer3 == null) {
			if (other.answer3 != null)
				return false;
		} else if (!answer3.equals(other.answer3))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (question1 == null) {
			if (other.question1 != null)
				return false;
		} else if (!question1.equals(other.question1))
			return false;
		if (question2 == null) {
			if (other.question2 != null)
				return false;
		} else if (!question2.equals(other.question2))
			return false;
		if (question3 == null) {
			if (other.question3 != null)
				return false;
		} else if (!question3.equals(other.question3))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

}
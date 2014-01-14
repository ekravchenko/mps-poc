package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonVO implements Serializable {

	private static final long serialVersionUID = -1836417463940417080L;

	private byte[] personPK;
	private String identyNumber;
	private String personName;
	private String personSurname;
	private List<ChildVO> childList = new ArrayList<ChildVO>();

	public byte[] getPersonPK() {
		return personPK;
	}

	public void setPersonPK(byte[] personPK) {
		this.personPK = personPK;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonSurname() {
		return personSurname;
	}

	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}

	public List<ChildVO> getChildList() {
		return childList;
	}

	public void setChildList(List<ChildVO> childList) {
		this.childList = childList;
	}

	public String getIdentyNumber() {
		return identyNumber;
	}

	public void setIdentyNumber(String identyNumber) {
		this.identyNumber = identyNumber;
	}

	@Override
	public String toString() {
		return new StringBuilder("Person:").append("`ID`: ").append(Arrays.toString(personPK)).append(" `Identy Number`: ").append(identyNumber)
				.append(" `Name`: ").append(personName).append(" `Surname`: ").append(personSurname).append(" `Children`: ").append(childList).toString();
	}

}

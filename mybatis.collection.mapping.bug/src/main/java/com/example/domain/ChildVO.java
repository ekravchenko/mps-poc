package com.example.domain;

import java.io.Serializable;
import java.util.Arrays;

public class ChildVO implements Serializable {

	private static final long serialVersionUID = -199854417423940048L;

	private byte[] childPK;
	private String childName;
	private String childSurname;

	public ChildVO() {

	}

	public byte[] getChildPK() {
		return childPK;
	}

	public void setChildPK(byte[] childPK) {
		this.childPK = childPK;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getChildSurname() {
		return childSurname;
	}

	public void setChildSurname(String childSurname) {
		this.childSurname = childSurname;
	}

	@Override
	public String toString() {
		return new StringBuilder("Child").append("`ID`: ").append(Arrays.toString(childPK)).append(" `Child name`: ").append(childName)
				.append(" `Child surname`: ").append(childSurname).toString();
	}
}

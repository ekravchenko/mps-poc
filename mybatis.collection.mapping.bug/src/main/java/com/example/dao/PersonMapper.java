package com.example.dao;

import java.util.List;

import com.example.domain.ChildVO;
import com.example.domain.PersonVO;

public interface PersonMapper {

	public List<PersonVO> getPersonListWithPKAsID();

	public List<PersonVO> getPersonListWithIdentyNumberAsID();

	public List<ChildVO> getChildren();
}

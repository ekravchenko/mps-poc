package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.example.domain.ChildVO;
import com.example.domain.PersonVO;

public class PersonDAO {

	SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();

	public List<PersonVO> getPersonListWithPKAsID() {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

		List<PersonVO> personList = personMapper.getPersonListWithPKAsID();
		return personList;
	}

	public List<PersonVO> getPersonListWithIdentyNumber() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

		List<PersonVO> personList = personMapper.getPersonListWithIdentyNumberAsID();
		return personList;
	}

	public List<ChildVO> getChildrenList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

		List<ChildVO> childList = personMapper.getChildren();
		return childList;
	}

}

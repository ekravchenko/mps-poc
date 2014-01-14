package com.example.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.domain.ChildVO;
import com.example.domain.PersonVO;

public class PersonDAOTest extends DefaultDBUnitTest {

  private PersonDAO personDAO = new PersonDAO();

  /* To be sure, that everything fine with our mappings */
  @Test
  public void testGetChildren() throws Exception {
    List<ChildVO> childrenList = personDAO.getChildrenList();
    Assert.assertNotNull(childrenList);
    Assert.assertEquals(7, childrenList.size());
  }

  /* Fails because of byte[] ID */
  @Test
  public void testGetPersonListWithPKAsID() {
    List<PersonVO> personList = personDAO.getPersonListWithPKAsID();
    Assert.assertNotNull(personList);
    Assert.assertEquals(3, personList.size());

  }

  /* Working as expected. */
  @Test
  public void testGetPersonListWithIdentyNumber() {
    List<PersonVO> personList = personDAO.getPersonListWithIdentyNumber();
    Assert.assertNotNull(personList);
    Assert.assertEquals(3, personList.size());
  }
}

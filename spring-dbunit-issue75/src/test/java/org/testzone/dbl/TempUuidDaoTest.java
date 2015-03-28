package org.testzone.dbl;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testzone.config.TestConfig;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DatabaseSetup("uuidtest.xml")
@DatabaseTearDown(value = "uuidtest.xml", type = DatabaseOperation.DELETE)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TempUuidDaoTest {

    @Autowired
    TempUuidDao tempUuidDaoI;

    @Before
    public void setup() {
    }

    private int size() {
        Collection<TempUuids> all = (Collection) tempUuidDaoI.findAll();
        return all.size();
    }

    @Test
    @ExpectedDatabase(value = "testDelete.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testDeleteUuid() throws Exception {
        int nb = size();
        tempUuidDaoI.delete(tempUuidDaoI.findOne(1));
        assertEquals(nb - 1, size());
    }

    @Test
    @ExpectedDatabase(value = "testUpdate.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testUpdateUuid() throws Exception {
        TempUuids tu = tempUuidDaoI.findOne(1);
        tu.setUuid("4b2f02ca-d857-4c95-b7fa-ee6283ce0d66");
        tempUuidDaoI.save(tu);
        tu = tempUuidDaoI.findOne(1);
        assertEquals("4b2f02ca-d857-4c95-b7fa-ee6283ce0d66", tu.getUuid());
    }

    @Test
    @ExpectedDatabase(value = "testInsert.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testInsertUuid() throws Exception {
        int nb = size();
        TempUuids tu = new TempUuids();
        tu.setId(3);
        tu.setUuid("4b2f02ca-d857-4c95-b7fa-ee6283ce0d67");
        tempUuidDaoI.save(tu);
        assertEquals(nb + 1, size());
    }

}
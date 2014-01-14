package com.example.dao;

import java.io.InputStream;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * This class is required to remove all DBUnit related complexity so that other
 * tests could be very simple
 */
public class DefaultDBUnitTest {

	private IDataSet dataSet;

	@BeforeClass
	public static void beforeClass() throws Exception {
		// Create tables in H2 DB
		ScriptRunner scriptRunner = new ScriptRunner(getDataSource().getConnection());
		scriptRunner.runScript(Resources.getResourceAsReader("schema.sql"));
	}

	@Before
	public void setUp() throws Exception {
		dataSet = getDataSet();
		DatabaseOperation.CLEAN_INSERT.execute(getDatabaseConnection(), dataSet);
	}

	@After
	public void tearDown() throws Exception {
		if (dataSet != null) {
			DatabaseOperation.DELETE_ALL.execute(getDatabaseConnection(), dataSet);
		}
	}

	private IDataSet getDataSet() throws DataSetException {
		InputStream is = getClass().getClassLoader().getResourceAsStream("data.xml");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(is);
		IDataSet replacementDataSet = createReplacementDataSet(dataSet);
		return replacementDataSet;
	}

	private IDataSet createReplacementDataSet(IDataSet dataSet) {
		ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
		for (int i = 1; i <= 100; i++) {
			String param = "id" + i;
			String value = Base64.encodeString(String.valueOf(i));
			replacementDataSet.addReplacementObject(param, value);
		}
		replacementDataSet.addReplacementObject("NULL", null);
		replacementDataSet.addReplacementObject("null", null);
		return replacementDataSet;
	}

	private static DataSource getDataSource() {
		return MyBatisConnectionFactory.getSqlSessionFactory().getConfiguration().getEnvironment().getDataSource();
	}

	private static IDatabaseConnection getDatabaseConnection() throws DatabaseUnitException, SQLException {
		return new DatabaseConnection(getDataSource().getConnection());
	}
}

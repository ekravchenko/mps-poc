package com.example.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;

	private static String CONFIG_FILE_NAME = "mybatis-config.xml";

	private static Logger logger = LoggerFactory.getLogger(MyBatisConnectionFactory.class);

	private static void initSqlSessionFactory() {
		try {
			Reader reader = Resources.getResourceAsReader(CONFIG_FILE_NAME);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (FileNotFoundException e1) {
			logger.error(CONFIG_FILE_NAME + " was not found", e1);
		} catch (IOException e2) {
			logger.error("Couldn't read " + CONFIG_FILE_NAME, e2);
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			initSqlSessionFactory();
		}
		return sqlSessionFactory;
	}
}
package com.stupid.dao;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * @author StupidDog
 * @date 2018-11-13 16:06:01
 */
public interface SysGeneratorDao {

	List<Map<String, Object>> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
}

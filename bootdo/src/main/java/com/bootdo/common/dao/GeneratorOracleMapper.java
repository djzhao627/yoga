package com.bootdo.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface GeneratorOracleMapper {
	//查询所有表的表结构(排除掉回收站中的)（固定字段大小写)）
	@Select("select table_name \"tableName\", ''  \"engine\", ''  \"tableComment\", LAST_ANALYZED \"createTime\" from dba_tables where owner= #{orclUserName} AND table_name not LIKE 'BIN$%' ")
	List<Map<String, Object>> list(String orclUserName);

	@Select("select COUNT(*) from dba_tables where owner=#{orclUserName} AND table_name not LIKE 'BIN$%' ")
	int count(Map<String, Object> map, String orclUserName);

	/**
	 * 查询指定表的表结构
	 * @param tableName（固定字段大小写)
	 * @return
	 */
	@Select("select table_name \"tableName\", ''  \"engine\", ''  \"tableComment\", LAST_ANALYZED \"createTime\" from dba_tables where table_name=#{tableName} ")
	Map<String, String> get(String tableName );

	/**
	 * 查询指定表的字段结构
	 * @param tableName (固定字段大小写)
	 * @return
	 */
	@Select("select t.column_name \"columnName\", DATA_LENGTH \"characterMaximumLength\",NULLABLE \"isNullable\", data_type \"dataType\", c.comments \"columnComment\",p.columnKey \"columnKey\", '' \"extra\" "
			+ "from dba_tab_columns  t "
			+ "LEFT JOIN dba_col_comments c ON t.COLUMN_NAME = c.COLUMN_NAME AND t.table_name=c.table_name "
			+ "LEFT JOIN ( "
			+ "select 'PRI' columnKey, a.column_name, a.table_name "
			+ "from dba_cons_columns a, dba_constraints b "
			+ "where a.constraint_name = b.constraint_name "
			+ "and b.constraint_type = 'P' "
			+ "and a.table_name = #{tableName} "
			+ ") p ON p.COLUMN_NAME = t.COLUMN_NAME AND t.table_name=p.table_name "
			+ "where t.Table_Name= #{tableName} ORDER BY COLUMN_ID ")
	List<Map<String, String>> listColumns(String tableName);
}

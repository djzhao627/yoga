package com.fc.common.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fc.common.config.Constant;
import com.fc.common.dao.*;
import com.fc.common.service.GeneratorService;
import com.fc.common.utils.GenUtils;


@Service
public class GeneratorServiceImpl implements GeneratorService {
	@Autowired
	GeneratorMapper generatorMapper;
	
	@Autowired
	GeneratorOracleMapper genOrclMapper;
	
	//数据库类型
	@Value("${pagehelper.helperDialect}")
    private String dbType = "";
	//oracle用户名
	@Value("${spring.datasource.username}")
	private String orclUserName;
	
	@Override
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> list = new ArrayList<>();
		if(Constant.DATA_TYPE_MYSQL.equals(dbType)){
			list = generatorMapper.list();
		}else if(Constant.DATA_TYPE_ORACLE.equals(dbType)){
			list = genOrclMapper.list(orclUserName.toUpperCase());
		}
		return list;
	}

	@Override
	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		Map<String, String> table = null;
		List<Map<String, String>> columns = null;
		for(String tableName : tableNames){
			table = new HashMap<>();
			columns = new ArrayList<>();
			
			//查询表信息
			if(Constant.DATA_TYPE_MYSQL.equals(dbType)){
				table = generatorMapper.get(tableName);
			}else if(Constant.DATA_TYPE_ORACLE.equals(dbType)){
				table = genOrclMapper.get(tableName );
			}
			//查询列信息
			if(Constant.DATA_TYPE_MYSQL.equals(dbType)){
				columns = generatorMapper.listColumns(tableName);
			}else if(Constant.DATA_TYPE_ORACLE.equals(dbType)){
				columns = genOrclMapper.listColumns(tableName);
			}
			
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

}

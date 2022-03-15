package com.example.basic.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
// Id int Q A String
@Mapper
public interface PollMapper {
	
	int insert(Map<String, Object> map);
	public List<Map<String, Object>> select();

}

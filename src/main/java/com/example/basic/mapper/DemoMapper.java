package com.example.basic.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
public List<Map<String, Object>> select();
public int insert(Map<String, Object> map);
}

// resultType , ParameterType . xml의 namespace 를 해당 class의 경로를 포함한 전체 위치로 지정하여 매핑.
// mybatis 의 result는 다수일 거로 가정을 하고 작성한다.
// 만약 list<STring> 으로 받을경우 1 건의 답을 받을 경우 단일 String 으로 보내지만
// String 으로 받는데 여러건이 나오면 에러가 나온다.


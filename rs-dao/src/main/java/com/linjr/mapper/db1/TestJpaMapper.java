package com.linjr.mapper.db1;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.HashMap;
import java.util.List;

public interface TestJpaMapper {

    @SuppressWarnings("rawtypes")
    @Select("CALL NewProctest(#{userid})")
    @Options(statementType= StatementType.CALLABLE )
    List<HashMap> procTest(@Param("userid") String userid);
}

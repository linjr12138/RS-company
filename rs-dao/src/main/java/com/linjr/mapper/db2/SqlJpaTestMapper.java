package com.linjr.mapper.db2;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.HashMap;
import java.util.List;

public interface SqlJpaTestMapper {

    @SuppressWarnings("rawtypes")
    @Select("exec P_PAD_test #{WhereClient},#{WhereProduct},#{UserCode},#{PageIndex},#{PageSize}")
    @Options(statementType= StatementType.CALLABLE )
    List<HashMap> JpaTest(@Param("WhereClient")String WhereClient,
                          @Param("WhereProduct")String WhereProduct,
                          @Param("UserCode")String UserCode,
                          @Param("PageIndex")Integer PageIndex,
                          @Param("PageSize")Integer PageSize);


    @SuppressWarnings("rawtypes")
    @Select("select \n" +
            "CAST(CAST(CAST((SUM(AmountSum)/(select SUM(Amount) from BaseTarget where ClientCode='1000' group by TargetType)) as DECIMAL(13,2))*100 as DECIMAL(13,2)) as varchar) + '%' as AmountCompletionRate,\n" +
            "CAST(CAST(CAST((SUM(QtySum)/(select SUM(Qty) from BaseTarget where ClientCode='1000' group by TargetType)) as DECIMAL(13,2))*100 as DECIMAL(13,2)) as varchar) + '%' as QuantityCompletionRate\n" +
            "from v_AllActiveOrderDiscount  \n" +
            "where SHOP='1000' and Reserve1 is not null \n" +
            "group by SHOP \n ")
    List<HashMap> completionRate();
}

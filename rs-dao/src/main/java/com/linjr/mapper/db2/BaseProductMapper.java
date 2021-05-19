package com.linjr.mapper.db2;



import com.linjr.entity.db2.BaseProduct;
import com.linjr.vo.req.BaseProductPageReqVO;
import com.linjr.vo.resp.BaseProDuctColorRespVO;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseProductMapper {
    int deleteByPrimaryKey(@Param("prodcode") String prodcode, @Param("colorcode") String colorcode, @Param("pattern") String pattern);

    int insert(BaseProduct record);

    int insertSelective(BaseProduct record);

    BaseProduct selectByPrimaryKey(@Param("prodcode") String prodcode, @Param("colorcode") String colorcode, @Param("pattern") String pattern);

    int updateByPrimaryKeySelective(BaseProduct record);

    int updateByPrimaryKeyWithBLOBs(BaseProduct record);

    int updateByPrimaryKey(BaseProduct record);

    List<BaseProduct> selectAll(BaseProductPageReqVO vo);

    List<BaseProduct> selectAll2();

    List<String> selectOneList();

    List<BaseProduct> selectAllByClientCode(String clientcode);


    @SuppressWarnings("rawtypes")
    @Select("exec P_SelectProduct #{WhereClient}")
    @Options(statementType= StatementType.CALLABLE )
    List<BaseProduct> selectProductByClient(@Param("WhereClient")String WhereClient);

    @SuppressWarnings("rawtypes")
    @Select("exec P_ScreenProduct #{WhereClient}")
    @Options(statementType= StatementType.CALLABLE )
    List<HashMap<String,Object>> screenProductByClient(@Param("WhereClient")String WhereClient);

}
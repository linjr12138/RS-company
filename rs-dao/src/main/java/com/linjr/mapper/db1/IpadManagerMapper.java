package com.linjr.mapper.db1;



import com.linjr.entity.db1.IpadManager;
import com.linjr.vo.req.IpadManagerPageReqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IpadManagerMapper {
    int deleteByPrimaryKey(String id);

    int insert(IpadManager record);

    int insertSelective(IpadManager record);

    IpadManager selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IpadManager record);

    int updateByPrimaryKey(IpadManager record);

    List<IpadManager> selectAll(IpadManagerPageReqVO vo);

    List<IpadManager> selectAlls();

    int deletedIPADs(@Param("ipadManager") IpadManager ipadManager, @Param("list") List<String> list);
}
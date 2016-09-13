package cn.datai.puer.promotion.website.dao;

import cn.datai.puer.promotion.website.vo.SharedInfo;
import cn.datai.puer.promotion.website.vo.SharedInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SharedInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int countByExample(SharedInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int deleteByExample(SharedInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String sharedId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int insert(SharedInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int insertSelective(SharedInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    List<SharedInfo> selectByExample(SharedInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    SharedInfo selectByPrimaryKey(String sharedId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") SharedInfo record, @Param("example") SharedInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") SharedInfo record, @Param("example") SharedInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(SharedInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARED_INFO
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(SharedInfo record);
}
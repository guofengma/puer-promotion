package cn.datai.puer.promotion.website.dao;

import cn.datai.puer.promotion.website.vo.ShareInfo;
import cn.datai.puer.promotion.website.vo.ShareInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShareInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int countByExample(ShareInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int deleteByExample(ShareInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String shareId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int insert(ShareInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int insertSelective(ShareInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    List<ShareInfo> selectByExample(ShareInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    ShareInfo selectByPrimaryKey(String shareId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") ShareInfo record, @Param("example") ShareInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") ShareInfo record, @Param("example") ShareInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(ShareInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: SHARE_INFO
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(ShareInfo record);
}
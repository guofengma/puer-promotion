package cn.datai.puer.promotion.website.dao;

import cn.datai.puer.promotion.website.vo.MemberInfo;
import cn.datai.puer.promotion.website.vo.MemberInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int countByExample(MemberInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int deleteByExample(MemberInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String memberId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int insert(MemberInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int insertSelective(MemberInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    List<MemberInfo> selectByExample(MemberInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    MemberInfo selectByPrimaryKey(String memberId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") MemberInfo record, @Param("example") MemberInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") MemberInfo record, @Param("example") MemberInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(MemberInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: MEMBER_INFO
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(MemberInfo record);
}
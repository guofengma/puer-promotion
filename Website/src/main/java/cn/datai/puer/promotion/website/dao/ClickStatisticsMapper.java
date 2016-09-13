package cn.datai.puer.promotion.website.dao;

import cn.datai.puer.promotion.website.vo.ClickStatistics;
import cn.datai.puer.promotion.website.vo.ClickStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClickStatisticsMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int countByExample(ClickStatisticsExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int deleteByExample(ClickStatisticsExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String clickId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int insert(ClickStatistics record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int insertSelective(ClickStatistics record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    List<ClickStatistics> selectByExample(ClickStatisticsExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    ClickStatistics selectByPrimaryKey(String clickId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") ClickStatistics record, @Param("example") ClickStatisticsExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") ClickStatistics record, @Param("example") ClickStatisticsExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(ClickStatistics record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: CLICK_STATISTICS
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(ClickStatistics record);
}
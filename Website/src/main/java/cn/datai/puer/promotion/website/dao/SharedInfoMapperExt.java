package cn.datai.puer.promotion.website.dao;


import cn.datai.puer.promotion.website.vo.FailedUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedInfoMapperExt extends SharedInfoMapper {
    FailedUserInfo queryFailedUserByMobileNo(@Param("mobileNo") String mobileNo);
}
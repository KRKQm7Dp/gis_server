package generator;

import generator.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}
package com.zztest.aitestmini.common;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: zhangcheng
 * @Description: mybatis 统一父类，简单sql的查询
 * @Date: 2021/3/26/026 11:43
 * @Version: 1.0
 */
public interface MySqlExtensionMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {

}

package com.cl.dao;

import com.cl.entity.DiscussnongziqiyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussnongziqiyeView;


/**
 * 农资企业评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface DiscussnongziqiyeDao extends BaseMapper<DiscussnongziqiyeEntity> {
	
	List<DiscussnongziqiyeView> selectListView(@Param("ew") Wrapper<DiscussnongziqiyeEntity> wrapper);

	List<DiscussnongziqiyeView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnongziqiyeEntity> wrapper);
	
	DiscussnongziqiyeView selectView(@Param("ew") Wrapper<DiscussnongziqiyeEntity> wrapper);
	

}

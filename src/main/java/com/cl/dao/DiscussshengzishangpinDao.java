package com.cl.dao;

import com.cl.entity.DiscussshengzishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshengzishangpinView;


/**
 * 生资商品评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface DiscussshengzishangpinDao extends BaseMapper<DiscussshengzishangpinEntity> {
	
	List<DiscussshengzishangpinView> selectListView(@Param("ew") Wrapper<DiscussshengzishangpinEntity> wrapper);

	List<DiscussshengzishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshengzishangpinEntity> wrapper);
	
	DiscussshengzishangpinView selectView(@Param("ew") Wrapper<DiscussshengzishangpinEntity> wrapper);
	

}

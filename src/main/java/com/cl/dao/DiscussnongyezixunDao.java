package com.cl.dao;

import com.cl.entity.DiscussnongyezixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussnongyezixunView;


/**
 * 农业资讯评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface DiscussnongyezixunDao extends BaseMapper<DiscussnongyezixunEntity> {
	
	List<DiscussnongyezixunView> selectListView(@Param("ew") Wrapper<DiscussnongyezixunEntity> wrapper);

	List<DiscussnongyezixunView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnongyezixunEntity> wrapper);
	
	DiscussnongyezixunView selectView(@Param("ew") Wrapper<DiscussnongyezixunEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.YonghufankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YonghufankuiView;


/**
 * 用户反馈
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface YonghufankuiDao extends BaseMapper<YonghufankuiEntity> {
	
	List<YonghufankuiView> selectListView(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);

	List<YonghufankuiView> selectListView(Pagination page,@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
	
	YonghufankuiView selectView(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.ShengzishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShengzishangpinView;


/**
 * 生资商品
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface ShengzishangpinDao extends BaseMapper<ShengzishangpinEntity> {
	
	List<ShengzishangpinView> selectListView(@Param("ew") Wrapper<ShengzishangpinEntity> wrapper);

	List<ShengzishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<ShengzishangpinEntity> wrapper);
	
	ShengzishangpinView selectView(@Param("ew") Wrapper<ShengzishangpinEntity> wrapper);
	

}

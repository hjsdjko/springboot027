package com.cl.dao;

import com.cl.entity.FapiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaoxinxiView;


/**
 * 发票信息
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface FapiaoxinxiDao extends BaseMapper<FapiaoxinxiEntity> {
	
	List<FapiaoxinxiView> selectListView(@Param("ew") Wrapper<FapiaoxinxiEntity> wrapper);

	List<FapiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FapiaoxinxiEntity> wrapper);
	
	FapiaoxinxiView selectView(@Param("ew") Wrapper<FapiaoxinxiEntity> wrapper);
	

}

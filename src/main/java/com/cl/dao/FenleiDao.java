package com.cl.dao;

import com.cl.entity.FenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FenleiView;


/**
 * 分类
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface FenleiDao extends BaseMapper<FenleiEntity> {
	
	List<FenleiView> selectListView(@Param("ew") Wrapper<FenleiEntity> wrapper);

	List<FenleiView> selectListView(Pagination page,@Param("ew") Wrapper<FenleiEntity> wrapper);
	
	FenleiView selectView(@Param("ew") Wrapper<FenleiEntity> wrapper);
	

}

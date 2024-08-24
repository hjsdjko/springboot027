package com.cl.dao;

import com.cl.entity.NongyezixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongyezixunView;


/**
 * 农业资讯
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface NongyezixunDao extends BaseMapper<NongyezixunEntity> {
	
	List<NongyezixunView> selectListView(@Param("ew") Wrapper<NongyezixunEntity> wrapper);

	List<NongyezixunView> selectListView(Pagination page,@Param("ew") Wrapper<NongyezixunEntity> wrapper);
	
	NongyezixunView selectView(@Param("ew") Wrapper<NongyezixunEntity> wrapper);
	

}

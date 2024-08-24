package com.cl.dao;

import com.cl.entity.NongminEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongminView;


/**
 * 农民
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
public interface NongminDao extends BaseMapper<NongminEntity> {
	
	List<NongminView> selectListView(@Param("ew") Wrapper<NongminEntity> wrapper);

	List<NongminView> selectListView(Pagination page,@Param("ew") Wrapper<NongminEntity> wrapper);
	
	NongminView selectView(@Param("ew") Wrapper<NongminEntity> wrapper);
	

}

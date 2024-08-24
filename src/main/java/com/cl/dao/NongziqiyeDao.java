package com.cl.dao;

import com.cl.entity.NongziqiyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongziqiyeView;


/**
 * 农资企业
 * 
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
public interface NongziqiyeDao extends BaseMapper<NongziqiyeEntity> {
	
	List<NongziqiyeView> selectListView(@Param("ew") Wrapper<NongziqiyeEntity> wrapper);

	List<NongziqiyeView> selectListView(Pagination page,@Param("ew") Wrapper<NongziqiyeEntity> wrapper);
	
	NongziqiyeView selectView(@Param("ew") Wrapper<NongziqiyeEntity> wrapper);
	

}

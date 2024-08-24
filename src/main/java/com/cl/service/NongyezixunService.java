package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongyezixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongyezixunView;


/**
 * 农业资讯
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface NongyezixunService extends IService<NongyezixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongyezixunView> selectListView(Wrapper<NongyezixunEntity> wrapper);
   	
   	NongyezixunView selectView(@Param("ew") Wrapper<NongyezixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongyezixunEntity> wrapper);
   	

}


package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussnongyezixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussnongyezixunView;


/**
 * 农业资讯评论表
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface DiscussnongyezixunService extends IService<DiscussnongyezixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussnongyezixunView> selectListView(Wrapper<DiscussnongyezixunEntity> wrapper);
   	
   	DiscussnongyezixunView selectView(@Param("ew") Wrapper<DiscussnongyezixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussnongyezixunEntity> wrapper);
   	

}


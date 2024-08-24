package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussnongziqiyeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussnongziqiyeView;


/**
 * 农资企业评论表
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface DiscussnongziqiyeService extends IService<DiscussnongziqiyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussnongziqiyeView> selectListView(Wrapper<DiscussnongziqiyeEntity> wrapper);
   	
   	DiscussnongziqiyeView selectView(@Param("ew") Wrapper<DiscussnongziqiyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussnongziqiyeEntity> wrapper);
   	

}


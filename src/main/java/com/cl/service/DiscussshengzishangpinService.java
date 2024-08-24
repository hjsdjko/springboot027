package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshengzishangpinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshengzishangpinView;


/**
 * 生资商品评论表
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface DiscussshengzishangpinService extends IService<DiscussshengzishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshengzishangpinView> selectListView(Wrapper<DiscussshengzishangpinEntity> wrapper);
   	
   	DiscussshengzishangpinView selectView(@Param("ew") Wrapper<DiscussshengzishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshengzishangpinEntity> wrapper);
   	

}


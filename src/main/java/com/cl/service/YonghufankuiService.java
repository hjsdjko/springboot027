package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YonghufankuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YonghufankuiView;


/**
 * 用户反馈
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface YonghufankuiService extends IService<YonghufankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghufankuiView> selectListView(Wrapper<YonghufankuiEntity> wrapper);
   	
   	YonghufankuiView selectView(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghufankuiEntity> wrapper);
   	

}


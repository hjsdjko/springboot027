package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FenleiView;


/**
 * 分类
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface FenleiService extends IService<FenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenleiView> selectListView(Wrapper<FenleiEntity> wrapper);
   	
   	FenleiView selectView(@Param("ew") Wrapper<FenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenleiEntity> wrapper);
   	

}


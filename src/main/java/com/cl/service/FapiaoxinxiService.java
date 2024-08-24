package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FapiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FapiaoxinxiView;


/**
 * 发票信息
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface FapiaoxinxiService extends IService<FapiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FapiaoxinxiView> selectListView(Wrapper<FapiaoxinxiEntity> wrapper);
   	
   	FapiaoxinxiView selectView(@Param("ew") Wrapper<FapiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FapiaoxinxiEntity> wrapper);
   	

}


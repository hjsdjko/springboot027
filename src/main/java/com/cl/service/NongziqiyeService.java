package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongziqiyeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongziqiyeView;


/**
 * 农资企业
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
public interface NongziqiyeService extends IService<NongziqiyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongziqiyeView> selectListView(Wrapper<NongziqiyeEntity> wrapper);
   	
   	NongziqiyeView selectView(@Param("ew") Wrapper<NongziqiyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongziqiyeEntity> wrapper);
   	

}


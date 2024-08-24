package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongminEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongminView;


/**
 * 农民
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
public interface NongminService extends IService<NongminEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongminView> selectListView(Wrapper<NongminEntity> wrapper);
   	
   	NongminView selectView(@Param("ew") Wrapper<NongminEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongminEntity> wrapper);
   	

}


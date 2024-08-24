package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShengzishangpinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShengzishangpinView;


/**
 * 生资商品
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface ShengzishangpinService extends IService<ShengzishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShengzishangpinView> selectListView(Wrapper<ShengzishangpinEntity> wrapper);
   	
   	ShengzishangpinView selectView(@Param("ew") Wrapper<ShengzishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShengzishangpinEntity> wrapper);
   	

}


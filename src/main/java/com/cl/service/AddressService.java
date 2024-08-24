package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.AddressEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AddressView;


/**
 * 地址
 *
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
public interface AddressService extends IService<AddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AddressView> selectListView(Wrapper<AddressEntity> wrapper);
   	
   	AddressView selectView(@Param("ew") Wrapper<AddressEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AddressEntity> wrapper);
   	

}


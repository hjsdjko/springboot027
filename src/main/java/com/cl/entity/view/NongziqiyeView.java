package com.cl.entity.view;

import com.cl.entity.NongziqiyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 农资企业
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
@TableName("nongziqiye")
public class NongziqiyeView  extends NongziqiyeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongziqiyeView(){
	}
 
 	public NongziqiyeView(NongziqiyeEntity nongziqiyeEntity){
 	try {
			BeanUtils.copyProperties(this, nongziqiyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
package com.cl.entity.view;

import com.cl.entity.ShengzishangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 生资商品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@TableName("shengzishangpin")
public class ShengzishangpinView  extends ShengzishangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShengzishangpinView(){
	}
 
 	public ShengzishangpinView(ShengzishangpinEntity shengzishangpinEntity){
 	try {
			BeanUtils.copyProperties(this, shengzishangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

package com.cl.entity.view;

import com.cl.entity.DiscussnongyezixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 农业资讯评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@TableName("discussnongyezixun")
public class DiscussnongyezixunView  extends DiscussnongyezixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussnongyezixunView(){
	}
 
 	public DiscussnongyezixunView(DiscussnongyezixunEntity discussnongyezixunEntity){
 	try {
			BeanUtils.copyProperties(this, discussnongyezixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

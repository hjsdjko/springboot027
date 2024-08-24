package com.cl.entity.view;

import com.cl.entity.DiscussnongziqiyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 农资企业评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@TableName("discussnongziqiye")
public class DiscussnongziqiyeView  extends DiscussnongziqiyeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussnongziqiyeView(){
	}
 
 	public DiscussnongziqiyeView(DiscussnongziqiyeEntity discussnongziqiyeEntity){
 	try {
			BeanUtils.copyProperties(this, discussnongziqiyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

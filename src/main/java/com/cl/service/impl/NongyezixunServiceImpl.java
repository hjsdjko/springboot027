package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.NongyezixunDao;
import com.cl.entity.NongyezixunEntity;
import com.cl.service.NongyezixunService;
import com.cl.entity.view.NongyezixunView;

@Service("nongyezixunService")
public class NongyezixunServiceImpl extends ServiceImpl<NongyezixunDao, NongyezixunEntity> implements NongyezixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongyezixunEntity> page = this.selectPage(
                new Query<NongyezixunEntity>(params).getPage(),
                new EntityWrapper<NongyezixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongyezixunEntity> wrapper) {
		  Page<NongyezixunView> page =new Query<NongyezixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<NongyezixunView> selectListView(Wrapper<NongyezixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongyezixunView selectView(Wrapper<NongyezixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

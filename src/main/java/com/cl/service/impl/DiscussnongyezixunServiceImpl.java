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


import com.cl.dao.DiscussnongyezixunDao;
import com.cl.entity.DiscussnongyezixunEntity;
import com.cl.service.DiscussnongyezixunService;
import com.cl.entity.view.DiscussnongyezixunView;

@Service("discussnongyezixunService")
public class DiscussnongyezixunServiceImpl extends ServiceImpl<DiscussnongyezixunDao, DiscussnongyezixunEntity> implements DiscussnongyezixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussnongyezixunEntity> page = this.selectPage(
                new Query<DiscussnongyezixunEntity>(params).getPage(),
                new EntityWrapper<DiscussnongyezixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussnongyezixunEntity> wrapper) {
		  Page<DiscussnongyezixunView> page =new Query<DiscussnongyezixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussnongyezixunView> selectListView(Wrapper<DiscussnongyezixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussnongyezixunView selectView(Wrapper<DiscussnongyezixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.cl.dao.DiscussshengzishangpinDao;
import com.cl.entity.DiscussshengzishangpinEntity;
import com.cl.service.DiscussshengzishangpinService;
import com.cl.entity.view.DiscussshengzishangpinView;

@Service("discussshengzishangpinService")
public class DiscussshengzishangpinServiceImpl extends ServiceImpl<DiscussshengzishangpinDao, DiscussshengzishangpinEntity> implements DiscussshengzishangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshengzishangpinEntity> page = this.selectPage(
                new Query<DiscussshengzishangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussshengzishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshengzishangpinEntity> wrapper) {
		  Page<DiscussshengzishangpinView> page =new Query<DiscussshengzishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshengzishangpinView> selectListView(Wrapper<DiscussshengzishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshengzishangpinView selectView(Wrapper<DiscussshengzishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

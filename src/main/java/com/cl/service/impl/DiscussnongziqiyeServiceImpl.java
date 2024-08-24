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


import com.cl.dao.DiscussnongziqiyeDao;
import com.cl.entity.DiscussnongziqiyeEntity;
import com.cl.service.DiscussnongziqiyeService;
import com.cl.entity.view.DiscussnongziqiyeView;

@Service("discussnongziqiyeService")
public class DiscussnongziqiyeServiceImpl extends ServiceImpl<DiscussnongziqiyeDao, DiscussnongziqiyeEntity> implements DiscussnongziqiyeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussnongziqiyeEntity> page = this.selectPage(
                new Query<DiscussnongziqiyeEntity>(params).getPage(),
                new EntityWrapper<DiscussnongziqiyeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussnongziqiyeEntity> wrapper) {
		  Page<DiscussnongziqiyeView> page =new Query<DiscussnongziqiyeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussnongziqiyeView> selectListView(Wrapper<DiscussnongziqiyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussnongziqiyeView selectView(Wrapper<DiscussnongziqiyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

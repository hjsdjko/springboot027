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


import com.cl.dao.ShengzishangpinDao;
import com.cl.entity.ShengzishangpinEntity;
import com.cl.service.ShengzishangpinService;
import com.cl.entity.view.ShengzishangpinView;

@Service("shengzishangpinService")
public class ShengzishangpinServiceImpl extends ServiceImpl<ShengzishangpinDao, ShengzishangpinEntity> implements ShengzishangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShengzishangpinEntity> page = this.selectPage(
                new Query<ShengzishangpinEntity>(params).getPage(),
                new EntityWrapper<ShengzishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShengzishangpinEntity> wrapper) {
		  Page<ShengzishangpinView> page =new Query<ShengzishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShengzishangpinView> selectListView(Wrapper<ShengzishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShengzishangpinView selectView(Wrapper<ShengzishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

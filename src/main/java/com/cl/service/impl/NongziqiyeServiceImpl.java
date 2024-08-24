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


import com.cl.dao.NongziqiyeDao;
import com.cl.entity.NongziqiyeEntity;
import com.cl.service.NongziqiyeService;
import com.cl.entity.view.NongziqiyeView;

@Service("nongziqiyeService")
public class NongziqiyeServiceImpl extends ServiceImpl<NongziqiyeDao, NongziqiyeEntity> implements NongziqiyeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongziqiyeEntity> page = this.selectPage(
                new Query<NongziqiyeEntity>(params).getPage(),
                new EntityWrapper<NongziqiyeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongziqiyeEntity> wrapper) {
		  Page<NongziqiyeView> page =new Query<NongziqiyeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<NongziqiyeView> selectListView(Wrapper<NongziqiyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongziqiyeView selectView(Wrapper<NongziqiyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

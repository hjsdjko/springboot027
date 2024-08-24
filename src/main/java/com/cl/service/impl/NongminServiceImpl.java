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


import com.cl.dao.NongminDao;
import com.cl.entity.NongminEntity;
import com.cl.service.NongminService;
import com.cl.entity.view.NongminView;

@Service("nongminService")
public class NongminServiceImpl extends ServiceImpl<NongminDao, NongminEntity> implements NongminService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongminEntity> page = this.selectPage(
                new Query<NongminEntity>(params).getPage(),
                new EntityWrapper<NongminEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongminEntity> wrapper) {
		  Page<NongminView> page =new Query<NongminView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<NongminView> selectListView(Wrapper<NongminEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongminView selectView(Wrapper<NongminEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.NongyezixunEntity;
import com.cl.entity.view.NongyezixunView;

import com.cl.service.NongyezixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 农业资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@RestController
@RequestMapping("/nongyezixun")
public class NongyezixunController {
    @Autowired
    private NongyezixunService nongyezixunService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongyezixunEntity nongyezixun,
		HttpServletRequest request){
        EntityWrapper<NongyezixunEntity> ew = new EntityWrapper<NongyezixunEntity>();

		PageUtils page = nongyezixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongyezixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongyezixunEntity nongyezixun, 
		HttpServletRequest request){
        EntityWrapper<NongyezixunEntity> ew = new EntityWrapper<NongyezixunEntity>();

		PageUtils page = nongyezixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongyezixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongyezixunEntity nongyezixun){
       	EntityWrapper<NongyezixunEntity> ew = new EntityWrapper<NongyezixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongyezixun, "nongyezixun")); 
        return R.ok().put("data", nongyezixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongyezixunEntity nongyezixun){
        EntityWrapper< NongyezixunEntity> ew = new EntityWrapper< NongyezixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongyezixun, "nongyezixun")); 
		NongyezixunView nongyezixunView =  nongyezixunService.selectView(ew);
		return R.ok("查询农业资讯成功").put("data", nongyezixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongyezixunEntity nongyezixun = nongyezixunService.selectById(id);
		nongyezixun = nongyezixunService.selectView(new EntityWrapper<NongyezixunEntity>().eq("id", id));
        return R.ok().put("data", nongyezixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongyezixunEntity nongyezixun = nongyezixunService.selectById(id);
		nongyezixun = nongyezixunService.selectView(new EntityWrapper<NongyezixunEntity>().eq("id", id));
        return R.ok().put("data", nongyezixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongyezixunEntity nongyezixun, HttpServletRequest request){
    	nongyezixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongyezixun);
        nongyezixunService.insert(nongyezixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongyezixunEntity nongyezixun, HttpServletRequest request){
    	nongyezixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongyezixun);
        nongyezixunService.insert(nongyezixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongyezixunEntity nongyezixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongyezixun);
        nongyezixunService.updateById(nongyezixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongyezixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

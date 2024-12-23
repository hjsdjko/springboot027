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

import com.cl.entity.FenleiEntity;
import com.cl.entity.view.FenleiView;

import com.cl.service.FenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@RestController
@RequestMapping("/fenlei")
public class FenleiController {
    @Autowired
    private FenleiService fenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FenleiEntity fenlei,
		HttpServletRequest request){
        EntityWrapper<FenleiEntity> ew = new EntityWrapper<FenleiEntity>();

		PageUtils page = fenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FenleiEntity fenlei, 
		HttpServletRequest request){
        EntityWrapper<FenleiEntity> ew = new EntityWrapper<FenleiEntity>();

		PageUtils page = fenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FenleiEntity fenlei){
       	EntityWrapper<FenleiEntity> ew = new EntityWrapper<FenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fenlei, "fenlei")); 
        return R.ok().put("data", fenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FenleiEntity fenlei){
        EntityWrapper< FenleiEntity> ew = new EntityWrapper< FenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fenlei, "fenlei")); 
		FenleiView fenleiView =  fenleiService.selectView(ew);
		return R.ok("查询分类成功").put("data", fenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FenleiEntity fenlei = fenleiService.selectById(id);
		fenlei = fenleiService.selectView(new EntityWrapper<FenleiEntity>().eq("id", id));
        return R.ok().put("data", fenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FenleiEntity fenlei = fenleiService.selectById(id);
		fenlei = fenleiService.selectView(new EntityWrapper<FenleiEntity>().eq("id", id));
        return R.ok().put("data", fenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FenleiEntity fenlei, HttpServletRequest request){
    	fenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fenlei);
        fenleiService.insert(fenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FenleiEntity fenlei, HttpServletRequest request){
    	fenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fenlei);
        fenleiService.insert(fenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FenleiEntity fenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fenlei);
        fenleiService.updateById(fenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

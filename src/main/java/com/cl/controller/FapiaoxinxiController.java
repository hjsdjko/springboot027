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

import com.cl.entity.FapiaoxinxiEntity;
import com.cl.entity.view.FapiaoxinxiView;

import com.cl.service.FapiaoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 发票信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@RestController
@RequestMapping("/fapiaoxinxi")
public class FapiaoxinxiController {
    @Autowired
    private FapiaoxinxiService fapiaoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FapiaoxinxiEntity fapiaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nongmin")) {
			fapiaoxinxi.setNongminzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nongziqiye")) {
			fapiaoxinxi.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FapiaoxinxiEntity> ew = new EntityWrapper<FapiaoxinxiEntity>();

		PageUtils page = fapiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fapiaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FapiaoxinxiEntity fapiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<FapiaoxinxiEntity> ew = new EntityWrapper<FapiaoxinxiEntity>();

		PageUtils page = fapiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fapiaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FapiaoxinxiEntity fapiaoxinxi){
       	EntityWrapper<FapiaoxinxiEntity> ew = new EntityWrapper<FapiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fapiaoxinxi, "fapiaoxinxi")); 
        return R.ok().put("data", fapiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FapiaoxinxiEntity fapiaoxinxi){
        EntityWrapper< FapiaoxinxiEntity> ew = new EntityWrapper< FapiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fapiaoxinxi, "fapiaoxinxi")); 
		FapiaoxinxiView fapiaoxinxiView =  fapiaoxinxiService.selectView(ew);
		return R.ok("查询发票信息成功").put("data", fapiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FapiaoxinxiEntity fapiaoxinxi = fapiaoxinxiService.selectById(id);
		fapiaoxinxi = fapiaoxinxiService.selectView(new EntityWrapper<FapiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", fapiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FapiaoxinxiEntity fapiaoxinxi = fapiaoxinxiService.selectById(id);
		fapiaoxinxi = fapiaoxinxiService.selectView(new EntityWrapper<FapiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", fapiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FapiaoxinxiEntity fapiaoxinxi, HttpServletRequest request){
    	fapiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fapiaoxinxi);
        fapiaoxinxiService.insert(fapiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FapiaoxinxiEntity fapiaoxinxi, HttpServletRequest request){
    	fapiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fapiaoxinxi);
        fapiaoxinxiService.insert(fapiaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FapiaoxinxiEntity fapiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fapiaoxinxi);
        fapiaoxinxiService.updateById(fapiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fapiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

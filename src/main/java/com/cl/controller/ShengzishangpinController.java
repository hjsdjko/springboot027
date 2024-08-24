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

import com.cl.entity.ShengzishangpinEntity;
import com.cl.entity.view.ShengzishangpinView;

import com.cl.service.ShengzishangpinService;
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
 * 生资商品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@RestController
@RequestMapping("/shengzishangpin")
public class ShengzishangpinController {
    @Autowired
    private ShengzishangpinService shengzishangpinService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShengzishangpinEntity shengzishangpin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nongziqiye")) {
			shengzishangpin.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShengzishangpinEntity> ew = new EntityWrapper<ShengzishangpinEntity>();

		PageUtils page = shengzishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shengzishangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShengzishangpinEntity shengzishangpin, 
		HttpServletRequest request){
        EntityWrapper<ShengzishangpinEntity> ew = new EntityWrapper<ShengzishangpinEntity>();

		PageUtils page = shengzishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shengzishangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShengzishangpinEntity shengzishangpin){
       	EntityWrapper<ShengzishangpinEntity> ew = new EntityWrapper<ShengzishangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shengzishangpin, "shengzishangpin")); 
        return R.ok().put("data", shengzishangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShengzishangpinEntity shengzishangpin){
        EntityWrapper< ShengzishangpinEntity> ew = new EntityWrapper< ShengzishangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shengzishangpin, "shengzishangpin")); 
		ShengzishangpinView shengzishangpinView =  shengzishangpinService.selectView(ew);
		return R.ok("查询生资商品成功").put("data", shengzishangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShengzishangpinEntity shengzishangpin = shengzishangpinService.selectById(id);
		shengzishangpin = shengzishangpinService.selectView(new EntityWrapper<ShengzishangpinEntity>().eq("id", id));
        return R.ok().put("data", shengzishangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShengzishangpinEntity shengzishangpin = shengzishangpinService.selectById(id);
		shengzishangpin = shengzishangpinService.selectView(new EntityWrapper<ShengzishangpinEntity>().eq("id", id));
        return R.ok().put("data", shengzishangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShengzishangpinEntity shengzishangpin, HttpServletRequest request){
    	shengzishangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shengzishangpin);
        shengzishangpinService.insert(shengzishangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShengzishangpinEntity shengzishangpin, HttpServletRequest request){
    	shengzishangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shengzishangpin);
        shengzishangpinService.insert(shengzishangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShengzishangpinEntity shengzishangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shengzishangpin);
        shengzishangpinService.updateById(shengzishangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shengzishangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

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

import com.cl.entity.NongminEntity;
import com.cl.entity.view.NongminView;

import com.cl.service.NongminService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 农民
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
@RestController
@RequestMapping("/nongmin")
public class NongminController {
    @Autowired
    private NongminService nongminService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		NongminEntity u = nongminService.selectOne(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", username));
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"nongmin",  "农民" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody NongminEntity nongmin){
    	//ValidatorUtils.validateEntity(nongmin);
    	NongminEntity u = nongminService.selectOne(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", nongmin.getNongminzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		nongmin.setId(uId);
        nongmin.setMima(EncryptUtil.md5(nongmin.getMima()));
        nongminService.insert(nongmin);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        NongminEntity u = nongminService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	NongminEntity u = nongminService.selectOne(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima(EncryptUtil.md5("123456"));
        nongminService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongminEntity nongmin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nongmin")) {
			nongmin.setNongminzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NongminEntity> ew = new EntityWrapper<NongminEntity>();

		PageUtils page = nongminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongmin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongminEntity nongmin, 
		HttpServletRequest request){
        EntityWrapper<NongminEntity> ew = new EntityWrapper<NongminEntity>();

		PageUtils page = nongminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongmin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongminEntity nongmin){
       	EntityWrapper<NongminEntity> ew = new EntityWrapper<NongminEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongmin, "nongmin")); 
        return R.ok().put("data", nongminService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongminEntity nongmin){
        EntityWrapper< NongminEntity> ew = new EntityWrapper< NongminEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongmin, "nongmin")); 
		NongminView nongminView =  nongminService.selectView(ew);
		return R.ok("查询农民成功").put("data", nongminView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongminEntity nongmin = nongminService.selectById(id);
		nongmin = nongminService.selectView(new EntityWrapper<NongminEntity>().eq("id", id));
        return R.ok().put("data", nongmin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongminEntity nongmin = nongminService.selectById(id);
		nongmin = nongminService.selectView(new EntityWrapper<NongminEntity>().eq("id", id));
        return R.ok().put("data", nongmin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongminEntity nongmin, HttpServletRequest request){
        if(nongminService.selectCount(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", nongmin.getNongminzhanghao()))>0) {
            return R.error("农民账号已存在");
        }
    	nongmin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongmin);
    	NongminEntity u = nongminService.selectOne(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", nongmin.getNongminzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		nongmin.setId(new Date().getTime());
        nongmin.setMima(EncryptUtil.md5(nongmin.getMima()));
        nongminService.insert(nongmin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongminEntity nongmin, HttpServletRequest request){
        if(nongminService.selectCount(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", nongmin.getNongminzhanghao()))>0) {
            return R.error("农民账号已存在");
        }
    	nongmin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongmin);
    	NongminEntity u = nongminService.selectOne(new EntityWrapper<NongminEntity>().eq("nongminzhanghao", nongmin.getNongminzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		nongmin.setId(new Date().getTime());
        nongmin.setMima(EncryptUtil.md5(nongmin.getMima()));
        nongminService.insert(nongmin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongminEntity nongmin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongmin);
        NongminEntity nongminEntity = nongminService.selectById(nongmin.getId());
        if(StringUtils.isNotBlank(nongmin.getMima()) && !nongmin.getMima().equals(nongminEntity.getMima())) {
            nongmin.setMima(EncryptUtil.md5(nongmin.getMima()));
        }
        nongminService.updateById(nongmin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongminService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

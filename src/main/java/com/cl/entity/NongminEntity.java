package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 农民
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-26 22:38:06
 */
@TableName("nongmin")
public class NongminEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NongminEntity() {
		
	}
	
	public NongminEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 农民账号
	 */
					
	private String nongminzhanghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 农民姓名
	 */
					
	private String nongminxingming;
	
	/**
	 * 家庭住址
	 */
					
	private String jiatingzhuzhi;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 地块名称
	 */
					
	private String dikuaimingcheng;
	
	/**
	 * 地块类型
	 */
					
	private String dikuaileixing;
	
	/**
	 * 土地面积
	 */
					
	private String tudimianji;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 余额
	 */
					
	private Double money;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：农民账号
	 */
	public void setNongminzhanghao(String nongminzhanghao) {
		this.nongminzhanghao = nongminzhanghao;
	}
	/**
	 * 获取：农民账号
	 */
	public String getNongminzhanghao() {
		return nongminzhanghao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：农民姓名
	 */
	public void setNongminxingming(String nongminxingming) {
		this.nongminxingming = nongminxingming;
	}
	/**
	 * 获取：农民姓名
	 */
	public String getNongminxingming() {
		return nongminxingming;
	}
	/**
	 * 设置：家庭住址
	 */
	public void setJiatingzhuzhi(String jiatingzhuzhi) {
		this.jiatingzhuzhi = jiatingzhuzhi;
	}
	/**
	 * 获取：家庭住址
	 */
	public String getJiatingzhuzhi() {
		return jiatingzhuzhi;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：地块名称
	 */
	public void setDikuaimingcheng(String dikuaimingcheng) {
		this.dikuaimingcheng = dikuaimingcheng;
	}
	/**
	 * 获取：地块名称
	 */
	public String getDikuaimingcheng() {
		return dikuaimingcheng;
	}
	/**
	 * 设置：地块类型
	 */
	public void setDikuaileixing(String dikuaileixing) {
		this.dikuaileixing = dikuaileixing;
	}
	/**
	 * 获取：地块类型
	 */
	public String getDikuaileixing() {
		return dikuaileixing;
	}
	/**
	 * 设置：土地面积
	 */
	public void setTudimianji(String tudimianji) {
		this.tudimianji = tudimianji;
	}
	/**
	 * 获取：土地面积
	 */
	public String getTudimianji() {
		return tudimianji;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：余额
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：余额
	 */
	public Double getMoney() {
		return money;
	}

}

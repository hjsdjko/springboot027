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
 * 发票信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-26 22:38:07
 */
@TableName("fapiaoxinxi")
public class FapiaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FapiaoxinxiEntity() {
		
	}
	
	public FapiaoxinxiEntity(T t) {
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
	 * 发票号码
	 */
					
	private String fapiaohaoma;
	
	/**
	 * 开票日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaipiaoriqi;
	
	/**
	 * 购买账号
	 */
					
	private String nongminzhanghao;
	
	/**
	 * 开票名称
	 */
					
	private String nongminxingming;
	
	/**
	 * 商品名称
	 */
					
	private String shangpinmingcheng;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 含税单价
	 */
					
	private Double hanshuidanjia;
	
	/**
	 * 税率
	 */
					
	private String shuilv;
	
	/**
	 * 开票金额
	 */
					
	private Double kaipiaojine;
	
	/**
	 * 企业账号
	 */
					
	private String qiyezhanghao;
	
	/**
	 * 开票企业名称
	 */
					
	private String kaipiaoqiyemingcheng;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	
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
	 * 设置：发票号码
	 */
	public void setFapiaohaoma(String fapiaohaoma) {
		this.fapiaohaoma = fapiaohaoma;
	}
	/**
	 * 获取：发票号码
	 */
	public String getFapiaohaoma() {
		return fapiaohaoma;
	}
	/**
	 * 设置：开票日期
	 */
	public void setKaipiaoriqi(Date kaipiaoriqi) {
		this.kaipiaoriqi = kaipiaoriqi;
	}
	/**
	 * 获取：开票日期
	 */
	public Date getKaipiaoriqi() {
		return kaipiaoriqi;
	}
	/**
	 * 设置：购买账号
	 */
	public void setNongminzhanghao(String nongminzhanghao) {
		this.nongminzhanghao = nongminzhanghao;
	}
	/**
	 * 获取：购买账号
	 */
	public String getNongminzhanghao() {
		return nongminzhanghao;
	}
	/**
	 * 设置：开票名称
	 */
	public void setNongminxingming(String nongminxingming) {
		this.nongminxingming = nongminxingming;
	}
	/**
	 * 获取：开票名称
	 */
	public String getNongminxingming() {
		return nongminxingming;
	}
	/**
	 * 设置：商品名称
	 */
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：含税单价
	 */
	public void setHanshuidanjia(Double hanshuidanjia) {
		this.hanshuidanjia = hanshuidanjia;
	}
	/**
	 * 获取：含税单价
	 */
	public Double getHanshuidanjia() {
		return hanshuidanjia;
	}
	/**
	 * 设置：税率
	 */
	public void setShuilv(String shuilv) {
		this.shuilv = shuilv;
	}
	/**
	 * 获取：税率
	 */
	public String getShuilv() {
		return shuilv;
	}
	/**
	 * 设置：开票金额
	 */
	public void setKaipiaojine(Double kaipiaojine) {
		this.kaipiaojine = kaipiaojine;
	}
	/**
	 * 获取：开票金额
	 */
	public Double getKaipiaojine() {
		return kaipiaojine;
	}
	/**
	 * 设置：企业账号
	 */
	public void setQiyezhanghao(String qiyezhanghao) {
		this.qiyezhanghao = qiyezhanghao;
	}
	/**
	 * 获取：企业账号
	 */
	public String getQiyezhanghao() {
		return qiyezhanghao;
	}
	/**
	 * 设置：开票企业名称
	 */
	public void setKaipiaoqiyemingcheng(String kaipiaoqiyemingcheng) {
		this.kaipiaoqiyemingcheng = kaipiaoqiyemingcheng;
	}
	/**
	 * 获取：开票企业名称
	 */
	public String getKaipiaoqiyemingcheng() {
		return kaipiaoqiyemingcheng;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}

}

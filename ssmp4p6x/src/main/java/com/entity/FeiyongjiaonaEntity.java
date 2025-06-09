package com.entity;

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
 * 费用缴纳
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
@TableName("feiyongjiaona")
public class FeiyongjiaonaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FeiyongjiaonaEntity() {
		
	}
	
	public FeiyongjiaonaEntity(T t) {
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
	 * 业主账号
	 */
					
	private String yezhuzhanghao;
	
	/**
	 * 业主姓名
	 */
					
	private String yezhuxingming;
	
	/**
	 * 水费
	 */
					
	private Integer shuifei;
	
	/**
	 * 电费
	 */
					
	private Integer dianfei;
	
	/**
	 * 卫生费
	 */
					
	private Integer weishengfei;
	
	/**
	 * 其他
	 */
					
	private Integer qita;
	
	/**
	 * 总金额
	 */
					
	private Integer zongjine;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：业主账号
	 */
	public void setYezhuzhanghao(String yezhuzhanghao) {
		this.yezhuzhanghao = yezhuzhanghao;
	}
	/**
	 * 获取：业主账号
	 */
	public String getYezhuzhanghao() {
		return yezhuzhanghao;
	}
	/**
	 * 设置：业主姓名
	 */
	public void setYezhuxingming(String yezhuxingming) {
		this.yezhuxingming = yezhuxingming;
	}
	/**
	 * 获取：业主姓名
	 */
	public String getYezhuxingming() {
		return yezhuxingming;
	}
	/**
	 * 设置：水费
	 */
	public void setShuifei(Integer shuifei) {
		this.shuifei = shuifei;
	}
	/**
	 * 获取：水费
	 */
	public Integer getShuifei() {
		return shuifei;
	}
	/**
	 * 设置：电费
	 */
	public void setDianfei(Integer dianfei) {
		this.dianfei = dianfei;
	}
	/**
	 * 获取：电费
	 */
	public Integer getDianfei() {
		return dianfei;
	}
	/**
	 * 设置：卫生费
	 */
	public void setWeishengfei(Integer weishengfei) {
		this.weishengfei = weishengfei;
	}
	/**
	 * 获取：卫生费
	 */
	public Integer getWeishengfei() {
		return weishengfei;
	}
	/**
	 * 设置：其他
	 */
	public void setQita(Integer qita) {
		this.qita = qita;
	}
	/**
	 * 获取：其他
	 */
	public Integer getQita() {
		return qita;
	}
	/**
	 * 设置：总金额
	 */
	public void setZongjine(Integer zongjine) {
		this.zongjine = zongjine;
	}
	/**
	 * 获取：总金额
	 */
	public Integer getZongjine() {
		return zongjine;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}

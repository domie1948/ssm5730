package com.entity.model;

import com.entity.FeiyongjiaonaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 费用缴纳
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public class FeiyongjiaonaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

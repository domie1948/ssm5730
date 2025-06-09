package com.entity.view;

import com.entity.HesuanjiancebaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 核酸检测报告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
@TableName("hesuanjiancebaogao")
public class HesuanjiancebaogaoView  extends HesuanjiancebaogaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HesuanjiancebaogaoView(){
	}
 
 	public HesuanjiancebaogaoView(HesuanjiancebaogaoEntity hesuanjiancebaogaoEntity){
 	try {
			BeanUtils.copyProperties(this, hesuanjiancebaogaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

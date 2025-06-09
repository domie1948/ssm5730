package com.entity.view;

import com.entity.YiqingshujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 疫情数据
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
@TableName("yiqingshuju")
public class YiqingshujuView  extends YiqingshujuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiqingshujuView(){
	}
 
 	public YiqingshujuView(YiqingshujuEntity yiqingshujuEntity){
 	try {
			BeanUtils.copyProperties(this, yiqingshujuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

package com.entity.view;

import com.entity.ChepaihaogenghuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 车牌号更换
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
@TableName("chepaihaogenghuan")
public class ChepaihaogenghuanView  extends ChepaihaogenghuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChepaihaogenghuanView(){
	}
 
 	public ChepaihaogenghuanView(ChepaihaogenghuanEntity chepaihaogenghuanEntity){
 	try {
			BeanUtils.copyProperties(this, chepaihaogenghuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

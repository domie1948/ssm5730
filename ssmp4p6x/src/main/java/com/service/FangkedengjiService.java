package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangkedengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangkedengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangkedengjiView;


/**
 * 访客登记
 *
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface FangkedengjiService extends IService<FangkedengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangkedengjiVO> selectListVO(Wrapper<FangkedengjiEntity> wrapper);
   	
   	FangkedengjiVO selectVO(@Param("ew") Wrapper<FangkedengjiEntity> wrapper);
   	
   	List<FangkedengjiView> selectListView(Wrapper<FangkedengjiEntity> wrapper);
   	
   	FangkedengjiView selectView(@Param("ew") Wrapper<FangkedengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangkedengjiEntity> wrapper);
   	
}


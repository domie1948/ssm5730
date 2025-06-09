package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiqingshangbaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiqingshangbaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiqingshangbaoView;


/**
 * 疫情上报
 *
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface YiqingshangbaoService extends IService<YiqingshangbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiqingshangbaoVO> selectListVO(Wrapper<YiqingshangbaoEntity> wrapper);
   	
   	YiqingshangbaoVO selectVO(@Param("ew") Wrapper<YiqingshangbaoEntity> wrapper);
   	
   	List<YiqingshangbaoView> selectListView(Wrapper<YiqingshangbaoEntity> wrapper);
   	
   	YiqingshangbaoView selectView(@Param("ew") Wrapper<YiqingshangbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiqingshangbaoEntity> wrapper);
   	
}


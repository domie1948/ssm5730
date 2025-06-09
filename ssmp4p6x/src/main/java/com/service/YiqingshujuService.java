package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiqingshujuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiqingshujuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiqingshujuView;


/**
 * 疫情数据
 *
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface YiqingshujuService extends IService<YiqingshujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiqingshujuVO> selectListVO(Wrapper<YiqingshujuEntity> wrapper);
   	
   	YiqingshujuVO selectVO(@Param("ew") Wrapper<YiqingshujuEntity> wrapper);
   	
   	List<YiqingshujuView> selectListView(Wrapper<YiqingshujuEntity> wrapper);
   	
   	YiqingshujuView selectView(@Param("ew") Wrapper<YiqingshujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiqingshujuEntity> wrapper);
   	
}


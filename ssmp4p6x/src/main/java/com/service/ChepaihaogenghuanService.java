package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChepaihaogenghuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChepaihaogenghuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChepaihaogenghuanView;


/**
 * 车牌号更换
 *
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface ChepaihaogenghuanService extends IService<ChepaihaogenghuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChepaihaogenghuanVO> selectListVO(Wrapper<ChepaihaogenghuanEntity> wrapper);
   	
   	ChepaihaogenghuanVO selectVO(@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);
   	
   	List<ChepaihaogenghuanView> selectListView(Wrapper<ChepaihaogenghuanEntity> wrapper);
   	
   	ChepaihaogenghuanView selectView(@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChepaihaogenghuanEntity> wrapper);
   	
}


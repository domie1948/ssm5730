package com.dao;

import com.entity.ChepaihaogenghuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChepaihaogenghuanVO;
import com.entity.view.ChepaihaogenghuanView;


/**
 * 车牌号更换
 * 
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface ChepaihaogenghuanDao extends BaseMapper<ChepaihaogenghuanEntity> {
	
	List<ChepaihaogenghuanVO> selectListVO(@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);
	
	ChepaihaogenghuanVO selectVO(@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);
	
	List<ChepaihaogenghuanView> selectListView(@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);

	List<ChepaihaogenghuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);
	
	ChepaihaogenghuanView selectView(@Param("ew") Wrapper<ChepaihaogenghuanEntity> wrapper);
	
}

package com.dao;

import com.entity.YiqingshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiqingshujuVO;
import com.entity.view.YiqingshujuView;


/**
 * 疫情数据
 * 
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface YiqingshujuDao extends BaseMapper<YiqingshujuEntity> {
	
	List<YiqingshujuVO> selectListVO(@Param("ew") Wrapper<YiqingshujuEntity> wrapper);
	
	YiqingshujuVO selectVO(@Param("ew") Wrapper<YiqingshujuEntity> wrapper);
	
	List<YiqingshujuView> selectListView(@Param("ew") Wrapper<YiqingshujuEntity> wrapper);

	List<YiqingshujuView> selectListView(Pagination page,@Param("ew") Wrapper<YiqingshujuEntity> wrapper);
	
	YiqingshujuView selectView(@Param("ew") Wrapper<YiqingshujuEntity> wrapper);
	
}

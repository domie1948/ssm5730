package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChepaihaogenghuanDao;
import com.entity.ChepaihaogenghuanEntity;
import com.service.ChepaihaogenghuanService;
import com.entity.vo.ChepaihaogenghuanVO;
import com.entity.view.ChepaihaogenghuanView;

@Service("chepaihaogenghuanService")
public class ChepaihaogenghuanServiceImpl extends ServiceImpl<ChepaihaogenghuanDao, ChepaihaogenghuanEntity> implements ChepaihaogenghuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChepaihaogenghuanEntity> page = this.selectPage(
                new Query<ChepaihaogenghuanEntity>(params).getPage(),
                new EntityWrapper<ChepaihaogenghuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChepaihaogenghuanEntity> wrapper) {
		  Page<ChepaihaogenghuanView> page =new Query<ChepaihaogenghuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChepaihaogenghuanVO> selectListVO(Wrapper<ChepaihaogenghuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChepaihaogenghuanVO selectVO(Wrapper<ChepaihaogenghuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChepaihaogenghuanView> selectListView(Wrapper<ChepaihaogenghuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChepaihaogenghuanView selectView(Wrapper<ChepaihaogenghuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

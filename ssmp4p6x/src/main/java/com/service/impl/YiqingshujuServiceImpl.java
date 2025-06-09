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


import com.dao.YiqingshujuDao;
import com.entity.YiqingshujuEntity;
import com.service.YiqingshujuService;
import com.entity.vo.YiqingshujuVO;
import com.entity.view.YiqingshujuView;

@Service("yiqingshujuService")
public class YiqingshujuServiceImpl extends ServiceImpl<YiqingshujuDao, YiqingshujuEntity> implements YiqingshujuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiqingshujuEntity> page = this.selectPage(
                new Query<YiqingshujuEntity>(params).getPage(),
                new EntityWrapper<YiqingshujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiqingshujuEntity> wrapper) {
		  Page<YiqingshujuView> page =new Query<YiqingshujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiqingshujuVO> selectListVO(Wrapper<YiqingshujuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiqingshujuVO selectVO(Wrapper<YiqingshujuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiqingshujuView> selectListView(Wrapper<YiqingshujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiqingshujuView selectView(Wrapper<YiqingshujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

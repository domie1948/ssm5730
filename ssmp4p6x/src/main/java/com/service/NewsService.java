package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NewsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NewsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NewsView;


/**
 * 物业公告
 *
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NewsVO> selectListVO(Wrapper<NewsEntity> wrapper);
   	
   	NewsVO selectVO(@Param("ew") Wrapper<NewsEntity> wrapper);
   	
   	List<NewsView> selectListView(Wrapper<NewsEntity> wrapper);
   	
   	NewsView selectView(@Param("ew") Wrapper<NewsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NewsEntity> wrapper);
   	
}


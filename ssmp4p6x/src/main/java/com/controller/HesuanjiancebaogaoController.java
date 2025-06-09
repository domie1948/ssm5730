package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HesuanjiancebaogaoEntity;
import com.entity.view.HesuanjiancebaogaoView;

import com.service.HesuanjiancebaogaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 核酸检测报告
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
@RestController
@RequestMapping("/hesuanjiancebaogao")
public class HesuanjiancebaogaoController {
    @Autowired
    private HesuanjiancebaogaoService hesuanjiancebaogaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HesuanjiancebaogaoEntity hesuanjiancebaogao, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			hesuanjiancebaogao.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HesuanjiancebaogaoEntity> ew = new EntityWrapper<HesuanjiancebaogaoEntity>();
		PageUtils page = hesuanjiancebaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hesuanjiancebaogao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HesuanjiancebaogaoEntity hesuanjiancebaogao, HttpServletRequest request){
        EntityWrapper<HesuanjiancebaogaoEntity> ew = new EntityWrapper<HesuanjiancebaogaoEntity>();
		PageUtils page = hesuanjiancebaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hesuanjiancebaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HesuanjiancebaogaoEntity hesuanjiancebaogao){
       	EntityWrapper<HesuanjiancebaogaoEntity> ew = new EntityWrapper<HesuanjiancebaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hesuanjiancebaogao, "hesuanjiancebaogao")); 
        return R.ok().put("data", hesuanjiancebaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HesuanjiancebaogaoEntity hesuanjiancebaogao){
        EntityWrapper< HesuanjiancebaogaoEntity> ew = new EntityWrapper< HesuanjiancebaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hesuanjiancebaogao, "hesuanjiancebaogao")); 
		HesuanjiancebaogaoView hesuanjiancebaogaoView =  hesuanjiancebaogaoService.selectView(ew);
		return R.ok("查询核酸检测报告成功").put("data", hesuanjiancebaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HesuanjiancebaogaoEntity hesuanjiancebaogao = hesuanjiancebaogaoService.selectById(id);
        return R.ok().put("data", hesuanjiancebaogao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HesuanjiancebaogaoEntity hesuanjiancebaogao = hesuanjiancebaogaoService.selectById(id);
        return R.ok().put("data", hesuanjiancebaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HesuanjiancebaogaoEntity hesuanjiancebaogao, HttpServletRequest request){
    	hesuanjiancebaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hesuanjiancebaogao);

        hesuanjiancebaogaoService.insert(hesuanjiancebaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HesuanjiancebaogaoEntity hesuanjiancebaogao, HttpServletRequest request){
    	hesuanjiancebaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hesuanjiancebaogao);

        hesuanjiancebaogaoService.insert(hesuanjiancebaogao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HesuanjiancebaogaoEntity hesuanjiancebaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(hesuanjiancebaogao);
        hesuanjiancebaogaoService.updateById(hesuanjiancebaogao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hesuanjiancebaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<HesuanjiancebaogaoEntity> wrapper = new EntityWrapper<HesuanjiancebaogaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			wrapper.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = hesuanjiancebaogaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

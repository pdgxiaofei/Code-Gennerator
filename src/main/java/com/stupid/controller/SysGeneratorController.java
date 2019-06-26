package com.stupid.controller;

import com.stupid.annotations.WebLog;
import com.stupid.service.ApplicationServise;
import com.stupid.service.SysGeneratorService;
import com.stupid.utils.PageUtils;
import com.stupid.utils.Query;
import com.stupid.utils.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * @author StupidDog
 * @date 2018-11-13 16:06:01
 */
@RestController
@RequestMapping("/sys/generator")
public class SysGeneratorController {
	@Autowired
	private SysGeneratorService sysGeneratorService;
	@Autowired
	private ApplicationServise applicationServise;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@WebLog(description = "查找list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<Map<String, Object>> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(String tables, HttpServletResponse response) throws IOException{
		byte[] data = sysGeneratorService.generatorCode(tables.split(","));

		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"stupid.zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");

		IOUtils.write(data, response.getOutputStream());
	}

	@RequestMapping("/findAllApplication")
	@WebLog(description = "查找全部application")
	public R findApplication(){
		return  applicationServise.findAll();
	}


}

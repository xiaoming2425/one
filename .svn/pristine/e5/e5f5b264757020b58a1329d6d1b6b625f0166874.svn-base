package cn.wewintech.common.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.RemoveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wewintech.common.domain.LogDO;
import cn.wewintech.common.domain.PageDO;
import cn.wewintech.common.service.LogService;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;

@RequestMapping("/common/log")
@Controller
public class LogController {
	@Autowired
	LogService logService;
	String prefix = "common/log";

	@GetMapping()
	String log() {
		return prefix + "/log";
	}

	@ResponseBody
	@GetMapping("/list")
	PageDO<LogDO> list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		PageDO<LogDO> page = logService.queryList(query);
		return page;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	ResultObject remove(Long id) {
		if (logService.remove(id)>0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	ResultObject batchRemove(@RequestParam("ids[]") Long[] ids) {
		int r = logService.batchRemove(ids);
		if (r > 0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
}

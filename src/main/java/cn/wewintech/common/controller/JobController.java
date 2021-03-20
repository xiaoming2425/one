package cn.wewintech.common.controller;

import cn.wewintech.common.config.Constant;
import cn.wewintech.common.domain.TaskDO;
import cn.wewintech.common.service.JobService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-26 20:53:48
 */
@Controller
@RequestMapping("/common/job")
public class JobController extends BaseController{
	@Autowired
	private JobService taskScheduleJobService;

	@GetMapping()
	String taskScheduleJob() {
		return "common/job/job";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<TaskDO> taskScheduleJobList = taskScheduleJobService.list(query);
		int total = taskScheduleJobService.count(query);
		PageUtils pageUtils = new PageUtils(taskScheduleJobList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add() {
		return "common/job/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		TaskDO job = taskScheduleJobService.get(id);
		model.addAttribute("job", job);
		return "common/job/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public ResultObject info(@PathVariable("id") Long id) {
		TaskDO taskScheduleJob = taskScheduleJobService.get(id);
		return ResultObject.ok().put("taskScheduleJob", taskScheduleJob);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public ResultObject save(TaskDO taskScheduleJob) {
		if (taskScheduleJobService.save(taskScheduleJob) > 0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	public ResultObject update(TaskDO taskScheduleJob) {
		taskScheduleJobService.update(taskScheduleJob);
		return ResultObject.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public ResultObject remove(Long id) {
		if (taskScheduleJobService.remove(id) > 0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	public ResultObject remove(@RequestParam("ids[]") Long[] ids) {
		taskScheduleJobService.batchRemove(ids);

		return ResultObject.ok();
	}

	@PostMapping(value = "/changeJobStatus")
	@ResponseBody
	public ResultObject changeJobStatus(Long id,String cmd ) {
		String label = "停止";
		if ("start".equals(cmd)) {
			label = "启动";
		} else {
			label = "停止";
		}
		try {
			taskScheduleJobService.changeStatus(id, cmd);
			return ResultObject.ok("任务" + label + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultObject.ok("任务" + label + "失败");
	}

}

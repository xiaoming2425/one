package cn.wewintech.common.controller;

import cn.wewintech.common.config.BootdoConfig;
import cn.wewintech.common.domain.FileDO;
import cn.wewintech.common.service.FileService;
import cn.wewintech.common.utils.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
@Controller
@RequestMapping("/common/sysFile")
public class FileController extends BaseController {

	@Autowired
	private FileService sysFileService;

	@Autowired
	private BootdoConfig bootdoConfig;

	@GetMapping()
	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		model.addAttribute("showPath", bootdoConfig.getShowPath());
		return "common/file/file";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<FileDO> sysFileList = sysFileService.list(query);
		int total = sysFileService.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("common:bComments")
	String add() {
		return "common/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("common:bComments")
	String edit(String id, Model model) {
		FileDO sysFile = sysFileService.get(id);
		model.addAttribute("sysFile", sysFile);
		return "common/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("common:info")
	public ResultObject info(@PathVariable("id") String id) {
		FileDO sysFile = sysFileService.get(id);
		return ResultObject.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:save")
	public ResultObject save(FileDO sysFile) {
		if (sysFileService.save(sysFile) > 0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("common:update")
	public ResultObject update(@RequestBody FileDO sysFile) {
		sysFileService.update(sysFile);

		return ResultObject.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public ResultObject remove(String id, HttpServletRequest request) {
		String fileName = bootdoConfig.getUploadPath() + sysFileService.get(id).getUrl();
		if (sysFileService.remove(id) > 0) {
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return ResultObject.error("数据库记录删除成功，文件删除失败");
			}
			return ResultObject.ok();
		} else {
			return ResultObject.error();
		}
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:remove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids) {
		sysFileService.batchRemove(ids);
		return ResultObject.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	ResultObject upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String newFileName = FileUtil.renameToUUID(fileName);
		String linkedId = request.getParameter("linkedId");
		String mode_type =  request.getParameter("mode_type");
		/*if (StringUtils.isEmpty(type)){
			type = FileType.fileType(fileName);
		}*/
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + newFileName, fileName, linkedId,mode_type);
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath()+"/files/", newFileName);
		} catch (Exception e) {
			return ResultObject.error();
		}
		sysFile.addData();
		if (sysFileService.save(sysFile) > 0) {
			return ResultObject.ok().put("fileUrl",sysFile.getUrl()).put("fileId",sysFile.getId()).put("showPath", bootdoConfig.getShowPath());
		}
		return ResultObject.error();
	}


	@ResponseBody
	@PostMapping("/initImages")
	public ResultObject initImages(String linkedId, String type) {
		List<FileDO> files = sysFileService.getTypeFiles(linkedId,type);
		return ResultObject.ok(JSONArray.toJSONString(files)).put("uploadShowPath", bootdoConfig.getShowPath());
	}
}

package cn.wewintech.common.service.impl;

import cn.wewintech.common.config.BootdoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

import cn.wewintech.common.dao.FileDao;
import cn.wewintech.common.domain.FileDO;
import cn.wewintech.common.service.FileService;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao sysFileMapper;

	@Autowired
	private BootdoConfig bootdoConfig;

	@Override
	public FileDO get(String id) {
		return sysFileMapper.get(id);
	}

	@Override
	public List<FileDO> list(Map<String, Object> map) {
		return sysFileMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return sysFileMapper.count(map);
	}

	@Override
	public int save(FileDO sysFile) {
		return sysFileMapper.save(sysFile);
	}

	@Override
	public int update(FileDO sysFile) {
		return sysFileMapper.update(sysFile);
	}

	@Override
	public int remove(String id) {
		return sysFileMapper.remove(id);
	}

	@Override
	public int batchRemove(String[] ids) {
		return sysFileMapper.batchRemove(ids);
	}

	@Override
	public Boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = bootdoConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public List<FileDO> getTypeFiles(String linkedId, String type) {
		return sysFileMapper.getTypeFiles(linkedId, type);
	}
	
	
}

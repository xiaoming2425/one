package cn.wewintech.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.wewintech.common.domain.LogDO;
import cn.wewintech.common.domain.PageDO;
import cn.wewintech.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}

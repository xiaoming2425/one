package cn.wewintech.common.service;

import cn.wewintech.common.domain.SeqnoDO;

import java.util.List;
import java.util.Map;

/**
 * 流水号生成
 * 
 * @author 
 * @email 
 * @date 2020-05-15 16:24:23
 */
public interface SeqnoService {
	
	SeqnoDO get(String id);
	
	List<SeqnoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SeqnoDO seqno);
	
	int update(SeqnoDO seqno);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	String nextId(String code);
}

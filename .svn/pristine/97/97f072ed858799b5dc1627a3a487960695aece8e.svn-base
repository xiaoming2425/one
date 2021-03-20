package cn.wewintech.common.dao;

import cn.wewintech.common.domain.SeqnoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



/**
 * 流水号生成
 * @author 
 * @email 
 * @date 2020-05-15 16:24:23
 */
@Mapper
public interface SeqnoDao {

	SeqnoDO get(String id);
	
	List<SeqnoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SeqnoDO seqno);
	
	int update(SeqnoDO seqno);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	public abstract SeqnoDO getByCode(SeqnoDO paramSeqNo);
	  
	  public abstract SeqnoDO getByName(SeqnoDO paramSeqNo);
	  
	  public abstract int updateNo(SeqnoDO paramSeqNo);
	  
	  public abstract List<SeqnoDO> getByCategory(SeqnoDO paramSeqNo);
	  
	  //public abstract void deleteSeqNoOffice(SeqnoDO paramSeqNo);
	  
	 // public abstract void insertSeqNoOffice(SeqnoDO paramSeqNo);
	  
	  public abstract void insertSeqNoHistory(SeqnoDO paramSeqNo);
	  
	  public abstract SeqnoDO getHistorySeqNo(SeqnoDO paramSeqNo);
	  
	  public abstract void deleteSeqNoHistory(SeqnoDO paramSeqNo);
}

package cn.wewintech.common.dao;

import cn.wewintech.common.domain.FileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 文件上传
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface FileDao {

	FileDO get(String id);
	
	List<FileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FileDO file);
	
	int update(FileDO file);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	List<FileDO> getTypeFiles(@Param("linkedId")  String linkedId,@Param("modeType")   String type);
}

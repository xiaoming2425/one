package cn.wewintech.common.domain;

import java.io.Serializable;

import cn.wewintech.common.core.DataModel;

/**
 * 文件上传
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
public class FileDO extends DataModel implements Serializable {
    private static final long serialVersionUID = 1L;

    // 文件类型
    private String type;
    // URL地址
    private String url;
    //文件名
    private String fileName;
    //关联id
    private String linkedId;

    private String modeType;

    public FileDO() {
        super();
    }


    public FileDO(String type, String url, String fileName, String linkedId,String modeType) {
        super();
        this.type = type;
        this.url = url;
        this.fileName = fileName;
        this.linkedId = linkedId;
        this.modeType=modeType;
    }

    /**
     * 设置：文件类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：URL地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：URL地址
     */
    public String getUrl() {
        return url;
    }
    

    public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getLinkedId() {
		return linkedId;
	}


	public void setLinkedId(String linkedId) {
		this.linkedId = linkedId;
	}


	public String getModeType() {
		return modeType;
	}


	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	
}

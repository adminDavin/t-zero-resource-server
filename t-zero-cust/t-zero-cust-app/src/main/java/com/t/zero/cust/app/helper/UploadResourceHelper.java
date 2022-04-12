package com.t.zero.cust.app.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.request.CommonParams;
import com.t.zero.cust.app.co.file.MinIoUtil;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */
@Component
public class UploadResourceHelper {
	public static final String DEFAULT_FILE_PATH = "/";

	@Autowired
	private MinIoUtil minIoUtil;

	/**
	 * 执行上传任务
	 * 
	 * @param params
	 * @param resTask
	 * @param file
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public Object uploadFile(CommonParams params, MultipartFile file) throws Exception {
		var targetFile = minIoUtil.uploadFiles(file, "cust/app/" + params.getUserId() + DEFAULT_FILE_PATH);
		return targetFile;
	}

}

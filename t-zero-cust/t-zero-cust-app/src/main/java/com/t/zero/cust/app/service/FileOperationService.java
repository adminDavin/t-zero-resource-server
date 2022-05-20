package com.t.zero.cust.app.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.request.CommonParams;
import com.t.zero.cust.app.helper.FileHandlerHelper;

@Service
public class FileOperationService {
	
	@Autowired
	public FileHandlerHelper fileHandlerHelper;
	
	public Object upload(CommonParams params, MultipartFile file) throws Exception {
		return fileHandlerHelper.doUpload(params, file).object();
	}

	public void download(String userAgent, String range, String resInfoStore, HttpServletResponse response) {
		fileHandlerHelper.directDownload(userAgent, range, resInfoStore, response);
	}

}

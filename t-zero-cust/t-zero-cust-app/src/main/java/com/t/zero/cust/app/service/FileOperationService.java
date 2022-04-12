package com.t.zero.cust.app.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.request.CommonParams;

@Service
public class FileOperationService {

	public Object upload(CommonParams build, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	public void download(CommonParams build, String userAgent, String range, String resInfoStore, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}

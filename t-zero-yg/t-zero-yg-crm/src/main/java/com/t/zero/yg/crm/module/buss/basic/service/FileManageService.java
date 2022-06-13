package com.t.zero.yg.crm.module.buss.basic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;

@Service
public class FileManageService {
	public static String realPath = "../files";

	public Object upload(CommonParams build, String resInfoCode, MultipartFile file) throws Exception {
		String s = UUIDUtils.getUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
		file.transferTo(new File(realPath, s));
		return s;
	}

	public void download(CommonParams build, String userAgent, String range, String resInfoCode, String filename,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/force-download");
		filename = URLEncoder.encode(filename, "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		File downloadFile = new File(realPath + File.separator + resInfoCode);
		InputStream in = new FileInputStream(downloadFile);
		response.setContentLength(in.available());
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(in, out);
	}

}

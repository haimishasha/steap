package com.thinkPro.steap.common;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController implements ServletContextAware {

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public ModelAndView handleUploadData(
			@RequestParam("files") List<MultipartFile> files) {
		ModelAndView mv = new ModelAndView();

		if (files != null && files.size() > 0) {
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				saveFile(file);
			}
		}
		mv.setViewName("/home");
		return mv;
	}

	public void saveFile(MultipartFile file) {
		if (!file.isEmpty()) {

			String path = this.servletContext.getRealPath("/wordFile/");
			String originalFilename = file.getOriginalFilename();
			String filename = originalFilename.substring(0,
					originalFilename.lastIndexOf("."))
					+ ".pdf";
			try {
//				ValidateCheck.checkFile(path + originalFilename);
				file.transferTo(new File(path, originalFilename));

				String sourceFile = path + File.separator + originalFilename;
				String targetFile = this.servletContext
						.getRealPath("pdfJs/generic/web/PDFFile")
						+ File.separator + filename;
				 new WordToPDF().wordToPDF(sourceFile, targetFile, 17);
//				new Word2PDF().createPDF(sourceFile, targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

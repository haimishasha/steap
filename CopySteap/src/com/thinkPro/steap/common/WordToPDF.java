package com.thinkPro.steap.common;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordToPDF {
	private ActiveXComponent app = null;
	private Dispatch docs = null;
	private boolean isinit = false;
	static final int wdDoNotSaveChanges = 0; // 不保存待定的更改

	public void init() {
		if (!isinit) {
			app = new ActiveXComponent("Word.Application"); // 启动word
			app.setProperty("Visible", new Variant(false));
			docs = app.getProperty("Documents").toDispatch();
		}
	}

	public boolean wordToPDF(String sourceFile, String targetFile, int type) {
		System.out.println("启动Word");
		long start = System.currentTimeMillis();

		if (!isinit) {
			this.init();
		}
		try {

			System.out.println("打开文档" + sourceFile);
			Dispatch doc = Dispatch.invoke(
					docs,
					"Open",
					Dispatch.Method,
					new Object[] { sourceFile, new Variant(false),
							new Variant(true) }, new int[1]).toDispatch();

			ValidateCheck.checkFile(targetFile);
			// type: 源文件另存为的文件类型
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
					targetFile, new Variant(type) }, new int[1]);
			Dispatch.call(doc, "Close", new Variant(false));

			long end = System.currentTimeMillis();
			System.out.println("转换完成，用时:" + (end - start) + " ms.");

			return true;
		} catch (Exception ex) {
			System.out.println("Word转PDF出错：" + ex.getMessage());
			return false;
		} finally {
			// app.invoke("Quit", new Variant[] {});
			if (isinit) {
				app.invoke("Quit", wdDoNotSaveChanges);
//				isinit = false;
			}
		}
	}

	public static void main(String[] args) {
		String basePath = "D:\\work\\learn\\Before_2016_code\\workspace_ex\\MyEclipse Workspace\\WordToPDF\\WebRoot";
		String sourceFile = basePath + File.separator + "wordFile"
				+ File.separator + "wordToPDF.docx";
		String targetFile = basePath + File.separator + "PDFFile"
				+ File.separator + "wordToPDF.pdf";
		int wdFormatPDF = 17;
		new WordToPDF().wordToPDF(sourceFile, targetFile, wdFormatPDF);
	}
}
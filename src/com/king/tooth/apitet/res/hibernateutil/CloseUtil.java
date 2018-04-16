package com.king.tooth.apitet.res.hibernateutil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import com.king.tooth.apitet.res.hibernateutil.Log4jUtil;


public class CloseUtil {
	/**
	 * 关闭File-IO类
	 * @param io
	 */
	public static void closeIO(Object io){
		if(io == null){
			Log4jUtil.debug("[CloseUtil.close]要关闭的IO对象为null");
			return;
		}

		String ioClass = io.getClass().toString();
		Log4jUtil.debug("[CloseUtil.closeIO]要关闭的IO对象为:{}", ioClass);
		try {
			if(ioClass.contains("Writer")){
				Writer writer = (Writer) io;
				writer.flush();
				writer.close();
				writer = null;
			}else if(ioClass.contains("Reader")){
				Reader reader = (Reader) io;
				reader.close();
				reader = null;
			}else if(ioClass.contains("OutputStream")){
				OutputStream out = (OutputStream) io;
				out.flush();
				out.close();
				out = null;
			}else if(ioClass.contains("InputStream")){
				InputStream in = (InputStream) io;
				in.close();
				in = null;
			}else{
				Log4jUtil.debug("[CloseUtil.closeIO]没有匹配到要关闭的类型:{}", ioClass);
			}
		} catch (IOException e) {
			Log4jUtil.debug("[CloseUtil.closeIO]方法在关闭IO对象出现异常信息:{}", e.getMessage());
		}finally{
			io = null;
		}
	}
}

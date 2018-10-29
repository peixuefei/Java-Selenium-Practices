package org.changcheng.selenium1019;

import org.changcheng.selenium1019.logger.MyLogger;

public class LogTest {

	public static void main(String[] args) {
//		Logger logger = LogManager.getLogger(LogTest.class);
////		日志分为不同的级别： 
////		trace最不重要的级别（平时很少用）
////		debug调试代码用的
////		info正常的信息，比如点击了某个按钮，执行了某个页面操作
////		warn警号级别：有错误，但不影响主程序执行
////		error级别：测试用例执行失败，或者抛出异常，影响程序的正常执行
////		fatal：最严重的级别：比如程序崩溃
//		logger.trace("trace");
//		logger.debug("debug");
//		logger.info("info");
//		logger.warn("warn");
//		logger.error("error");
//		logger.fatal("fatal");
		MyLogger log = new MyLogger(LogTest.class);
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
		
	}

}

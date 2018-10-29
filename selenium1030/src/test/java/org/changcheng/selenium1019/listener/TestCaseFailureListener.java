package org.changcheng.selenium1019.listener;

import org.changcheng.selenium1019.util.SnapshotManager;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestCaseFailureListener extends RunListener {
	@Override
    public void testFailure(Failure failure) throws Exception {
//		自动生成文件名，要求通过文件名可以知道是哪个测试用例执行失败了
//		可以用类名加上方法名，组合来生成一个文件名
//		例：PersonalInfoPageTest2_updatePersonalInfo
		String filename = failure.getDescription().getTestClass().getSimpleName()
				+ "_" + failure.getDescription().getMethodName();
		SnapshotManager.getScreenshot(filename);
    }
}

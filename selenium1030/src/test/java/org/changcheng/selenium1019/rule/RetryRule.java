package org.changcheng.selenium1019.rule;

import org.changcheng.selenium1019.annotation.Retry;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {
	@Override
	public Statement apply(final Statement statement, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				Throwable retryThrowable = null;
				Retry retry =description.getAnnotation(Retry.class);
				if (retry != null) {
					System.out.println("找到retry标签");
					int times = retry.times();
					System.out.println(times);
					for (int i=0; i<times; i++) {
						try {
							statement.evaluate();
							return;
						} catch (Throwable t) {
							retryThrowable = t;
							System.err.println("测试用例："+description.getMethodName()+"正在重试第"+(i+1)+"次");
						}
					}
					
					System.err.println("在尝试了"+times+"次后，测试用例："+description.getMethodName()+"最终执行失败了");
					throw retryThrowable;
				} else {
					System.out.println("没找到retry标签");
					statement.evaluate();
				}
			}
			
		};
	}

}
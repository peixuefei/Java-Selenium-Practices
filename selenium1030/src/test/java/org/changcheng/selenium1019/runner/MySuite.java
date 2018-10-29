package org.changcheng.selenium1019.runner;

import java.util.List;

import org.changcheng.selenium1019.listener.TestCaseFailureListener;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.Statement;

public class MySuite extends Suite {
//	集成父类需要实现父类的构造方法
//	右键点击类中空白，选择source--》选择generator constructor
	public MySuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, suiteClasses);
		// TODO Auto-generated constructor stub
	}

	public MySuite(Class<?> klass, List<Runner> runners) throws InitializationError {
		super(klass, runners);
		// TODO Auto-generated constructor stub
	}

	public MySuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		super(klass, builder);
		// TODO Auto-generated constructor stub
	}

	public MySuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, suiteClasses);
		// TODO Auto-generated constructor stub
	}

	public MySuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
		super(builder, classes);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void run(final RunNotifier notifier) {
		notifier.addListener(new TestCaseFailureListener());
		EachTestNotifier testNotifier = new EachTestNotifier(notifier,
                getDescription());
        try {
            Statement statement = classBlock(notifier);
            statement.evaluate();
        } catch (AssumptionViolatedException e) {
            testNotifier.fireTestIgnored();
        } catch (StoppedByUserException e) {
            throw e;
        } catch (Throwable e) {
            testNotifier.addFailure(e);
        }
	}

}

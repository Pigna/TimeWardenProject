package model.control;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class NewUserCountInterceptor {

	@Inject
	NewUserTracker newUserTracker;
	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		newUserTracker.track();
		return context.proceed();
	}
}

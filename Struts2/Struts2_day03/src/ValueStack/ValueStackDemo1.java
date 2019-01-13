package ValueStack;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemo1 extends ActionSupport{

	@Override
	public String execute() throws Exception {
		//获得值栈：
		ValueStack stack1 = ActionContext.getContext().getValueStack();
		//ValueStack stack1= (ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		return SUCCESS;
	}
	
}









































































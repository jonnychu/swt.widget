package cn.nextop.action.actor;

import org.eclipse.swt.widgets.Display;

import cn.nextop.action.IAction;
import cn.nextop.action.IReactor;
import cn.nextop.widget.IWidget;

/**
 * @author jonny
 */
public class DefaultRector implements IReactor {
	//
	protected final IWidget widget;
	
	/**
	 * 
	 */
	public DefaultRector(IWidget widget) {
		this.widget = widget;
	}
	
	/**
	 * 
	 */
	@Override 
	public void submit(IAction action) { 
		//
		final Display display = this.widget.getDisplay();
		if(display.getThread() == Thread.currentThread()) {
			action.apply(this.widget);
		} else {
			display.syncExec(() -> { action.apply(this.widget); });
		}
	}
}

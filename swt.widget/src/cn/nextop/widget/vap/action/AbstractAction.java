package cn.nextop.widget.vap.action;

import cn.nextop.action.IAction;

public abstract class AbstractAction implements IAction {
	//
	protected final Type type;
	protected enum Type { FEED, LAYOUT; }
	
	/**
	 * 
	 */
	public Type getType() { return this.type; }
	
	/**
	 * 
	 */
	public AbstractAction(Type type) { this.type = type; }
}

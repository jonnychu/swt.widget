package cn.nextop.widget.vap;

import org.eclipse.draw2d.Figure;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

import cn.nextop.action.IReactor;
import cn.nextop.widget.IWidget;

public class VapPanel extends Figure implements IWidget {
	//
	protected Canvas canvas;
	protected IReactor reactor;
	
	/**
	 * 
	 */
	public VapPanel(Canvas canvas) {
		
	}
	
	public Display getDisplay() { return this.canvas.getDisplay(); }

}

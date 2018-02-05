package cn.nextop.widget;

import org.eclipse.draw2d.Figure;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

/**
 * @author jonny
 */
public class AbstractWidget extends Figure implements IWidget {
	//
	protected Canvas canvas;
	
	/**
	 * 
	 */
	public AbstractWidget(Canvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public Display getDisplay() { return this.canvas.getDisplay(); }
}

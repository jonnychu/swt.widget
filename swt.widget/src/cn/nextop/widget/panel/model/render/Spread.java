package cn.nextop.widget.panel.model.render;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.widget.panel.PricePanel;

public class Spread extends Figure {
	//
	protected PricePanel parent;
	
	/**
	 * 
	 */
	public Spread(PricePanel parent) {
		this.parent = parent; setOpaque(true);
	}
	
	/**
	 * 
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		Rectangle rect = getClientArea();
		Rectangle r = new Rectangle(rect.x, rect.y, rect.width - 1, rect.height - 1);
		graphics.drawRectangle(r);
	}
}

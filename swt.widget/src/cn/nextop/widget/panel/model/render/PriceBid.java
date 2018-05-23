package cn.nextop.widget.panel.model.render;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.model.PricePanelModel;
import cn.nextop.widget.panel.model.config.PricePanelConfig;
import cn.nextop.widget.panel.model.config.theme.PricePanelTheme;

public class PriceBid extends Figure {
	//
	protected PricePanel parent;
	
	/**
	 * 
	 */
	public PriceBid(PricePanel parent) {
		this.parent = parent; setOpaque(true);
	}
	
	/**
	 * 
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics); Rectangle rect = getClientArea();
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		//
		final PricePanelModel model = parent.getModel();
		final PricePanelConfig config = model.getConfig();
		final PricePanelTheme theme = config.getTheme();
		if(model.isSelect1()) {
			graphics.setBackgroundColor(theme.getColorEnter1());
			if(model.isPressed1()) {
				graphics.fillGradient(new Rectangle(x + 1, y + 1, w, h), false);
			} else {
				graphics.fillGradient(new Rectangle(x + 1, y + 1, w, h), true);
			}
		} else { graphics.setBackgroundColor(theme.getColorPressed1()); }
	}
}

package cn.nextop.widget.panel.model.render;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.model.PricePanelModel;
import cn.nextop.widget.panel.model.config.PricePanelConfig;
import cn.nextop.widget.panel.model.config.theme.PricePanelTheme;

public class PriceAsk extends Figure {
	//
	protected PricePanel parent;
	
	/**
	 * 
	 */
	public PriceAsk(PricePanel parent) {
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
		graphics.drawLine(x, y, x, y + h); if(model.isSelect2()) {
			graphics.setBackgroundColor(theme.getEnterColor());
			if(model.isPressed2()) {
				graphics.fillGradient(new Rectangle(x + 1, y + 1, w - 1, h - 1), false);
			} else {
				graphics.fillGradient(new Rectangle(x + 1, y + 1, w - 1, h - 1), true);
			}
		} else { graphics.setBackgroundColor(theme.getExitColor()); }
	}
}

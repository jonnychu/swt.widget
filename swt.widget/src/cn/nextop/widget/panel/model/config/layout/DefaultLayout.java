package cn.nextop.widget.panel.model.config.layout;

import org.eclipse.draw2d.geometry.Rectangle;

import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.model.render.Control;
import cn.nextop.widget.panel.model.render.PriceAsk;
import cn.nextop.widget.panel.model.render.PriceBid;
import cn.nextop.widget.panel.model.render.Spread;

public class DefaultLayout {
	
	/**
	 * 
	 */
	public void layout(PricePanel panel) {
		//
		final Spread s = panel.getSpread();
		final Control c = panel.getControl();
		final PriceBid p1 = panel.getPriceBid();
		final PriceAsk p2 = panel.getPriceAsk();
		Rectangle rect = panel.getClientArea(); int w = rect.width, h = rect.height;
		
		//
		p1.setBounds(new Rectangle(0, 0, w / 2, h - 30));
		c.setBounds(new Rectangle(0, h - 30 - 1, w, 30));
		p2.setBounds(new Rectangle(w / 2, 0, w / 2, h - 30));
		s.setBounds(new Rectangle(w / 4, h - 30 - 30, w / 2, 30));
	}
}

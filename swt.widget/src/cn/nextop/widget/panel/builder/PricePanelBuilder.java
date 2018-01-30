package cn.nextop.widget.panel.builder;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;

import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.model.PricePanelModel;
import cn.nextop.widget.panel.model.config.PricePanelConfig;
import cn.nextop.widget.panel.model.config.theme.PricePanelTheme;
import cn.nextop.widget.panel.model.render.Control;

public class PricePanelBuilder {
	//
	protected PricePanel panel;
	protected LightweightSystem lws;
	
	/**
	 * 
	 */
	public PricePanelBuilder(Canvas canvas) {
		this.lws = new LightweightSystem(canvas);
		this.panel = new PricePanel(canvas); lws.setContents(panel);
	}
	
	/**
	 * 
	 */
	public PricePanel build() { return panel; }
	
	public PricePanelBuilder exitColor(Color color) {
		final PricePanelModel model = panel.getModel();
		final PricePanelConfig config = model.getConfig();
		final PricePanelTheme theme = config.getTheme();
		theme.setExitColor(color); return this;
	}
	
	public PricePanelBuilder enterColor(Color color) {
		final PricePanelModel model = panel.getModel();
		final PricePanelConfig config = model.getConfig();
		final PricePanelTheme theme = config.getTheme();
		theme.setEnterColor(color); return this;
	}
	
	public PricePanelBuilder addControl(String text, Runnable action) {
		final Control control = panel.getControl(); control.addWidget(text, action); return this;
	}
	
	public PricePanelBuilder addSelectionListener1(Runnable r) {
		this.panel.addSelectionListener1(r); return this;
	}
	
	public PricePanelBuilder addSelectionListener2(Runnable r) {
		this.panel.addSelectionListener2(r); return this;
	}
}

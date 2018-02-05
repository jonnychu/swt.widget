package cn.nextop.widget.panel.model.config;

import cn.nextop.widget.panel.model.config.layout.PricePanelLayout;
import cn.nextop.widget.panel.model.config.theme.PricePanelTheme;

public class PricePanelConfig {
	//
	protected PricePanelTheme theme;
	protected PricePanelLayout layout;
	
	/**
	 * 
	 */
	public PricePanelConfig() {
		theme = new PricePanelTheme();
		layout = new PricePanelLayout();
	}

	/**
	 * 
	 */
	public PricePanelLayout getLayout() {
		return layout;
	}

	public void setLayout(PricePanelLayout layout) {
		this.layout = layout;
	}

	public PricePanelTheme getTheme() {
		return theme;
	}

	public void setTheme(PricePanelTheme theme) {
		this.theme = theme;
	}
}

package cn.nextop.widget.panel.model.config;

import cn.nextop.widget.panel.model.config.layout.DefaultLayout;
import cn.nextop.widget.panel.model.config.theme.PricePanelTheme;

public class PricePanelConfig {
	//
	protected DefaultLayout layout;
	protected PricePanelTheme theme;
	
	/**
	 * 
	 */
	public PricePanelConfig() {
		layout = new DefaultLayout();
		theme = new PricePanelTheme();
	}

	/**
	 * 
	 */
	public DefaultLayout getLayout() {
		return layout;
	}

	public void setLayout(DefaultLayout layout) {
		this.layout = layout;
	}

	public PricePanelTheme getTheme() {
		return theme;
	}

	public void setTheme(PricePanelTheme theme) {
		this.theme = theme;
	}
}

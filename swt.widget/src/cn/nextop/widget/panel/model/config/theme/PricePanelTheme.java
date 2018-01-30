package cn.nextop.widget.panel.model.config.theme;

import org.eclipse.swt.graphics.Color;

import cn.nextop.support.util.Colors;

public class PricePanelTheme {
	//
	protected Color exitColor;
	protected Color enterColor;
	
	/**
	 * 
	 */
	public PricePanelTheme() {
		this.enterColor = Colors.COLOR_GREEN;
		this.exitColor = Colors.COLOR_DARK_GRAY;
	}
	
	/**
	 * 
	 */
	public Color getExitColor() {
		return exitColor;
	}

	public void setExitColor(Color exitColor) {
		this.exitColor = exitColor;
	}

	public Color getEnterColor() {
		return enterColor;
	}

	public void setEnterColor(Color enterColor) {
		this.enterColor = enterColor;
	}
}

package cn.nextop.widget.panel.model.config.theme;

import org.eclipse.swt.graphics.Color;

import cn.nextop.support.util.Colors;

public class PricePanelTheme {
	//
	protected Color colorEnter1, colorPressed1, colorEnter2, colorPressed2;
	
	/**
	 * 
	 */
	public PricePanelTheme() {
		this.colorEnter1 = Colors.COLOR_GREEN;
		this.colorPressed1 = Colors.COLOR_DARK_GRAY;
		this.colorEnter2 = Colors.COLOR_BLUE;
		this.colorPressed2 = Colors.COLOR_RED;
	}

	/**
	 * 
	 */
	public Color getColorEnter1() {
		return colorEnter1;
	}

	public void setColorEnter1(Color colorEnter1) {
		this.colorEnter1 = colorEnter1;
	}

	public Color getColorPressed1() {
		return colorPressed1;
	}

	public void setColorPressed1(Color colorPressed1) {
		this.colorPressed1 = colorPressed1;
	}

	public Color getColorEnter2() {
		return colorEnter2;
	}

	public void setColorEnter2(Color colorEnter2) {
		this.colorEnter2 = colorEnter2;
	}

	public Color getColorPressed2() {
		return colorPressed2;
	}

	public void setColorPressed2(Color colorPressed2) {
		this.colorPressed2 = colorPressed2;
	}

}

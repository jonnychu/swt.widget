package cn.nextop.widget.panel.model;

import cn.nextop.widget.panel.model.config.PricePanelConfig;

public class PricePanelModel {
	//
	protected PricePanelConfig config;
	private boolean select1, select2, pressed1, pressed2;
	
	/**
	 * 
	 */
	public PricePanelModel() {
		this.config = new PricePanelConfig();
	}
	
	/**
	 * 
	 */
	public boolean isSelect1() {
		return select1;
	}

	public void setSelect1(boolean select1) {
		this.select1 = select1;
	}

	public boolean isSelect2() {
		return select2;
	}

	public void setSelect2(boolean select2) {
		this.select2 = select2;
	}

	public boolean isPressed1() {
		return pressed1;
	}

	public void setPressed1(boolean pressed1) {
		this.pressed1 = pressed1;
	}

	public boolean isPressed2() {
		return pressed2;
	}

	public void setPressed2(boolean pressed2) {
		this.pressed2 = pressed2;
	}
	
	public PricePanelConfig getConfig() {
		return config;
	}

	public void setConfig(PricePanelConfig config) {
		this.config = config;
	}

	/**
	 * 
	 */
	public void setSelect(boolean select1, boolean select2) {
		this.select1 = select1; this.select2 = select2;
	}
	
	public void setPressed(boolean pressed1, boolean pressed2) {
		this.pressed1 = pressed1; this.pressed2 = pressed2;
	}
}

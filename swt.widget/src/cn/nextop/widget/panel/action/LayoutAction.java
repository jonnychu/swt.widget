package cn.nextop.widget.panel.action;

import cn.nextop.widget.IWidget;
import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.model.PricePanelModel;
import cn.nextop.widget.panel.model.config.PricePanelConfig;
import cn.nextop.widget.panel.model.config.layout.DefaultLayout;

/**
 * @author jonny
 */
public class LayoutAction extends AbstractAction {

	public LayoutAction() { super(Type.LAYOUT); }

	@Override
	public Boolean apply(IWidget widget) {
		PricePanel panel = (PricePanel)widget;
		PricePanelModel model = panel.getModel();
		PricePanelConfig config = model.getConfig();
		final DefaultLayout layout = config.getLayout(); 
		layout.layout(panel); panel.repaint(); return true;
	}
}

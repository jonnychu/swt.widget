package cn.nextop.widget.panel.model.render;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Font;

import com.patrikdufresne.fontawesome.FontAwesome;

import cn.nextop.support.util.Colors;
import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.model.PricePanelModel;
import cn.nextop.widget.panel.model.config.PricePanelConfig;
import cn.nextop.widget.panel.model.config.theme.PricePanelTheme;

@SuppressWarnings("unused")
public class Control extends Figure {
	//
	protected PricePanel parent;
	protected List<IFigure> widgets;
	
	/**
	 * 
	 */
	public Control(PricePanel parent) {
		this.widgets = new ArrayList<>();
		setOpaque(true); this.parent = parent;
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics); Rectangle rect = getClientArea();
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		Rectangle r = new Rectangle(x, y, w - 1, h); graphics.drawRectangle(r);
	}
	
	@Override
	protected void layout() {
		super.layout(); Rectangle rect = getClientArea();
		int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		if(widgets.size() == 0) return; int w1 = w / widgets.size();
		for (IFigure f : widgets) { Dimension p = f.getPreferredSize();
			f.setBounds(new Rectangle(x + (w1 - p.width) / 2, y + (h - p.height) / 2, p.width, p.height)); x += w1;
		}
	}
	
	/**
	 * 
	 */
	public void addWidget(String text, Runnable action) {
		Widget w = new Widget(text, action); this.widgets.add(w); add(w); invalidate();
	}
	
	/**
	 * 
	 */
	protected class Widget extends Figure {
		//
		private String text;
		private Runnable action;
		private boolean enter, pressed;
		private Font font = FontAwesome.getFont();
		
		/**
		 * 
		 */
		public Widget(String text, Runnable action) {
			this.text = text; this.action = action; addListener();
		}
		
		/**
		 * 
		 */
		@Override
		public Dimension getPreferredSize(int wHint, int hHint) {
			Dimension p = TextUtilities.INSTANCE.getStringExtents(text, font);
			return new Dimension(p.width, p.height);
		}
		
		@Override
		protected void paintFigure(Graphics graphics) {
			super.paintFigure(graphics); Rectangle rect = getClientArea();
			final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
			//
			final PricePanelModel model = parent.getModel();
			final PricePanelConfig config = model.getConfig();
			final PricePanelTheme theme = config.getTheme();
			graphics.pushState(); graphics.setFont(this.font);
			if(enter) {
				if (pressed) graphics.setForegroundColor(theme.getColorPressed2());
				else graphics.setForegroundColor(theme.getColorEnter2());
			}
			graphics.drawText(text, x, y); graphics.popState();
		}
		
		protected void addListener() {
			this.addMouseMotionListener(new MouseMotionListener.Stub() {
				@Override public void mouseExited(MouseEvent me) { enter = false; repaint(); }
				@Override public void mouseEntered(MouseEvent me) { enter = true; repaint(); }
			});
			addMouseListener(new MouseListener.Stub() {
				@Override public void mousePressed(MouseEvent me) { pressed = true; repaint(); }

				@Override public void mouseReleased(MouseEvent me) {
					pressed = false; if(action != null) action.run(); repaint();
				}
			});
		}
	}
}

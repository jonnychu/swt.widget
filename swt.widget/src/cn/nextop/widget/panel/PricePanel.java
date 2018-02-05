package cn.nextop.widget.panel;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

import cn.nextop.action.IReactor;
import cn.nextop.action.actor.DefaultRector;
import cn.nextop.widget.AbstractWidget;
import cn.nextop.widget.panel.action.LayoutAction;
import cn.nextop.widget.panel.model.PricePanelModel;
import cn.nextop.widget.panel.model.render.Control;
import cn.nextop.widget.panel.model.render.PriceAsk;
import cn.nextop.widget.panel.model.render.PriceBid;
import cn.nextop.widget.panel.model.render.Spread;

/**
 * @author jonny
 */
public class PricePanel extends AbstractWidget {
	//
	protected Spread s;
	protected Control c;
	protected PriceBid p1;
	protected PriceAsk p2;
	protected IReactor reactor;
	protected PricePanelModel model;
	//
	protected final MouseAdapter adapter;
	
	/**
	 * 
	 */
	public PricePanel(Canvas canvas) {
		super(canvas);
		this.model = new PricePanelModel();
		this.reactor = new DefaultRector(this);
		p1 = new PriceBid(this); s = new Spread(this);
		p2 = new PriceAsk(this); c = new Control(this);  
		add(p1); add(p2); add(c); add(s); this.adapter = new MouseAdapter();
		//
		addMouseListener(adapter); addMouseMotionListener(adapter);
	}
	
	/**
	 * 
	 */
	public Spread getSpread() { return s; }
	public Control getControl() { return c; }
	public PriceBid getPriceBid() { return p1; }
	public PriceAsk getPriceAsk() { return p2; }
	public PricePanelModel getModel() { return this.model; }
	public void setModel(PricePanelModel model) { this.model = model; }
	public void addSelectionListener1(Runnable r) { this.adapter.addSelectionListener1(r); }
	public void addSelectionListener2(Runnable r) { this.adapter.addSelectionListener2(r); }
	
	/**
	 * 
	 */
	@Override 
	public Display getDisplay() { return this.canvas.getDisplay(); }
	
	@Override
	protected void layout() { super.layout(); reactor.submit(new LayoutAction()); }
	
	@Override
	protected void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics); Rectangle rect = getClientArea();
		final int x = rect.x, y = rect.y, w = rect.width, h = rect.height;
		//
		graphics.drawRoundRectangle(new Rectangle(x, y, w - 1, h - 1), 6, 6);
	}
	
	/**
	 * 
	 */
	protected class MouseAdapter extends MouseMotionListener.Stub implements MouseListener {
		//
		private Runnable l1, l2;
		
		/**
		 * 
		 */
		public void addSelectionListener1(Runnable l1) { this.l1 = l1; }
		public void addSelectionListener2(Runnable l2) { this.l2 = l2; }
		
		/**
		 * 
		 */
		@Override public void mouseReleased(MouseEvent me) {
			IFigure f = findFigureAt(me.x, me.y, new PriceSearch());
			if(f instanceof PriceBid && l1 != null) l1.run(); 
			if(f instanceof PriceAsk && l2 != null) l2.run();
			model.setPressed(false, false); repaint(); 
		}

		@Override public void mouseDoubleClicked(MouseEvent me) { }
		
		@Override public void mousePressed(MouseEvent me) {
			IFigure f = findFigureAt(me.x, me.y, new PriceSearch());
			if(f instanceof PriceBid) { model.setPressed(true, false); }
			else if(f instanceof PriceAsk) { model.setPressed(false, true); }
			else { model.setPressed(false, false); } repaint();
		}
		
		@Override public void mouseExited(MouseEvent me) {
			super.mouseExited(me); model.setSelect(false, false); repaint();
		}
		
		@Override public void mouseMoved(MouseEvent me) {
			IFigure f = findFigureAt(me.x, me.y, new PriceSearch());
			if(f instanceof PriceBid) { model.setSelect(true, false); f.setCursor(Cursors.HAND);}
			else if(f instanceof PriceAsk) { model.setSelect(false, true); f.setCursor(Cursors.HAND); }
			else { model.setSelect(false, false); if(f != null) f.setCursor(null); } repaint(); 
		}
	}
	
	protected class PriceSearch implements TreeSearch {
		@Override public boolean prune(IFigure figure) { return false; }
		@Override public boolean accept(IFigure figure) { return true; }
	}
}

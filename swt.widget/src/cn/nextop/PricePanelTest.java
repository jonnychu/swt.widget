package cn.nextop;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.patrikdufresne.fontawesome.FontAwesome;

import cn.nextop.widget.panel.PricePanel;
import cn.nextop.widget.panel.builder.PricePanelBuilder;
import net.miginfocom.swt.MigLayout;

public class PricePanelTest {
	//
	public static void main(String args[]) {
		PricePanelTest m = new PricePanelTest(); m.init();
	}
	
	//
	protected void init() {
		Shell shell = new Shell();
		shell.setLayout(new MigLayout("insets 20","[fill,grow]","[fill,grow]"));
		FigureCanvas c = new FigureCanvas(shell); c.setLayoutData("cell 0 0");
		
		//
		PricePanelBuilder builder = new PricePanelBuilder(c);
		PricePanel panel = builder.addControl(FontAwesome.connectdevelop, this::onSelect1).addControl(FontAwesome.address_book_o, this::onSelect2)
				.addSelectionListener1(this::onSelected).build();
		panel.addSelectionListener2(this::onSelected);
		
		//
		shell.setSize(500, 300); shell.open();
		Display display = Display.getDefault();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	
	protected void onSelect1() {
		System.out.println("onSelect1");
	}
	
	protected void onSelect2() {
		System.out.println("onSelect2");
	}
	
	protected void onSelected() {
		System.out.println("click");
	}
	

}
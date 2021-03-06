package es.lanyu.ui.swing.listener;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JViewport;

public class HandScrollListener extends MouseAdapter
{
    private final Cursor defCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
    private final Cursor hndCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private final Point pp = new Point();
    private final JPanel panel;

    public HandScrollListener(JPanel panel)
    {
        this.panel = panel;
    }

    public void mouseDragged(final MouseEvent e)
    {
        JViewport vport = (JViewport)e.getSource();
        Point cp = e.getPoint();
        Point vp = vport.getViewPosition();
        vp.translate(pp.x-cp.x, pp.y-cp.y);
        panel.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
        pp.setLocation(cp);
    }

    public void mousePressed(MouseEvent e)
    {
        panel.setCursor(hndCursor);
        pp.setLocation(e.getPoint());
    }

    public void mouseReleased(MouseEvent e)
    {
        panel.setCursor(defCursor);
        panel.repaint();
    }
}

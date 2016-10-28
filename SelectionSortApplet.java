 /* 
  * Questo applet anima l'algoritmo di ordinamento per selezione
  */


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
/**
 *
 * @author massimiliano
 */
public class SelectionSortApplet extends Applet {
    /*Costruisco l'applet e imposto il gestore del mouse
    * premendo il pulsante del mouse sull'area di visualizzazione
    * dell'applet si fa partire l'animazione
    */
    public SelectionSortApplet()
    {
        class MousePressListener extends MouseAdapter
        {
            public void mousePressed(MouseEvent event)
            {
                if (animation != null && animation.isAlive())
                    animation.interrupt();
                startAnimation();
            }
        }
        
        MouseListener listener = new MousePressListener();
        addMouseListener(listener);
        setBackground(Color.lightGray);
        sorter = null;
        animation = null;
    }
    
    public void paint(Graphics g)
    {
        if (sorter == null) return;
        Graphics2D g2 = (Graphics2D) g;
        sorter.draw(g2);
    }
    
    /*
     *inizio un nuovo thread di animazione
     */
    public void startAnimation()
    {
        class AnimationThread extends Thread
        {
            public void run()
            {
                try
                {
                    sorter.sort();
                }
                catch (InterruptedException exception)
                {
                    //se si blocca non fare niente e termina il thread
                }
            }
        }
        
        int[] values = ArrayUtil.randomIntArray(30,300);
        sorter = new SelectionSorter(values, this);
        animation = new AnimationThread();
        animation.start();
    }
    
    private SelectionSorter sorter;
    private Thread animation;
}
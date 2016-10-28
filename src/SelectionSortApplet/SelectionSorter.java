/*
 * Questa classe ordina un array usando l'algoritmo di ordinamento
 * per selezione.
 */
package SelectionSortApplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
/**
 *
 * @author massimiliano
 */
public class SelectionSorter {
    /**
     * Costruisco un ordinatore per selezione.
     * anArray --> array da ordinare
     * anApplet --> l'applet che effettua l'animazione
     */
    public SelectionSorter(int[] anArray, Applet anApplet)
    {
        a = anArray;
        applet = anApplet;
    }
    
    /**
     * Ordino l'array gestito da questo ordinatore per selezione
     */
    public void sort() throws InterruptedException
    {
        for (int i = 0; i < a.length - 1; i++)
        {
           int minPos = minimumPosition(i);
           swap(minPos, i);
           // per l’animazione
           alreadySorted = i;
           pause(2); 
        }
    }
    
    /**
     * Cerco l'elemento minore in una coda dell'array
     * prametro from --> prima posizione da considerare nell'array a
     * return --> posizione dell'elemento minore nella coda a[from]....a[a.length-1]
     */
    private int minimumPosition(int from) throws InterruptedException
    {
        int minPos = from;
        for (int i = from + 1; i < a.length; i++)
        {
            if (a[i] < a[minPos]) minPos = i;
            // per l'animazione
            markedPosition = i;
            pause(2);
        }
        return minPos;
    }
    
    /**
     * Scambio due elementi dell'array.
     * i --> prima posizione da scambiare
     * j --> seconda posizione da scambiare
     */
    private void swap(int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    /**
     * Disegno lo stato attuale dell'algoritmo di ordinamento.
     * g2 --> contesto grafico
     */
    public void draw(Graphics2D g2)
    {
        int deltaX = applet.getWidth() / a.length;
        for (int i = 0; i < a.length; i++)
        {
            if (i == markedPosition)
                g2.setColor(Color.red);
            else if (i <= alreadySorted)
                g2.setColor(Color.blue);
            else
                g2.setColor(Color.black);
            g2.draw(new Line2D.Double(i * deltaX, 0, i * deltaX, a[i]));
        }
    }
    /**
     * Inserisco una pausa nell'animazione
     * steps --> numero di passi di durata della pausa
     */
    public void pause(int steps) throws InterruptedException
    {
        if (Thread.currentThread().isInterrupted())
            throw new InterruptedException();
        applet.repaint();
        Thread.sleep(steps * DELAY);
    }
    
    private int[] a;
    
    //l'applet serve per mettere in pausa l'animazione
    private Applet applet;
    
    //variabili per disegnare
    private int markedPosition = -1;
    private int alreadySorted = -1;
    private static final int DELAY = 100;
}

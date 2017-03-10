package org.compgraf.transgeom.data;

/**
 * Clase que permite manejar matrices de 4x4 y permite hacer operaciones sobre
 * cuerpos 3D.
 *
 * @author 
 */
public class Matriz
{

    double valores[][];

    /**
     * Constructor de una Matriz de 4x4
     */
    //<editor-fold defaultstate="collapsed" desc="Constructor :: Matriz ()">
    public Matriz()
    {
        valores = new double[4][4];
    }
    //</editor-fold>

    /**
     * Metodo que permite asignar un valor en la matriz
     *
     * @param fila indice de la fila
     * @param columna indice de la columna
     * @param valor valor a asignar
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void set (int, int, double)">
    public void set(int fila, int columna, double valor)
    {
        valores[fila][columna] = valor;
    }
    //</editor-fold>

    /**
     * Metodo que permite obtener un valor de la matriz
     *
     * @param fila indice de la fila
     * @param columna indice de la columna
     * @return valor correspondiente a la casilla de la matriz
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: double get (int, int)">
    public double get(int fila, int columna)
    {
        return valores[fila][columna];
    }
    //</editor-fold>

    /**
     * Metodo que hace la conversion de valores de la matriz a un String con
     * forma de matriz
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: String toString ()">
    @Override
    public String toString()
    {
        StringBuilder cad = new StringBuilder();

        for (int i = 0; i < 4; i++)
        {
            cad.append( "|");
            for (int j = 0; j < 4; j++)
            {
                cad.append( String.format(" %5.1f", valores[i][j]));
            }
            cad.append( "|\n");
        }

        return cad.toString();
    }
    //</editor-fold>

}

package org.compgraf.transgeom.util;

import javafx.geometry.Point3D;
import org.compgraf.transgeom.data.Matriz;

/**
 * En esta clase se definen las operaciones sobre matrices que permiten realizar transformaciones sobre los cuerpos
 * @author 
 */
public class OperacionesMatrices
{
    /**
     * Metodo que crea una matriz identidad
     *
     * @return matriz identidad
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz identidad ()">
    public static Matriz identidad()
    {
        Matriz m = new Matriz();

        for (int i = 0; i < 4; i++)
        {
            m.set(i, i, 1);
        }

        return m;
    }
    //</editor-fold>

    /**
     * Metodo que crea una matriz de translacion en un sistema 3D
     *
     * @param dx Delta del movimiento en x
     * @param dy Delta del movimiento en y
     * @param dz Delta del movimiento en z
     * @return matriz de translacion
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz translacion (double, double, double)">
    public static Matriz translacion(double dx, double dy, double dz)
    {
        Matriz m = identidad();

        m.set(0, 3, dx);
        m.set(1, 3, dy);
        m.set(2, 3, dz);

        return m;
    }
    //</editor-fold>

    /**
     * Metodo que crea una matriz de escalacion para en un sistema 3D
     *
     * @param sx Factor de esclacion en x
     * @param sy Factor de esclacion en y
     * @param sz Factor de esclacion en z
     * @return matriz de escalacion
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz escalacion (double, double, double)">
    public static Matriz escalacion(double sx, double sy, double sz)
    {
        Matriz m = identidad();

        m.set(0, 0, sx);
        m.set(1, 1, sy);
        m.set(2, 2, sz);

        return m;
    }
    //</editor-fold>

    /**
     * Metodo que crea una matriz de rotacion sobre el eje x en un sistema 3D
     *
     * @param theta Angulo en grados que se quiere rotar
     * @return matriz de rotacion sobre el eje x
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz rotacion_x (double)">
    public static Matriz rotacion_x(double theta)
    {
        Matriz m = identidad();

        double angle = Math.toRadians(theta);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        m.set(1, 1, cos);               // |  1  0  0  0 |
        m.set(2, 2, cos);               // |  0  c -s  0 |
        m.set(1, 2, -sin);              // |  0  s  c  0 |
        m.set(2, 1, sin);               // |  0  0  0  1 |

        return m;
    }
    //</editor-fold>

    /**
     * Metodo que crea una matriz de rotacion sobre el eje y en un sistema 3D
     *
     * @param theta Angulo en grados que se quiere rotar
     * @return matriz de rotacion sobre el eje y
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz rotacion_y (double)">
    public static Matriz rotacion_y(double theta)
    {
        Matriz m = identidad();

        double angle = Math.toRadians(theta);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        m.set(0, 0, cos);               // |  c  0  s  0 |
        m.set(2, 2, cos);               // |  0  1  0  0 |
        m.set(0, 2, sin);               // | -s  0  c  0 |
        m.set(2, 0, -sin);              // |  0  0  0  1 |

        return m;
    }
    //</editor-fold>

    /**
     * Metodo que crea una matriz de rotacion sobre el eje z en un sistema 3D
     *
     * @param theta Angulo en grados que se quiere rotar
     * @return matriz de rotacion sobre el eje z
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz rotacion_z (double)">
    public static Matriz rotacion_z(double theta)
    {
        Matriz m = identidad();

        double angle = Math.toRadians(theta);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        m.set(0, 0, cos);               // |  c -s  s  0 |
        m.set(1, 1, cos);               // |  s  c  0  0 |
        m.set(0, 1, -sin);              // |  0  0  1  0 |
        m.set(1, 0, sin);               // |  0  0  0  1 |

        return m;
    }
    //</editor-fold>

    /**
     * Metodo que realiza una multiplicacion de una matriz y un punto 3D
     *
     * @param m Matriz con la que se quiere multiplicar
     * @param p Punto a multiplicar con la matriz
     * @return Punto transformado
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz multiplicacion (Matriz, Point3D)">
    public static Point3D multiplicacion(Matriz m, Point3D p)
    {
        double x = m.get(0,0) * p.getX() + m.get(0,1) * p.getY() + m.get(0,2) * p.getZ() + m.get(0,3);
        double y = m.get(1,0) * p.getX() + m.get(1,1) * p.getY() + m.get(1,2) * p.getZ() + m.get(1,3);
        double z = m.get(2,0) * p.getX() + m.get(2,1) * p.getY() + m.get(2,2) * p.getZ() + m.get(2,3);

        return new Point3D(x, y, z);
    }
    //</editor-fold>

    /**
     * Metodo que realiza una multiplicacion entre dos matrices.
     *
     * @param m Primera matriz
     * @param n Segunda matriz
     * @return Matriz resultante
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Matriz multiplicacion (Matriz, Matriz)">
    public static Matriz multiplicacion(Matriz m, Matriz n)
    {
        Matriz r = new Matriz();
        
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                double aux = 0;
                for (int k = 0; k < 4; k++)
                {
                    aux += m.get(i, k) * n.get(k, j);
                }
                r.set(i, j, aux);
            }
        }
        
        return r;
    }
    //</editor-fold>
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berzerk;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
    int Distancia[]=new int[10]; 
    int costo[][]=new int[10][10];
    
    public void CalcularRuta(int nNodos,int vOrigen)
    {
        int[] vecBanderas = new int[nNodos+1];
        int i,minpos=1,k,c,minimo;
        for (i = 0; i <= nNodos; i++)
        {
            vecBanderas[i]=0;
            this.Distancia[i]=this.costo[vOrigen][i];
        }
        c=2;
        while(c<=nNodos)
        {
            minimo=99;
            for (k = 1; k<=nNodos; k++) 
            {
                if (this.Distancia[k]<minimo && vecBanderas[k]!=1)
                {
                    minimo= this.Distancia[i];
                    minpos=k;
                }
            }
            vecBanderas[minpos]=1;
            for (k = 1;  k<= nNodos; k ++)
            {
                if (this.Distancia[minpos]+this.costo[minpos][k] <
                        this.Distancia[k]&& vecBanderas[k]!=1) 
                {
                    this.Distancia[k]=this.Distancia[minpos]+
                            this.costo[minpos][k];
                } 
            }
        c++;
        }
    }
    
    public static void main(String[] args) 
    {
        int nroNodos, vertInicial,i,j;
        Scanner in= new Scanner(System.in);
        System.out.println("Ingrese el numero de nodos: \n");
        nroNodos = in.nextInt();
        Dijkstra d = new Dijkstra();
        System.out.println("Ingrese la matriz de pesos por fila, " 
                + "searando los valores con un espacio " 
                + "y presinando enter para ingresar otra fila;\n"
                + "s: \n");
                for (i = 1; i <= nroNodos; i++)
                    {
                        for (j = 1; j <= nroNodos; j++)
                        {
                            d.costo[i][j]=in.nextInt();
                            if (d.costo[i][j]==0)
                            {
                                d.costo[i][j]=999;
                            }
                        }
                    }
                System.out.println("Ingrese el vertice origen :\n");
                vertInicial=in.nextInt();                
                d.CalcularRuta(nroNodos,vertInicial);                
                System.out.println("Los caminos para cortos desde el vertice \t"
                                    +vertInicial+"\t a los otros vertices es: \n");
                for (i = 1; i <= nroNodos ; i++)
                {
                    if (i != vertInicial)
                    {
                        System.out.println("Origen :"+vertInicial+"\t Destino:"+i+
                                "\t Costo minimo:"+d.Distancia[i]+"\t");
                    }
                }
    }
}

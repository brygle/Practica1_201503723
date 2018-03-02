/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1practica1_201503723;

/**
 *
 * @author Bryan
 */
public class Tablero {
    int dificultad;
    int filas;
    int columnas;
    int subidasMin;
    int subidasMax;
    int subidas;
    int bajadasMin;
    int bajadasMax;
    int bajadas;
    String matriz [][] = null;

    public Tablero(int dificultad) {
        if(dificultad == 1){
            this.subidasMin = 5;
            this.subidasMax = 10;
            this.bajadasMin = 5;
            this.bajadasMax = 10;
            this.filas = 5;
            this.columnas = 8;
            this.dificultad = dificultad;
            this.matriz = new String [this.filas][this.columnas];
        }else if(dificultad == 2){
            this.subidasMin = 20;
            this.subidasMax = 40;
            this.bajadasMin = 20;
            this.bajadasMax = 40;
            this.filas = 20;
            this.columnas = 10;
            this.dificultad = dificultad;
            this.matriz = new String [this.filas][this.columnas];
        }
    }

    public String getMatriz(int i, int j) {
        return matriz[i][j];
    }

    public void setMatriz(int i, int j, String textoNuevo) {
        this.matriz[i][j] = textoNuevo;
    }
    
    

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getSubidasMin() {
        return subidasMin;
    }


    public int getSubidasMax() {
        return subidasMax;
    }

    public int getSubidas() {
        return subidas;
    }

    public void setSubidas(int subidas) {
        this.subidas = subidas;
    }

    public int getBajadasMin() {
        return bajadasMin;
    }

    public int getBajadasMax() {
        return bajadasMax;
    }

    public int getBajadas() {
        return bajadas;
    }

    public void setBajadas(int bajadas) {
        this.bajadas = bajadas;
    }
    
    public void asignarNumeroCelda(){
        int contador =1;
        int i, j;
        for(i = 0; i < this.filas ; i++){
            for(j=0; j<this.columnas;j++){
                if(contador<10){
                    matriz[i][j]="[         "+contador+"]";
                }else if(contador>=10&&contador<100){
                    matriz[i][j]="[        "+contador+"]";
                }else{
                    matriz[i][j]="[       "+contador+"]";
                }
                
                if(j==this.columnas-1){
                    if(this.dificultad==1){
                        contador+=8;
                    }else{
                        contador+=10;
                    }     
                }else{
                    if(i%2==0){
                        contador++;
                    }else{
                        contador--;
                    }
                }
            }
        }
    }
    
    public void imprimirMatriz(){
        System.out.println("");
        int i , j;
        for(i = this.filas-1;i>=0;i--){
            for(j = 0 ; j<this.columnas;j++){
                System.out.print(this.matriz[i][j]);
            
            }
            System.out.println("");
        }
    
    }
    
    
    
    
}

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
public class Usuario {

    String caracterUsuario;
    int fila;
    int columna;
    int random;
    int contador;

    public Usuario(String caracterUsuario) {
        this.caracterUsuario = caracterUsuario;
        this.fila = 0;
        this.columna = 0;
        this.contador = 1;
    }

    public String getCaracterUsuario() {
        return caracterUsuario;
    }

    public void setCaracterUsuario(String caracterUsuario) {
        this.caracterUsuario = caracterUsuario;
    }

    public int getFila() {
        return fila;
    }

    public void setFilaColumna(int random, int dificultad) {
        int posicion = contador + random;
        if (dificultad == 1) {
            while (contador <= posicion) {
                if (fila % 2 == 0) {
                    columna++;
                } else {
                    columna--;
                }
                if (columna == 8 && fila % 2 == 0) {
                    fila++;
                    columna--;
                }
                if (columna == -1 && fila % 2 != 0) {
                    fila++;
                    columna++;
                }
                contador++;
            }
            if (fila % 2 == 1 && columna == 7) {
                fila--;
                contador--;
            } else if ((fila == 2 || fila == 4) && columna == 0) {
                fila--;
                contador--;
            } else if (fila % 2 == 0) {
                columna--;
                contador--;
            } else if (fila % 2 != 0) {
                columna++;
                contador--;
            }

        } else if (dificultad == 2) {
            while (contador <= posicion) {
                if (fila % 2 == 0) {
                    columna++;
                } else {
                    columna--;
                }
                if (columna == 10 && fila % 2 == 0) {
                    fila++;
                    columna--;
                }
                if (columna == -1 && fila % 2 != 0) {
                    fila++;
                    columna++;
                }
                contador++;
            }
            if (fila % 2 == 1 && columna == 9) {
                fila--;
                contador--;
            } else if ((fila > 0 && fila % 2 == 0) && columna == 0) {
                fila--;
                contador--;
            } else if (fila % 2 == 0) {
                columna--;
                contador--;
            } else if (fila % 2 != 0) {
                columna++;
                contador--;
            }

        }

    }

    public void setFilaColumnaNegativo(int random, int dificultad) {
        int posicion = contador - random;
        this.contador = 1;
        this.fila = 0;
        this.columna = 0 ;
        if (dificultad == 1) {
            while (contador <= posicion) {
                if (fila % 2 == 0) {
                    columna++;
                } else {
                    columna--;
                }
                if (columna == 8 && fila % 2 == 0) {
                    fila++;
                    columna--;
                }
                if (columna == -1 && fila % 2 != 0) {
                    fila++;
                    columna++;
                }
                contador++;
            }
            if (fila % 2 == 1 && columna == 7) {
                fila--;
                contador--;
            } else if ((fila == 2 || fila == 4) && columna == 0) {
                fila--;
                contador--;
            } else if (fila % 2 == 0) {
                columna--;
                contador--;
            } else if (fila % 2 != 0) {
                columna++;
                contador--;
            }

        } else if (dificultad == 2) {
            while (contador <= posicion) {
                if (fila % 2 == 0) {
                    columna++;
                } else {
                    columna--;
                }
                if (columna == 10 && fila % 2 == 0) {
                    fila++;
                    columna--;
                }
                if (columna == -1 && fila % 2 != 0) {
                    fila++;
                    columna++;
                }
                contador++;
            }
            if (fila % 2 == 1 && columna == 9) {
                fila--;
                contador--;
            } else if ((fila > 0 && fila % 2 == 0) && columna == 0) {
                fila--;
                contador--;
            } else if (fila % 2 == 0) {
                columna--;
                contador--;
            } else if (fila % 2 != 0) {
                columna++;
                contador--;
            }

        }
        

    }

    public int getColumna() {
        return columna;
    }

    public int getRandom(int dificultadJuego) {
        if (dificultadJuego == 1) {
            random = (int) (Math.random() * 6) + 1;
        } else {
            random = (int) (Math.random() * 12) + 1;
        }
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

}

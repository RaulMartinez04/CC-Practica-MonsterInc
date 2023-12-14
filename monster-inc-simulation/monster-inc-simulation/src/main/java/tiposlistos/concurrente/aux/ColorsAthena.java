package com.monstersinc.aux;

/**
 * Clase que permite pintar las letras de la consola
 * 
 * @author Israel Villanueva Garcia.
 * @version 1.0, Enero 2020.
 * @since Estructuras de datos 2021-1.
 */

public class ColorsAthena {

  // **Delimitador de colores para la consola */
  private static String b = "\u001B[0m";

  /** Colores de letras para consola */
  private final static String NEGRO = "\033[30m";
  private final static String ROJO = "\033[31m";
  private final static String VERDE = "\033[32m";
  private final static String AMARILLO = "\033[33m";
  private final static String AZUL = "\033[34m";
  private final static String MAGENTA = "\033[35m";
  private final static String CELESTE = "\033[36m";
  private final static String BLANCO = "\033[37m";

  // **Colores de fondo para consola */
  private final static String fROJO = "\033[41m";
  private final static String fVERDE = "\033[42m";
  private final static String fAMARILLO = "\033[43m";
  private final static String fAZUL = "\033[44m";
  private final static String fMAGENTA = "\033[45m";
  private final static String fCELESTE = "\033[46m";
  private final static String fGRIS = "\033[47m";

  /**
   * Metodo que permite pintar un String de principio a fin de color Rojo.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String rojo(String frase) {
    return b + ROJO + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Negro.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String negro(String frase) {
    return b + NEGRO + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Verde.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String verde(String frase) {
    return b + VERDE + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Amarillo.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String amarillo(String frase) {
    return b + AMARILLO + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Azul.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String azul(String frase) {
    return b + AZUL + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Magenta.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String magenta(String frase) {
    return b + MAGENTA + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Celeste.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String celeste(String frase) {
    return b + CELESTE + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Blanco.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String blanco(String frase) {
    return b + BLANCO + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Rojo.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fRojo(String frase) {
    return b + fROJO + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Negro.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fGris(String frase) {
    return b + fGRIS + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Verde.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fVerde(String frase) {
    return b + fVERDE + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Amarillo.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fAmarillo(String frase) {
    return b + fAMARILLO + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Azul.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fAzul(String frase) {
    return b + fAZUL + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Magenta.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fMagenta(String frase) {
    return b + fMAGENTA + frase + b;
  }

  /**
   * Metodo que permite pintar un String de principio a fin de color Celeste.
   * 
   * @param frase String a pintar
   * @param color Color a pintar dentro de la misma clase.
   * @return Regresa el String pintado.
   */
  public static String fCeleste(String frase) {
    return b + fCELESTE + frase + b;
  }
}
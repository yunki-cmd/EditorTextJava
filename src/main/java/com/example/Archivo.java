package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
  
  private File archivo;
  /**
   * construye un objecto de la clase archivo
   * @param rutaArchivo
   */
  public Archivo(String rutaArchivo) {
    archivo = new File(rutaArchivo);
  }
  /**
   * 
   * @return
   * @throws IOException
   */
  public String darContenido() throws IOException {
    // hay que cerrar flujos para otros procesos
    String contenido = "";
    FileReader file = new FileReader(archivo);
    BufferedReader bf = new BufferedReader(file);
    String linea = bf.readLine();
    while (linea != null) {
      contenido += linea + "\n";
      linea = bf.readLine();
    }
    // aca se cierra los flujos
    bf.close();
    file.close();
    return contenido;
  }
  
  /**
   * guardar el contenido en un archivo nuevo o existente
   * @param contenido que tiene el contenido para guardar
   * @throws IOException excepcione a los errores
   */

  public void save(String contenido) throws IOException {
    PrintWriter pw = new PrintWriter(archivo);
    pw.write(contenido);
    pw.close();
  }


}

package com.example;
import java.io.IOException;

import com.example.Archivo;
public class Editor {
  
  private Archivo archivo;
  // el editor puede abrir archivos existentes, crear nuevos archivos y guardar archivos
  /**
   * construye un objecto de la clase Editor
   */
  public Editor() {
    this.archivo = null;
  }


  
  public String openFile(String rutaArchivo) throws Exception{
    String contenido = "";
    archivo = new Archivo(rutaArchivo);
    try {
      contenido = archivo.darContenido();
    } catch (IOException e) {
      throw new Exception("Error leyendo el archivo",e);
    }
    return contenido;
  }
    
  public void newFile() {
    this.archivo = null;
  }
  
  public void saveFile(String contenido, String rutaArchivo) throws Exception {
    if (archivo == null) {
      archivo = new Archivo(rutaArchivo);
    }
    try {
      archivo.save(contenido);
    } catch (Exception e) {
      throw new Exception("error de guardado",e);
    }
  }
  /**/
  
  public boolean esnuevo() {
	  return archivo == null;
  }


}

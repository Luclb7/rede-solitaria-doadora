package repository;

import java.io.*;

public class PersistenciaJson {

 public static void salvar(String json,String arquivo){
   try(FileWriter fw=new FileWriter(arquivo)){ fw.write(json); } catch(Exception e){}
 }
 public static String carregar(String arquivo){

   try{
    return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(arquivo)));

   }catch(Exception e){ return ""; }
 }
}

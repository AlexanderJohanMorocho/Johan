package net.osgg.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.StringTokenizer;

/** Assumes UTF-8 encoding. JDK 7+. */
public final class ReadWithTokenizer {
  
  /**
   Constructor.
   @param fileName full name of an existing, readable file.
  */
  public ReadWithTokenizer(String fileName){
    filePath = Paths.get(fileName);
  }
  
  /** Template method that calls {@link #processLine(String)}. */
  public final void processLineByLine() throws IOException {
      try (BufferedReader reader = Files.newBufferedReader(filePath, ENCODING)){
          String line;
          while ((line = reader.readLine()) != null){
              processLine(line);
          }      
      }
  }
  
  
  /** 
   Overridable method for processing lines in different ways.
    
   <P>This simple default implementation counts the occurrences of the words "alto", "viva", "persona", and "cielo".
  */
  protected void processLine(String line){
	    //use a StringTokenizer to tokenize the line
	    StringTokenizer tokenizer = new StringTokenizer(line, " .,!?");
	    while (tokenizer.hasMoreTokens()) {
	        String word = tokenizer.nextToken().toLowerCase();
	        // Limpiar la palabra de caracteres especiales
	        word = word.replaceAll("[^a-zA-Z0-9]", "");
	        switch (word) {
	            case "alto":
	                altoCount++;
	                break;
	            case "viva":
	                vivaCount++;
	                break;
	            case "persona":
	                personaCount++;
	                break;
	            case "cielo":
	                cieloCount++;
	                break;
	            default:
	                break;
	        }
	    }
	}

  
  // PRIVATE 
  private final Path filePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;
  private int altoCount = 0;
  private int vivaCount = 0;
  private int personaCount = 0;
  private int cieloCount = 0;

  private static void log(Object object){
    System.out.println(Objects.toString(object));
  }

  public void printWordCounts() {
    log("Numero de veces que aparece 'alto': " + altoCount);
    log("Numero de veces que aparece 'viva': " + vivaCount);
    log("Numero de veces que aparece 'persona': " + personaCount);
    log("Numero de veces que aparece 'cielo': " + cieloCount);
  }

}

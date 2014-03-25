package test.log4j;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.*;

public class Log4jTest{
  /* Get actual class name to be printed on */
  static Logger log = Logger.getLogger(Log4jTest.class.getName());

  public static void main(String[] args) throws IOException{   
     log.debug("Hello this is an debug message");
     log.info("Hello this is an info message");
     log.warn("Hello");
  }
}
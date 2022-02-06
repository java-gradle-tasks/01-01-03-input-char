import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TestPrintChar {

   @Test
   public void test() {

      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      String answer="k";

      String input=String.valueOf(answer)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyExit.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String actual=byteArrayOutputStream.toString();

      boolean found=actual.contains(input);

      Assertions.assertTrue(found,"Nem írta ki a képernyőre a bekért számot!");
   }
}

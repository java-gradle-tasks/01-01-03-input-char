   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.ByteArrayInputStream;
   import java.io.ByteArrayOutputStream;
   import java.io.InputStream;
   import java.io.PrintStream;

   public class TestInput {

      @Test
      public void testInput() {

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

         String outStream="Szeretne kilepni (k - kilepes):";
         String expected=outStream;

         String actual=byteArrayOutputStream.toString();

         boolean found=actual.contains(expected);

         Assertions.assertTrue(found,"Hianyzik az input a kodbol!");
      }
   }

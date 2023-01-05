import java.util.random.RandomGenerator;
import java.util.random.RandomGenerator.JumpableGenerator;

public class Main {
    public static void main(String[] args) {
        var html="""
        <!DOCTYPEHTML>
        <html>
         <head>
            <meta charset="utf-8" />
            <title>Text Block feature demo</title>
         </head>
           <body>
             <h1>%d items created with the following names:</h1>
             <h1>%s</h1>
           </body>
         </html>
         """;

        String result = html.formatted(100, "HELLLOOOO");

        System.out.println(html);

        System.out.println(result);

        JumpableGenerator  random =
                RandomGenerator.JumpableGenerator.of("Xoroshiro128PlusPlus");

    }
}
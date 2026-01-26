import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> numbers = List.of(1,2,3,4,5,6,7);

        long start = System.currentTimeMillis();


        long end = System.currentTimeMillis();
        System.out.println("Tiempo total (secuencial): " + (end - start) + " ms");
    }
}

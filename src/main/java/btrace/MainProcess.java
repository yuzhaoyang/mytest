package btrace;


import java.io.IOException;

public class MainProcess {
    public static void main(String[] args) throws IOException {


        while (true) {

            try {
                Thread.sleep(1000);

                SubProcess1 test = new SubProcess1();

                test.test1();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
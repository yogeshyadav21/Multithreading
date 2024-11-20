package org.example.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;


// This class is used to implement the CyclicBarrier concept in the java.
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()-> System.out.println("All runners have reached the checkpoint"));

    public CyclicBarrierTest() {
    }

    public void start(){
        for(int i = 1; i <= 3; i++){
            int finalI = i;
            new Thread(()->{
                for(int j = 1; j <= 3; j++){
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Runner " + finalI + " reached the " + j + "th checkpoint");
                    try{
                        cyclicBarrier.await();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

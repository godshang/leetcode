package q1115_print_foobar_alternately;

public class FooBar {

    private int n;
    private volatile boolean printFooFlag = true;
    private Object monitor = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            
            synchronized (monitor) {
                while (!printFooFlag) {
                    monitor.wait();
                }
                printFoo.run();
                printFooFlag = false;
                monitor.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            
            synchronized (monitor) {
                while (printFooFlag) {
                    monitor.wait();
                }
                printBar.run();
                printFooFlag = true;
                monitor.notifyAll();
            }
        }
    }
}

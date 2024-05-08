

public class QueueMain {
    public static void main(String[] args) {
        // Create an empty list
        StringQueue queue = new StringQueueImpl();


            // Print empty list
            queue.printQueue(System.out);

            // Add 3 elements at top
            queue.put("hello");

            queue.put("world");

            queue.put("!!!");

            queue.put("wrong");
            queue.printQueue(System.out);


            // Remove from top
            String removed = queue.get(); 
            System.out.println(removed + " just got removed...");
            //stack.printStack(System.out);

            String removed2 = queue.get();
            System.out.println(removed2 + " just got removed...");
            queue.printQueue(System.out);

            String notremoved = queue.peek();
            System.out.println(notremoved + " peeked not removed...");
            queue.printQueue(System.out);

            System.out.println(queue.size() + " is the size...");


            /* 
            // keep removing until an exception is thrown
            System.out.println("Keep removing from list!");
            // 100 in case something goes wrong, to prevent endless loop
            for (int i = 0; i < 100; ++i) {
                removed = list.removeFromFront();
                System.out.println(removed + " just got removed...");

                removed = list.removeFromBack();
                System.out.println(removed + " just got removed...");
            }

             */

    }
}
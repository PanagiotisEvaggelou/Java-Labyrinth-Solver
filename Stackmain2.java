

public class Stackmain2 {
    public static void main(String[] args) {
        // Create an empty list
        StackInter<Video> stack = new Stack<>();


            // Print empty list
            stack.printStack(System.out);

            // Add 3 elements at top
            stack.push(new Video("Η οικονομία της προσοχής", "https://www.youtube.com/watch?v=sQXubDsT9zs", 126223));

            stack.push(new Video("\"You do NOT understand weddings. AT ALL.\"", "https://www.youtube.com/watch?v=p6ZojleXMn4", 3995738));

            stack.push(new Video("Golden Retriever can't get enough of Australian Open tennis", "https://www.youtube.com/watch?v=kZm6RwukFCc", 1235033));

            stack.push(new Video("Dog on a Roomba - Easter Edition!!!", "https://www.youtube.com/watch?v=MLS0ExHWbiA", 618801));
            stack.printStack(System.out);


            // Remove from top
            Video removed = stack.pop();
            System.out.println(removed.getTitle() + " just got removed...");
            //stack.printStack(System.out);

            Video removed2 = stack.pop();
            System.out.println(removed2.getTitle() + " just got removed...");
            stack.printStack(System.out);

            Video notremoved = stack.peek();
            System.out.println(notremoved.getTitle() + " peeked not removed...");
            stack.printStack(System.out);

            System.out.println(stack.size() + " is the size...");


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
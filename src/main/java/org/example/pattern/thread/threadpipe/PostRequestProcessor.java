package org.example.pattern.thread.threadpipe;

import java.util.concurrent.LinkedBlockingQueue;

public class PostRequestProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    public void setNextProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Request request = queue.take();

                request.setName(request.getName() + "-> PostRequestProcessor");
                System.out.println(request.getName());

//                nextProcessor.process(request);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Request request) {
        this.queue.add(request);
    }
}

package org.example.pattern.thread.threadpipe;

import java.util.concurrent.LinkedBlockingQueue;

public class PreRequestProcessor extends Thread implements IRequestProcessor {

    private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    public void setNextProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {
        this.queue.add(request);
    }

    @Override
    public void run() {
        while (true) {

            try {
                Request request = queue.take();

                request.setName(request.getName() + "-> PreRequestProcessor");
                System.out.println(request.getName());

                this.nextProcessor.process(request);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

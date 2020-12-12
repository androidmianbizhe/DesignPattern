package org.example.pattern.thread;

import org.example.pattern.thread.threadpipe.PostRequestProcessor;
import org.example.pattern.thread.threadpipe.PreRequestProcessor;
import org.example.pattern.thread.threadpipe.Request;

public class ThreadPipeDemo {

    private PreRequestProcessor preRequestProcessor;

    public ThreadPipeDemo() {

        PostRequestProcessor postRequestProcessor = new PostRequestProcessor();
        postRequestProcessor.start();

        preRequestProcessor = new PreRequestProcessor();
        preRequestProcessor.setNextProcessor(postRequestProcessor);

        preRequestProcessor.start();

    }

    public static void main(String[] args) {

        Request request = new Request();
        request.setName("Processor request");

        ThreadPipeDemo threadPipeDemo = new ThreadPipeDemo();
        threadPipeDemo.doProcess(request);
    }

    private void doProcess(Request request) {
        preRequestProcessor.process(request);
    }
}

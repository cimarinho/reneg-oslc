package br.com.reneg.lista.processor.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProcessorLista {

    String SAMPLE = "lista";

    @Input(SAMPLE)
    SubscribableChannel sampleSink();

    String OUTPUT = "simulacao";

    @Output("simulacao")
    MessageChannel output();


}
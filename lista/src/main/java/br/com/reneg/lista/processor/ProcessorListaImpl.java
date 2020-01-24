package br.com.reneg.lista.processor;


import br.com.reneg.lista.model.OlscResponse;
import br.com.reneg.lista.processor.interfaces.ProcessorLista;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
@EnableBinding({ProcessorLista.class})
public class ProcessorListaImpl {

    @StreamListener(ProcessorLista.SAMPLE)
    @SendTo(ProcessorLista.OUTPUT)
    public OlscResponse process(OlscResponse olscResponse) {
        log.info("lista " +olscResponse);
        olscResponse.setNumeroJornada(1L);
        olscResponse.setDataJornada(LocalDate.now());
        log.info("lista "+olscResponse);
        return olscResponse;
    }
}
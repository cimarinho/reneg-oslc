package br.com.reneg.jornada.processor;


import br.com.reneg.jornada.model.OlscResponse;
import br.com.reneg.jornada.processor.interfaces.ProcessorJornada;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@SpringBootApplication
@EnableBinding({ProcessorJornada.class})
public class ProcessorJornadaImpl {

    @StreamListener(ProcessorJornada.SAMPLE)
    @SendTo(ProcessorJornada.OUTPUT)
    public OlscResponse process(OlscResponse olscResponse) {
        log.info("Jornada "+olscResponse);
        olscResponse.setNumeroJornada(1L);
        System.out.printf("Jornada olscResponse=%s\n", olscResponse);
        log.info("Jornada "+olscResponse);
        return olscResponse;
    }
}
package br.com.reneg.simulacao.processor;


import br.com.reneg.simulacao.model.OlscResponse;
import br.com.reneg.simulacao.processor.interfaces.ProcessorSimulacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@SpringBootApplication
@EnableBinding({ProcessorSimulacao.class})
public class ProcessorSimulacaoImpl {

    @StreamListener(ProcessorSimulacao.SAMPLE)
    @SendTo(ProcessorSimulacao.OUTPUT)
    public OlscResponse process(OlscResponse olscResponse) {
        log.info("Simulacao "+olscResponse);
        olscResponse.setValor(113.44);
        log.info("Simulacao "+olscResponse);
        return olscResponse;
    }
}
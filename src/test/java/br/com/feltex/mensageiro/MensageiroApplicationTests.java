package br.com.feltex.mensageiro;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.feltex.mensageiro.mensageiro.Usuario;
import br.com.feltex.mensageiro.mensageiro.UsuarioMensagemConfig;

@SpringBootTest
class MensageiroApplicationTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void produzirMensagem() {
        var usuario = new Usuario("Sistema distribuido", "2242-33441", "distribuicao@gmail.com.br");
        rabbitTemplate.convertAndSend(UsuarioMensagemConfig.NOME_EXCHANGE, UsuarioMensagemConfig.ROUTING_KEY,
                usuario);
    }

}

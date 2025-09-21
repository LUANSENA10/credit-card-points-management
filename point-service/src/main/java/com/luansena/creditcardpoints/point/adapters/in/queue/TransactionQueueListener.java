package com.luansena.creditcardpoints.point.adapters.in.queue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luansena.creditcardpoints.point.domain.model.CardType;
import com.luansena.creditcardpoints.point.domain.ports.in.PointsServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class TransactionQueueListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionQueueListener.class);

    private final PointsServicePort pointsService;

    public TransactionQueueListener(PointsServicePort pointsService) {
        this.pointsService = pointsService;
    }

    @RabbitListener(queues = "${spring.transaction.authorized.queue}")
    public void handleTransactionAuthorized(TransactionMessage message) {

        try {

            logger.info("Mensagem recebida da fila: {}", message);
            pointsService.addPoints(message.cardId(), CardType.valueOf(message.cardType), message.amount());
            logger.info("Pontos processados com sucesso para o cartão ID: {}", message.cardId());
        } catch (Exception e) {
            logger.error("Erro ao processar mensagem para o cartão ID: {}. Erro: {}", message.cardId(), e.getMessage(), e);
        }

    }


    public record TransactionMessage(Long cardId, String cardType, BigDecimal amount) {
        public TransactionMessage(@JsonProperty("cardId") Long cardId,
                                  @JsonProperty("cardType") String cardType,
                                  @JsonProperty("amount") BigDecimal amount) {
            this.cardId = cardId;
            this.cardType = cardType;
            this.amount = amount;
        }
    }

}

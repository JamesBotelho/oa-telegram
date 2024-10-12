package dev.jamesbotelho.oatelegram.event;

import dev.jamesbotelho.oatelegram.model.MessageDTO;
import dev.jamesbotelho.oatelegram.service.TelegramService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

@Component
@RequiredArgsConstructor
public class MessageEventHub {

  private final TelegramService service;

  @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void receive(ConsumerRecord<String, MessageDTO> record) {
    service.sendMessage(record.value()).subscribeOn(Schedulers.boundedElastic()).subscribe();
  }
}

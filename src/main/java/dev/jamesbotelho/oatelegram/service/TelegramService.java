package dev.jamesbotelho.oatelegram.service;

import dev.jamesbotelho.oatelegram.client.TelegramClient;
import dev.jamesbotelho.oatelegram.model.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TelegramService {
  private final TelegramClient client;

  public Mono<Void> sendMessage(MessageDTO message) {
    return client.sendMessage(message.text()).then();
  }
}

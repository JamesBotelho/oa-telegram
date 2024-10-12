package dev.jamesbotelho.oatelegram.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class TelegramClient {

  @Value("${spring.application.parameters.telegram.chat-id}")
  private String chatId;

  @Value("${spring.application.parameters.telegram.bot-id}")
  private String botId;

  public Mono<Void> sendMessage(String text) {
    return WebClient
      .create()
      .get()
      .uri(uriBuilder -> uriBuilder
        .scheme("https")
        .host("api.telegram.org")
        .path(format("/%s/sendMessage", botId))
        .queryParam("chat_id", chatId)
        .queryParam("text", text)
        .build())
      .retrieve()
      .bodyToMono(String.class)
      .then();
  }
}

# Telegram Output Adapter
Projeto que realiza o envio de uma mensagem a um chat do Telegram utilizando um Bot.

## Variáveis de Ambiente
1. Obrigatórias:

* CHAT_ID: id do chat do Telegram onde a mensagem será enviada
* BOT_ID: id do bot que enviará a mensagem

2. Opcionais

* KAFKA_ADDRESS: Endereço IP/DNS e porta onde está hospedado o kafka (padrão 127.0.0.1:9092)
* SERVER_PORT: Porta onde este serviço será disponibilizado (padrão 8081)

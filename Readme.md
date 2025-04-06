
markdown
Copiar código
# 💬 Chat Ponto-a-Ponto em Java

Projeto simples de terminal em Java que permite a comunicação entre dois usuários conectados via rede (ponto-a-ponto), usando sockets e threads para envio e recebimento de mensagens simultaneamente.

---

## 👥 Integrantes e Responsabilidades

- **Samantha** – Estrutura principal (`main`)
- **Rayssa** – Envio de mensagens (`gerenciarEnvio`)
- **Victor** – Recebimento de mensagens (`gerenciarRecebimento`)

---

## 🔧 Como Funciona

1. O programa pergunta seu nome, a porta para escutar e se deseja se conectar a outro cliente.
2. Se sim, pede o IP e porta do outro cliente e cria a conexão.
3. Depois, inicia duas threads:
   - Uma para **enviar mensagens**.
   - Outra para **receber mensagens**.
4. O programa também escuta conexões futuras, caso alguém queira se conectar.

---

## 💻 Execução

### 1. Compile:
```bash
javac ChatPontoAPonto.java
java ChatPontoAPonto
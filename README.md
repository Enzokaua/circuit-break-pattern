# Design Pattern - Circuit Breaker (Disjuntor)

> Este repositório contém a implementação de um padrão de projeto nomeado "Circuit Breaker", o modelo Disjuntor. Essa implementação é para fins de estudo e prática.

## 💻 Pré-requisitos

Para executar este projeto, certifique-se de ter as seguintes ferramentas configuradas no seu ambiente:

- **Java 21** ou superior;
- **Apache Maven** para gerenciamento de dependências e build do projeto;
- Editor ou IDE de sua escolha (IntelliJ IDEA, Eclipse, VS Code, etc.).
- Apache kafka implementado localmente.

## 🚀 Sobre o projeto

Esse pattern ajuda a prevenir erro em cascata, quando as principais ferramentas do sistema param de funcionar. 
Ele determinda 3 estados para a aplicação e transita entre eles, para que sobreviva diante a possíveis erros quando algum 
serviço está fora do ar.

### ✨ Funcionalidades

- Acata uma requisição
- Tenta encaminhar o índice recebido ao kafka;
- Realiza x tentativas;
- Caso as tentativas tenham excedido o valor X, ele assume um estado em X retentativas.
- Após um período de tentativas, ele irá realizar uma outra tentativa denovo ao serviço principal, reiniciando o fluxo;

### 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto;
- **Apache Maven**: Ferramenta de build e gerenciamento de dependências;
- **Apache Kafka**: Serviço de mensageria.

### Fluxo macro do pattern

 ![patternjpg](https://github.com/user-attachments/assets/2cf9e0c1-8d9e-41fa-b690-641297333de6)

## 🛠️ Configuração e Execução

1. Clone este repositório:
   ```bash
   git clone https://github.com/enzokaua/circuit-break-pattern.git

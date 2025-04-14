# Design Pattern - Singleton (Instância Única)

> Este repositório contém a implementação de um padrão de projeto chamado "Singleton", ou Instância Única. Essa implementação é para fins de estudo e prática, com foco em eficiência, segurança e clareza sobre o funcionamento interno da JVM.

## 💻 Pré-requisitos

Para executar este projeto, certifique-se de ter as seguintes ferramentas configuradas no seu ambiente:

- **Java 21** ou superior;
- Editor ou IDE de sua escolha (IntelliJ IDEA, Eclipse, VS Code, etc.).

## 🚀 Sobre o projeto

O padrão Singleton garante que apenas uma instância de uma classe seja criada em todo o ciclo de vida da aplicação. Este padrão é frequentemente usado quando um único ponto de acesso global é necessário — como um gerenciador de configuração, pool de conexões ou cache compartilhado.

Essa implementação específica utiliza uma **classe interna estática** para garantir:

- **Lazy Loading** (criação sob demanda);
- **Thread Safety** (segurança em ambiente multi-thread);
- **Eficiência**, evitando sincronizações desnecessárias.

### 🧠 Funcionamento detalhado

A estrutura da classe segue o seguinte formato:

```java
public class Singleton {
    private Singleton() {} // Construtor privado

    private static class SingletonHolder {
        public static final Singleton instance = new Singleton(); // Instância criada apenas quando necessário
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance; // Ponto de acesso à instância
    }
}

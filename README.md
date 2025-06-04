# Projeto LRU Cache em Java

## Descrição

Implementação de um cache com política **Least Recently Used (LRU)** em Java, utilizando uma combinação de **HashMap** e **lista duplamente ligada** para garantir operações rápidas de acesso, inserção e remoção.

Essa estrutura é muito utilizada em sistemas backend para armazenar dados temporariamente e otimizar o desempenho, reduzindo acessos repetidos a dados custosos.

---

## Funcionalidades

- Armazena até uma capacidade máxima definida.
- Insere ou atualiza elementos, movendo-os para o topo da lista como "mais recentes".
- Remove automaticamente o elemento menos usado (LRU) quando o cache estiver cheio.
- Permite recuperar valores pelo `key`.
- Método para imprimir o estado atual do cache.


## Como compilar e executar (sem Maven)

1. Abra o terminal no VSCode.

2. Compile os arquivos Java:

```bash
cd src/main/java
javac cache/LRUCache.java cache/TestLRUCache.java


## Execute o projeto de teste

java cache.TestLRUCache

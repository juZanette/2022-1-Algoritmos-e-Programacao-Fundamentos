# Projeto Conta Corrente

**Autor:** Júlia Faccio Zanette  
**Disciplina:** Algoritmos e Programação - Fundamentos

## 📝 Descrição do Projeto

Este projeto implementa um sistema bancário simples com funcionalidades de gestão de conta corrente e um módulo adicional para cadastro e cálculo de impostos de imóveis. Foi desenvolvido como parte da disciplina de Algoritmos e Programação - Fundamentos.

## ✨ Funcionalidades

### Sistema Bancário
- **Criação de Conta**: Criação de conta corrente com número e saldo inicial
- **Operações de Depósito**: Adicionar fundos à conta com validação
- **Operações de Saque**: Retirar fundos com verificação de saldo
- **Consulta de Informações**: Exibir detalhes da conta e saldo atual

### Gestão de Imóveis
- **Cadastro de Imóveis**: Registro de imóveis com endereço, valor de venda e aluguel
- **Classificação de Imóveis**: Distinção entre imóveis novos e usados
- **Cálculo de Impostos**: Cálculo automático baseado no tipo do imóvel
  - Imóveis novos: 15% sobre o valor de venda
  - Imóveis usados: 10% sobre o valor do aluguel

## 🚀 Como Executar

### Pré-requisitos
- Java Development Kit (JDK) instalado
- BlueJ IDE (recomendado) ou qualquer IDE Java

### Passos para execução

1. **Compile os arquivos Java:**
   ```bash
   javac *.java
   ```

2. **Execute a classe Principal:**
   ```bash
   java Principal
   ```

3. **Siga as instruções do menu interativo:**
   - Insira número e saldo inicial da conta
   - Escolha operações bancárias (saque, depósito, consulta)
   - Cadastre 3 imóveis com suas informações
   - Visualize o cálculo automático dos impostos

## 📋 Fluxo da Aplicação

1. **Criação da Conta:**
   - Solicita número da conta (deve ser positivo)
   - Solicita saldo inicial (deve ser positivo)

2. **Menu Bancário:**
   - Opção 1: Efetuar saque
   - Opção 2: Efetuar depósito
   - Opção 3: Imprimir informações da conta
   - Opção 4: Sair do menu

3. **Cadastro de Imóveis:**
   - Cadastro de 3 imóveis obrigatório
   - Para cada imóvel: endereço, valor de venda, valor de aluguel, condição (novo/usado)
   - Exibição automática das informações e impostos calculados

## 💡 Conceitos de Programação Aplicados

- **Programação Orientada a Objetos**: Classes, objetos, encapsulamento
- **Encapsulamento**: Atributos privados com métodos getters e setters
- **Validação de Entrada**: Tratamento de dados inválidos e verificação de entradas em tempo real
- **Design de Interface**: Sistema de menu amigável e interativo
- **Lógica de Negócio**: Cálculos matemáticos aplicados (impostos, operações bancárias)
- **Manipulação de Strings**: Formatação de saídas e métodos toString() personalizados
- **Tratamento de Exceções**: Gestão de erros de entrada
- **Estruturas de Controle**: Loops, condicionais e validações
- **Métodos Estáticos**: Utilização da classe Teclado para entrada de dados

---



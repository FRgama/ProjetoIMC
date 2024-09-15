# Calculadora de IMC

## Descrição
Este projeto calcula o Índice de Massa Corporal (IMC) com base no peso e altura fornecidos. Ele foi desenvolvido como parte de um projeto de ciência da computação, com o objetivo de aplicar conceitos básicos de programação e lógica.

## Tecnologias Utilizadas
- Linguagem: Java
- IDE: Android Studio

## Como Executar o Projeto
Existem duas formas principais de executar o projeto:

### 1. Executar via APK
1. Faça o download do arquivo APK disponível na pasta raiz deste repositório.
2. Transfira o APK para um dispositivo Android.
3. No dispositivo Android, vá até as "Configurações", habilite a instalação de aplicativos de fontes desconhecidas (caso ainda não esteja ativada).
4. Instale o APK e abra o aplicativo.

### 2. Executar via Android Studio
1. Faça o download ou clone este repositório.
2. Abra o Android Studio.
3. No Android Studio, selecione "Open an existing project" e escolha o diretório do projeto.
4. Conecte um dispositivo Android ou utilize um emulador.
5. Clique em "Run" ou pressione **Shift + F10** para compilar e executar o projeto.

Certifique-se de que você tenha o **JDK** e o **Android SDK** configurados corretamente no Android Studio.

## Como Usar
1. O usuário será solicitado a inserir o peso em quilogramas e a altura em metros.
2. O aplicativo calculará automaticamente o IMC ao pressionar o botão correspondente.
3. O resultado será exibido na tela junto com uma classificação (Abaixo do Peso, Peso Normal, Sobrepeso, Obesidade, etc.).
4. O botão "Limpar" permite reiniciar a calculadora para novas entradas.

## Estrutura do Código
- O código principal está localizado no arquivo:  
  `ProjetoIMC/04 - Text/app/src/main/java/br/com/aula/text/MainActivity.java`
  
  No **MainActivity.java**, existem três funções principais:
  - `calcular()`: Faz o cálculo do IMC com base nas entradas do usuário (peso e altura).
  - `limpar()`: Limpa os campos de entrada para permitir novos cálculos.
  - `resultado()`: Classifica o IMC de acordo com as faixas padrão (abaixo do peso, normal, sobrepeso, etc.).

## Contribuidores
- Leonardo Ferreira da Silva — 23025389
- Maria Kassandra Alves Gomes — 23025405
- Rodrigo Gama — 23025472

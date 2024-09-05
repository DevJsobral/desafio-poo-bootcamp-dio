# Código de Administração de Bootcamp

Este projeto é uma melhoria e aprimoramento do código proposto em um bootcamp da DIO e Claro. O foco é na administração de um Bootcamp, com várias melhorias na robustez e lógica do código, além da implementação de Lombok e Exceptions personalizadas.

## 📜 Descrição

O "Código de Administração de Bootcamp" gerencia a adição de conteúdos e inscrição de desenvolvedores em um Bootcamp, com as seguintes melhorias:

- **Adição automática de conteúdos**: Novos conteúdos são automaticamente adicionados à lista de conteúdos inscritos dos desenvolvedores e somente cursos não existentes são adicionados ao Bootcamp.
- **Polimorfismo**: O método de adicionar conteúdos ao Bootcamp aceita tanto uma coleção de conteúdos quanto um conteúdo individual.
- **Área de conhecimento**: Conteúdos e o Bootcamp devem pertencer à mesma área de conhecimento, definida em um Enum.
- **Quantidade mínima de conteúdo**: Definição de um mínimo de conteúdos que o Bootcamp deve ter para permitir inscrições.
- **Notificação de progresso**: Ao finalizar a progressão no Bootcamp, o aluno recebe uma notificação sobre a conclusão dos conteúdos e a XP adquirida.
- **Uso de Lombok**: Implementação de Lombok para reduzir o código boilerplate em todas as classes.

## 🛠 Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada no desenvolvimento.
- **Lombok**: Biblioteca para reduzir o código boilerplate.
- **Maven**: Gerenciador de dependências.

## 🔧 Instalação e Configuração

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/DevJsobral/desafio-poo-bootcamp-dio.git
   cd codigo-administracao-bootcamp
2. **Compile o projeto utilizando Maven:**
   ```bash
   mvn clean install
3. **Execute a aplicação:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.dio.desafio.dominio.Main"


# **App Hamburgueria**
&gt; Desenvolvido para cadastrar no banco de dados, logar, acessar o cardápio e ser redirecionado ao whatsapp da hamburgueria.

## Descrição
O **App Hamburgueria** permite ao usuário se cadastrar na hamburgueria, para ter acesso ao cardápio e fazer o seu pedido.

## Funcionalidades
- [x] Entrada de dados (username, nome, senha, email, telefone)
- [x] Interface simples e intuitiva

## Tecnologias Utilizadas
- [x] **Android Studio** (Koala | 2024.1.2)
- [x] **Java** para desenvolvimento
- [x] **RelativeLayout, ScrollView e CoordinatorLayout** para interface responsiva
- [x] **TextView** e **EditText** para entrada e exibição de dados
      
## Como Rodar o Projeto
Siga os passos abaixo para rodar o projeto localmente:

1. Clone este repositório:
```bash
git clone https://github.com/Klaiancdrosa/AppHamburgueria.git
```
2. Abra o projeto no Android Studio.
3. Compile e execute o projeto em um emulador ou dispositivo físico.
   
## Estrutura do Projeto
```bash
├── app
│ ├── src
│ │ ├── main
│ │ │ ├── java
| | | | |── br.ulbra.apphamburgueria
│ │ │ │ | ├── CadastrarActivity.java # Atividade principal para realizar o cadastro do cliente ao banco de dados.
│ │ │ │ | ├── DBHelper.java # Banco de dados aonde o cliente é cadastrado.
│ │ │ │ | ├── MainActivity.java # Atividade aonde o cliente é logado e redirecionado para o cardápio da hamburgueria.
│ │ │ │ | ├── MenuHActivity.java # Permite o cliente acessar o cardápio e ser redirecionado para o whatsapp da hamburgueria. 
| │ │ │ ├── res
| | | | ├── drawable # imagens e icones utilizados na tela principal
│ │ │ │ ├── layout
│ │ │ │ | ├── telalogin.xml # Layout de tela de login do cliente  
│ │ │ │ | ├── telacadastro.xml # Layout da tela de cadastro do cliente
│ │ │ │ │ ├── activity_main2.xml # Layout do cardápio da hamburgueria
│ │ │ │ └── values
│ │ │ │ ├── strings.xml # Strings usadas no app
│ │ │ │ ├── colors.xml # Cores definidas no projeto
│ └── build.gradle # Configuração do Gradle
└── README.md # Este arquivo
```

## Design e Prototipage
A interface do app foi criada usando **RelativeLayout, ScrollView e CoordinatorLayout**;
O design é minimalista e fácil de usar, com foco na simplicidade e entendimento.

## Telas do App Hamburgueria
**Tela Principal**
Tela principal aonde o usuário, caso não tenha login, deverá acessar o cadastro no botão a baixo.

![image](https://github.com/user-attachments/assets/a7d19404-c08c-4c71-8b34-7647bb128ca0)

**Tela Secundária**
Tela aonde o cliente deverá realizar o cadastro para poder logar no app.

![image](https://github.com/user-attachments/assets/9d497e47-087d-4ebf-a1eb-1233e5a715f4)

**Tela Cardápio**
Tela que permite ao usuário visualizar o cardápio da hamburgueria e ser redicionado ao whatsapp da hamburgueria para fazer o pedido.

![image](https://github.com/user-attachments/assets/654b9e29-c06e-4e84-bd7e-0c9ed354222a)

![image](https://github.com/user-attachments/assets/8e79396e-a299-4a7a-8109-0153c1dde43f)

## Desenvolvedores
**Klaian Conceição da Rosa** - Desenvolvedor - [GitHub](https://github.com/Klaiancdrosa)

## Licenças
Este projeto está licenciado sob os termos da licença MIT. Para mais detalhes, veja o arquivo
[LICENSE](LICENSE).

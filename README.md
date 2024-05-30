<h1 align="center">Gerenciador de  Matriculas</h1>

<h3 align="center"> Este é um aplicativo para responsáveis por academias, onde podem cadastrar alunos, deletar, e se caso precise, editar algumas informações dos mesmos.</h3> 

#

Na tela inicial é possível que os responsáveis possam cadastrar (botão na parte inferior direita), ver a quantidade de alunos cadastrados e as informações de cada aluno. 

![principal](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/1b6921ac-e098-4bd0-847e-a79ca25e9399)

No card de cada aluno é possível ver algumas informações para identificar o aluno e também, para que possamos editar e excluir.

#

Na tela de cadastro temos os campos a serem preenchidos com as devidas informações verídicas do aluno.

![cadastrar](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/01fb5415-d65d-433e-88f8-f1a0feb2dab8)

Ao clicar no botão "cadastrar", o programa verifica se os campos foram preenchidos seguindo nossa regra de negócio, se sim, esta tela é fechada, o aluno é cadastrado no nosso banco de dados e o usuário direcionado diretamente para a tela inicial, onde de imediato, poderá ver o aluno recém cadastrado. 

#

Na tela de atualizar conseguimos editar o nome, esporte e dia, uma vez que o CPF não é modificável e na nossa regra de negócio, só é possível adicionar um cpf válido.
Então o CPF uma vez digitado e validado, não há como ser modificado.

![atualizar](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/0202e517-492f-4439-beb4-34e273764622)

Ao clicar no botão "Atualizar", o usuário será direcionado diretamente para a tela inicial, onde será mostrado as informações atualizadas instataneamente.

#

Ao tentar excluir um aluno, antes é mostrado um aviso para confirmação.

![excluir](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/9a8538c8-27d6-4ff4-809c-0a91266626f6)

Se confirmarmos ("Sim"), o aluno é deletado. se não ("Cancelar"), o aviso é fechado e não ocorre nenhuma modificação. 

#

## Funcionalidades
 * Cadastrar alunos
 * Buscar todos os alunos
 * Atualizar as informações dos alunos
 * Deletar alunos

#

## Tecnologias
  * Android
  * Kotlin
  * Android Studio
  * SQLite
  * ROOM
  * Arquitetura MVVM

#

## Autor

- [@JvAvelar](https://www.github.com/JvAvelar)

# 

Caso tenha interesse em utilizar o app, entre em contato para receber o arquivo apk para instalação.


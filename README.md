<h1 align="center">Gerenciador de  Matriculas</h1>

<h3 align="center"> Este é um aplicativo para responsáveis por academias, onde podem cadastrar alunos, deletar, e se caso precise, editar algumas informações dos mesmos.</h3> 

#

Na tela inicial é possível que os responsáveis possam cadastrar (botão na parte inferior direita), ver a quantidade de alunos cadastrados e as informações de cada aluno. 

![image](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/d3f1e4cf-8ccd-4ffd-8a79-806cc4a1062c)

No card de cada aluno é possível ver algumas informações para identificar o aluno e também, para que possamos editar e excluir.

#

Na tela de cadastro temos os campos a serem preenchidos com as devidas informações verídicas do aluno.

![image](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/2870e8c6-d279-45ab-92b1-cdb40043852f)

Ao clicar no botão "cadastrar", o programa verifica se os campos foram preenchidos seguindo nossa regra de negócio, se sim, esta tela é fechada, o aluno é cadastrado no nosso banco de dados e o usuário direcionado diretamente para a tela inicial, onde de imediato, poderá ver o aluno recém cadastrado. 

#

Na tela de atualizar conseguimos editar o nome, esporte e dia, uma vez que o CPF não é modificável e na nossa regra de negócio, só é possível adicionar um cpf válido.
Então o CPF uma vez digitado e validado, não há como ser modificado.

![image](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/1d48143f-58f5-41c8-ae48-b1929243831b)

Ao clicar no botão "Atualizar", o usuário será direcionado diretamente para a tela inicial, onde será mostrado as informações atualizadas instataneamente.

#

Ao tentar excluir um aluno, antes é mostrado um aviso para confirmação.

![image](https://github.com/JvAvelar/app-gerenciador-matriculas-alunos/assets/123327674/6f0b719e-6a24-4523-87b8-b1437e9e2904)

Se confirmarmos ("Sim"), o aluno é deletado. se não ("Cancelar"), o aviso é fechado e não ocorre nenhuma modificação. 

#

## Funcionalidades
 * Cadastrar alunos
 * Buscarn todos os alunos
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


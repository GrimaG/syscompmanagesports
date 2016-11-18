Feature: User Login
 In order to use the system
 I want to login in my account

  

 Scenario Outline: Login 
  Given the user is trying to  login <login>  at main page
   When insert the password <password> 
   And click at login button
   Then return a  information <info> saying if the user is logged or not
  Examples: 
  |  login   | password | info|
  | gugaloid | 1234     | Bem vindo     |
  | gugaloid | 37654    | Senha Inválida|
  | Xalalala | 37654    | Usuário inválido|

 
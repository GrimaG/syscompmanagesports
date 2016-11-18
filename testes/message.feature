Feature: Message
 In order to communicate with others users
 I want to change messages

  

 Scenario Outline: Send message 
  Given the athlete search for others users
  And click to vizualise an user profile
  And click to send message
   When insert the message <message> 
   And click at send button
   Then return an information <info> saaying if the user is sent or not
  Examples: 
  |  Message   |        info          |
  | test123    | Enviado com sucesso! |
  |  | O Canpo de Mensagem Deve ser preenchido.  |

 
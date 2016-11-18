Feature: Event
 In order to new event created
 I want to participate 

  
Scenario Outline: Create a new Event
 Given the user have a group
 And clicks to creat a new event
  When he insert a name <name> of this new event
  And date <date>
  And category <category> 
  And adress <local>
  And clicks at create button
  Then must show an info <info>
 Examples: 
 |  name  | date      | category | local| info|
 | xalala | 21/01/2016| beginner| somewhere over the rainbow | Evento criado com sucesso! |
 | xalala |           | beginner| somewhere over the rainbow | Todos os campos devem ser preenchidos |
 | xalala | 21/01/2016|         | somewhere over the rainbow | Todos os campos devem ser preenchidos |
 | xalala |21/01/2016 | beginner|                            | Todos os campos devem ser preenchidos |


 

 Scenario Outline:  Associating a new Event
  Given the athlete search for events
  And would like to enjoy in a competition, so he select it
   When he clicks to participate
   Then return an information <info> if was aproved
  Examples: 
  |        info                |
  | Você entrou neste evento   |
  | O evento informado não abrange seu esporte ou nivel |

  Scenario Outline:  Desassociating from an Event
  Given the athlete search for events who he had cadastrated
  And would like to leave form a competition, so he select it
   When he clicks to leave
   Then return an information <info> if was aproved
  Examples: 
  |        info                |
  | Você entrou saiu do evento   |
